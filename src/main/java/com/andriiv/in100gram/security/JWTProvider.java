package com.andriiv.in100gram.security;

import com.andriiv.in100gram.entities.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman Andriiv (26.04.2023 - 12:54)
 */
@Component
public class JWTProvider {
    public static final Logger LOG = LoggerFactory.getLogger(JWTProvider.class);

    public String generateToken(Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expireDate = new Date(now.getTime() + SecurityConstants.EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("id", userId);
        claimsMap.put("username", user.getEmail());
        claimsMap.put("firstname", user.getFirstName());
        claimsMap.put("lastname", user.getLastName());

        return Jwts.builder()
                .setSubject(userId)
                .addClaims(claimsMap)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        try {

            Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token);
            return true;

        } catch (SignatureException | MalformedJwtException |
                 ExpiredJwtException | UnsupportedJwtException |
                 IllegalArgumentException e) {

            LOG.error(e.getMessage());
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();

        String id = (String) claims.get("id");
        return Long.parseLong(id);
    }
}

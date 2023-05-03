package com.andriiv.in100gram.security;

/**
 * Created by Roman Andriiv (26.04.2023 - 12:38)
 */
public class SecurityConstants {

    public static final String SING_UP_URLS = "/api/auth/**";
    public static final String SECRET = "SecretKeyGenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 900_000;
}

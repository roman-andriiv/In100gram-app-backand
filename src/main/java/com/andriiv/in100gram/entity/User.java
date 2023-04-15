package com.andriiv.in100gram.entity;

import com.andriiv.in100gram.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, updatable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 3000)
    private String password;

    @Column(columnDefinition = "text")
    private String bio;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> role = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

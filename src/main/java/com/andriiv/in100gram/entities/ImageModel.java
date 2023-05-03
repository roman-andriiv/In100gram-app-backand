package com.andriiv.in100gram.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

/**
 * Created by Roman Andriiv (16.04.2023 - 20:08)
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "images")
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "BYTEA")
    private byte[] imageBytes;

    @JsonIgnore
    private Long userId;

    @JsonIgnore
    private Long postId;
}

package com.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

    @Column(length = 1000)
    private String description;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;


}
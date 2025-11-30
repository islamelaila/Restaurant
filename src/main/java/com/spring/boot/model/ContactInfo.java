package com.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String message;



    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("contactInfos")
    private Users users;


}

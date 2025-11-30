package com.spring.boot.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChefDto {

    private Long id;

    private String name;

    private String specialty;

    private String logoPath;

    private String facebookLink;

    private String tweitterLink;

    private String instagramLink;
}

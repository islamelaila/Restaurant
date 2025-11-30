package com.spring.boot.dto;

import com.spring.boot.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDetailsDto {

    private Long id;

    private Integer age;

    private String phoneNumber;

    private String address;

    private String city;

    private String country;

    private String gender;

    private String jobTitle;

    private String bio;


    private Users users;
}

package com.spring.boot.dto;

import com.spring.boot.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDto {

    private Long id;

    private String name;

    private String email;

    private String subject;

    private String message;

    private Users users;

}

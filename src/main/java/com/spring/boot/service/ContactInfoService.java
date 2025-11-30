package com.spring.boot.service;
import com.spring.boot.dto.ContactInfoDto;

public interface ContactInfoService {
    ContactInfoDto saveContactInfo(ContactInfoDto contactInfoDto);
}

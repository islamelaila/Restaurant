package com.spring.boot.controller;
import com.spring.boot.dto.ContactInfoDto;
import com.spring.boot.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/contact")
public class ContactInfoController {


    private ContactInfoService contactInfoService;


    @Autowired
    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @PostMapping("/save")
    public ResponseEntity<ContactInfoDto> saveContactInfo(@RequestBody ContactInfoDto contactInfoDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/contact/save")).body(contactInfoService.saveContactInfo(contactInfoDto));
    }
}

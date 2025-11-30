package com.spring.boot.service.impl;
import com.spring.boot.dto.ContactInfoDto;
import com.spring.boot.mapper.ContactInfoMapper;
import com.spring.boot.model.ContactInfo;
import com.spring.boot.repo.ContactInfoRepo;
import com.spring.boot.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;


@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private ContactInfoRepo contactInfoRepo ;

    private ContactInfoMapper contactInfoMapper;

    @Autowired
    public ContactInfoServiceImpl(ContactInfoRepo contactInfoRepo , ContactInfoMapper contactInfoMapper) {
        this.contactInfoRepo = contactInfoRepo;
        this.contactInfoMapper = contactInfoMapper;
    }



    @Override
    public ContactInfoDto saveContactInfo(ContactInfoDto contactInfoDto) {
        if (Objects.nonNull(contactInfoDto.getId())){
            throw new RuntimeException("ContactInfo id should be null");
        }

        ContactInfo contactInfo = contactInfoRepo.save(contactInfoMapper.toEntity(contactInfoDto));
        contactInfoDto.setId(contactInfo.getId());
        return contactInfoMapper.toDto(contactInfo);


    }
}

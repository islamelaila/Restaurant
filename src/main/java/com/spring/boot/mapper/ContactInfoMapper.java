package com.spring.boot.mapper;
import com.spring.boot.dto.ContactInfoDto;
import com.spring.boot.model.ContactInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactInfoMapper {

    ContactInfo toEntity(ContactInfoDto contactInfoDto);

    ContactInfoDto toDto(ContactInfo contactInfo);

    List<ContactInfoDto> toDto(List<ContactInfo> contactInfoList);

    List<ContactInfo> toEntity(List<ContactInfoDto> contactInfoDtoList);
}

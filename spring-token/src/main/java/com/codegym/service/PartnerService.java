package com.codegym.service;
import com.codegym.dto.PartnerDto;
import com.codegym.dto.RoleDto;
;
import com.codegym.entity.Partner;
import com.codegym.entity.Role;

import com.codegym.repository.IPartnerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerService implements IPartnerService {
    private final IPartnerRepository partnerRepository;

    @Override
    public List<PartnerDto> getPartners() {
        List<PartnerDto> partnerDtoList = new ArrayList<>();
        List<Partner> listPartners = this.partnerRepository.findAll();
        listPartners.forEach(partner -> partnerDtoList.add(new PartnerDto(partner.getId(), partner.getFirstName(),
                partner.getLastName(), partner.getEmail(), partner.getAddress(),
                partner.getImage(), partner.getUsername(), partner.getPassword(), partner.isStatus(),
                partner.isActive(), partner.getType(), partner.getDescription(), new RoleDto(partner.getRole().getId(),
                partner.getRole().getName()))));
        return partnerDtoList;
    }

    @Override
    public PartnerDto savePartner(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        partner.setFirstName(partnerDto.getFirstName());
        partner.setLastName(partnerDto.getLastName());
        partner.setEmail(partnerDto.getEmail());
        partner.setPassword(partnerDto.getPassword());
        partner.setUsername(partnerDto.getUsername());
        partner.setAddress(partnerDto.getAddress());
        partner.setStatus(partnerDto.isStatus());
        partner.setActive(partnerDto.isActive());
        partner.setImage(partnerDto.getImage());
        partner.setType(partnerDto.getType());
        partner.setDescription(partnerDto.getDescription());
        partner.setRole(new Role(partnerDto.getRole().getId(), partnerDto.getRole().getName()));
        partnerRepository.save(partner);
        return partnerDto;
    }

    @Override
    public void deletePartner(Long id) {
        PartnerDto partnerDto = getPartner(id);
        Partner partner = new Partner(partnerDto.getId(), partnerDto.getFirstName(),
                partnerDto.getLastName(), partnerDto.getEmail(),
                partnerDto.getAddress(), partnerDto.getImage(),
                partnerDto.getUsername(), partnerDto.getPassword(),
                partnerDto.isStatus(), partnerDto.isActive(),
                partnerDto.getType(), partnerDto.getDescription(),
                new Role(partnerDto.getRole().getId(), partnerDto.getRole().getName()));
        partnerRepository.removePartnerById(partner.getId());
    }


    @Override
    public PartnerDto getPartner(Long id) {
        Partner partner = this.partnerRepository.findById(id).get();
        PartnerDto partnerDto = new PartnerDto(partner.getId(), partner.getFirstName(),
                partner.getLastName(), partner.getEmail(), partner.getAddress(),
                partner.getImage(), partner.getUsername(), partner.getPassword(), partner.isStatus(),
                partner.isActive(), partner.getType(), partner.getDescription(), new RoleDto(partner.getRole().getId(),
                partner.getRole().getName()));
        return partnerDto;
    }
    @Override
    public List<PartnerDto> getPartnerByAddress(String address){
        List<PartnerDto> partnerDtos = new ArrayList<>();
        for (PartnerDto partnerDto : getPartners()) {
            if(getDistrict(partnerDto.getAddress()).equals(address)){
                partnerDtos.add(partnerDto);
            }
        }
        return partnerDtos;
    }

    public String getDistrict(String address){
        String[] words = address.trim().split(",");
        return words[1].trim();
    }
}
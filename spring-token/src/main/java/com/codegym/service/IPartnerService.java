package com.codegym.service;

import com.codegym.dto.PartnerDto;
import com.codegym.entity.Partner;
import com.codegym.entity.Product;

import java.util.List;

public interface IPartnerService {
    List<PartnerDto> getPartners();
    PartnerDto getPartner(Long id);
    void deletePartner(Long id);

    PartnerDto savePartner(PartnerDto partner);
    List<PartnerDto> getPartnerByAddress(String address);
}

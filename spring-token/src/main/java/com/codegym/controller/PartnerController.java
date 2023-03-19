package com.codegym.controller;

import com.codegym.dto.PartnerDto;
import com.codegym.repository.IPartnerRepository;
import com.codegym.service.IPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PartnerController {
    private final IPartnerService partnerService;
    @GetMapping("/partners")
    public ResponseEntity<List<PartnerDto>> getPartners(){
        return ResponseEntity.ok().body(partnerService.getPartners());
    }

    @PostMapping("/partner/save")
    public ResponseEntity<PartnerDto> savePartner(@RequestBody PartnerDto partnerDto){
        return ResponseEntity.created(null).body(partnerService.savePartner(partnerDto));
    }

}

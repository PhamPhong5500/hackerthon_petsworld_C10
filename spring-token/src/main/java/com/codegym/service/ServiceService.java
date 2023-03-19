package com.codegym.service;

import com.codegym.entity.Service;
import com.codegym.repository.IServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService implements IServiceService{
    private final IServiceRepository serviceRepository;
    @Override
    public List<Service> getServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Service saveCustomer(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {

    }

    @Override
    public Service getService(Long id) {
        return serviceRepository.findById(id).get();
    }
    private Service getServiceByName(String name){
      return   serviceRepository.findServiceByName(name);
    }
}

package com.codegym.service;

import com.codegym.dto.CustomerDto;
import com.codegym.entity.Service;

import java.util.List;

public interface IServiceService {
    List<Service> getServices();
    Service saveCustomer(Service service);
    void deleteService(Long id);
    Service getService(Long id);
}

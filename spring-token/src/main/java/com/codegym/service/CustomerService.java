package com.codegym.service;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.PartnerDto;
import com.codegym.dto.RoleDto;
import com.codegym.entity.Customer;
import com.codegym.entity.Role;
import com.codegym.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository;
    private final IPartnerService partnerService;
    @Override
    public List<CustomerDto> getCustomers() {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        List<Customer> listCustomers = this.customerRepository.findAll();
        listCustomers.forEach(customer -> customerDtoList.add(new CustomerDto(customer.getId(), customer.getFirstName(),
                customer.getLastName(), customer.getEmail(), customer.getGender(), customer.getAddress(),
                customer.getImage(), customer.getUsername(), customer.getPassword(), customer.isStatus(),
                customer.isActive(), new RoleDto(customer.getRole().getId(), customer.getRole().getName()))));
        return customerDtoList;
    }
    @Override
    public List<PartnerDto> searchPartnerByAddress(Long id) {
        CustomerDto customerDto = getCustomer(id);
        return partnerService.getPartnerByAddress(getDistrict(customerDto.getAddress()));
    }

    public String getDistrict(String address){
        String[] words = address.trim().split(",");
        return words[1].trim();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setLastName(customerDto.getLastName());
        customer.setGender(customerDto.getGender());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setAddress(customerDto.getAddress());
        customer.setStatus(customerDto.isStatus());
        customer.setActive(customerDto.isActive());
        customer.setImage(customerDto.getImage());
        customer.setRole(new Role(customerDto.getId(), customerDto.getRole().getName()));
        customerRepository.save(customer);
      return  customerDto;
    }

    @Override
    public void deleteCustomer(Long id) {
        this.customerRepository.removeCustomerById(id);
    }


    @Override
    public CustomerDto getCustomer(Long id) {
       Customer customer =  this.customerRepository.findById(id).get();
       CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getFirstName(),
               customer.getLastName(), customer.getEmail(), customer.getGender(), customer.getAddress(),
               customer.getImage(), customer.getUsername(), customer.getPassword(), customer.isStatus(),
               customer.isActive(), new RoleDto(customer.getRole().getId(), customer.getRole().getName())) ;
       return customerDto;
    }
}

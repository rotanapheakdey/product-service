package kh.com.bbu.product_service.mappers;


import kh.com.bbu.product_service.dto.request.EmployeeRequest;
import kh.com.bbu.product_service.dto.response.EmployeeResponse;
import kh.com.bbu.product_service.entities.EmployeeEntity;

import org.springframework.stereotype.Component;
@Component
public class EmployeeMapper {
    public EmployeeEntity toEntity(EmployeeRequest request){
        if(request==null) return null;
        return EmployeeEntity.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .gender(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .salary(request.getSalary())
                .build();
    }
    public EmployeeResponse toResponse(EmployeeEntity request){
        if(request==null) return null;

        return EmployeeResponse.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .gender(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .salary(request.getSalary())
                .build();
    }
}

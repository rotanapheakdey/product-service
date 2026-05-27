package kh.com.bbu.product_service.service.impl;


import kh.com.bbu.product_service.dto.request.EmployeeRequest;
import kh.com.bbu.product_service.dto.response.EmployeeResponse;
import kh.com.bbu.product_service.entities.EmployeeEntity;
import kh.com.bbu.product_service.mappers.EmployeeMapper;
import kh.com.bbu.product_service.repository.EmployeeRepository;
import kh.com.bbu.product_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse>getAllEmployees(){
        List<EmployeeResponse> list = new ArrayList<>();
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        employeeList.forEach((data)->{
            EmployeeResponse employeeResponse = employeeMapper.toResponse(data);
            list.add(employeeResponse);
        });
        return list;
    }


    @Override
    public EmployeeResponse getEmployeeById(int id){
        EmployeeEntity entity = employeeRepository.findById(id);
        if (entity==null){
            throw new RuntimeException("Employee not found!");

        }
        return employeeMapper.toResponse(entity);
    }
    @Override
    public void createEmployee(EmployeeRequest request){
        employeeRepository.save(employeeMapper.toEntity(request));
    }

    @Override
    public void update(EmployeeRequest request){
        employeeRepository.update(employeeMapper.toEntity(request));
    }

    @Override
    public void delete(int id){
        employeeRepository.deleteById(id);
    }
}

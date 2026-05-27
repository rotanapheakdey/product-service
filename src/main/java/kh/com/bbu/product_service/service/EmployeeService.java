package kh.com.bbu.product_service.service;

import kh.com.bbu.product_service.dto.request.EmployeeRequest;
import kh.com.bbu.product_service.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getEmployeeById(int id);
    void createEmployee(EmployeeRequest request);
    void update(EmployeeRequest request);
    void delete (int id);
}

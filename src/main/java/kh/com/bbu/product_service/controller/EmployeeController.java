package kh.com.bbu.product_service.controller;


import kh.com.bbu.product_service.dto.request.EmployeeRequest;
import kh.com.bbu.product_service.dto.response.EmployeeResponse;
import kh.com.bbu.product_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping ("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){

        return new ResponseEntity<>(
                employeeService.getAllEmployees(), HttpStatus.OK
        );
    }

    @GetMapping("/{employee-id}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable("employee-id") int id
    ){
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest request){
        employeeService.createEmployee(request);
        return new ResponseEntity<>("Employee Registered!!", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeeRequest request
    ){
        request.setId(id);
        employeeService.update(request);
        return new ResponseEntity<>("Employee Updated!!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
        return new ResponseEntity<>("Employee Deleted!!", HttpStatus.OK);
    }
}




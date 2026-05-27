package kh.com.bbu.product_service.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String address;
    private Double salary;
}

package kh.com.bbu.product_service.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String address;
    private Double salary;
}

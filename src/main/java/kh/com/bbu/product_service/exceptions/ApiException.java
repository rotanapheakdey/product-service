package kh.com.bbu.product_service.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException{

    private String error;
    private String message;

    public ApiException(){}

    public ApiException(String error, String message){
        super(message);
        this.error = error;
        this.message= message;
    }
}

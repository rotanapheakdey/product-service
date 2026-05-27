package kh.com.bbu.product_service.repository;

import kh.com.bbu.product_service.entities.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class EmployeeRepository {
    private List<EmployeeEntity> employeeEntities = new ArrayList<>();
    public EmployeeRepository() {
        employeeEntities.add(
                new EmployeeEntity(1, "Rotana", "Pheakdey", "123@gmail.com", "M", "123123", "PP",250.00 )
        );
        employeeEntities.add(
                new EmployeeEntity(1, "Bopa", "Devi", "bopa.devi@mail.com", "Female", "098765432", "Siem Reap", 600.00)
        );
    }
    public List<EmployeeEntity>findAll(){
        return employeeEntities;
    }
    public EmployeeEntity findById(int id){
        for (EmployeeEntity data: employeeEntities){
            if (data.getId()==id){
                return data;
            }
        }
        return null;
    }
    public void save(EmployeeEntity request){
        request.setId(employeeEntities.size()+1);
        employeeEntities.add(request);

    }
    public void update (EmployeeEntity request){
        for(int i= 0; i < employeeEntities.size(); i++){
            if(employeeEntities.get(i).getId()==request.getId()){
                employeeEntities.set(i, request);
                return;
            }
        }
    }
    public void deleteById(int id){
        employeeEntities.removeIf(employeeEntity -> employeeEntity.getId()==id);
    }
}

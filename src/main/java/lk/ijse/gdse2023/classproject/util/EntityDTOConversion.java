package lk.ijse.gdse2023.classproject.util;
import lk.ijse.gdse2023.classproject.dto.EmployeeDTO;
import lk.ijse.gdse2023.classproject.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {

    private final ModelMapper modelMapper;
    EntityDTOConversion(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Employee getEmpEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO, Employee.class);
    }
    public EmployeeDTO getEmpDTO(Employee employee){
        return modelMapper.map(employee,EmployeeDTO.class);
    }
}

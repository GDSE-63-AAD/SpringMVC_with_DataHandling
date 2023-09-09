package lk.ijse.gdse2023.classproject.service.util;

import lk.ijse.gdse2023.classproject.dto.EmployeeDTO;
import lk.ijse.gdse2023.classproject.entity.Employee;
import lk.ijse.gdse2023.classproject.repository.EmployeeRepository;
import lk.ijse.gdse2023.classproject.service.EmpService;
import lk.ijse.gdse2023.classproject.util.EntityDTOConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class EmpServiceIMPL implements EmpService {

    public final EmployeeRepository employeeRepository;
    public final EntityDTOConversion conversion;

    public EmpServiceIMPL(EmployeeRepository employeeRepository
            ,EntityDTOConversion conversion){

        this.employeeRepository = employeeRepository;
        this.conversion = conversion;
    }

    @Override
    public EmployeeDTO saveEmployeee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmpID(UUID.randomUUID().toString());
        Employee empEntity = conversion.getEmpEntity(employeeDTO);
        employeeRepository.save(empEntity);
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(String empId) {

    }

    @Override
    public void updateEmployee(String empID, EmployeeDTO employeeDTO) {

    }

    @Override
    public EmployeeDTO getEmpbyId(String empID) {
        return null;
    }
}

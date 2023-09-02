package lk.ijse.gdse2023.classproject.service.util;

import lk.ijse.gdse2023.classproject.dto.EmployeeDTO;
import lk.ijse.gdse2023.classproject.service.EmpService;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceIMPL implements EmpService {
    @Override
    public EmployeeDTO saveEmployeee(EmployeeDTO employeeDTO) {
        return null;
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

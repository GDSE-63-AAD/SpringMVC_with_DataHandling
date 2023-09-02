package lk.ijse.gdse2023.classproject.service;

import lk.ijse.gdse2023.classproject.dto.EmployeeDTO;

public interface EmpService {
    EmployeeDTO saveEmployeee (EmployeeDTO employeeDTO);
    void deleteEmployee (String empId);
    void updateEmployee (String empID,EmployeeDTO employeeDTO);
    EmployeeDTO getEmpbyId (String empID);
}

package lk.ijse.gdse2023.classproject.service.util;

import lk.ijse.gdse2023.classproject.dto.EmployeeDTO;
import lk.ijse.gdse2023.classproject.entity.Employee;
import lk.ijse.gdse2023.classproject.exception.InvalidException;
import lk.ijse.gdse2023.classproject.exception.NotFoundException;
import lk.ijse.gdse2023.classproject.repository.EmployeeRepository;
import lk.ijse.gdse2023.classproject.service.EmpService;
import lk.ijse.gdse2023.classproject.util.EntityDTOConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceIMPL implements EmpService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityDTOConversion conversion;

    @Override
    public EmployeeDTO saveEmployeee(EmployeeDTO employeeDTO) {
        employeeDTO.setEmpID(UUID.randomUUID().toString());
        Employee empEntity = conversion.getEmpEntity(employeeDTO);
        employeeRepository.save(empEntity);
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(String empId) {
        if(!employeeRepository.existsById(empId)) throw new NotFoundException("Employee Not Found");
       employeeRepository.deleteByEmpID(empId);
    }

    @Override
    public void updateEmployee(String empID, EmployeeDTO employee) {
        Optional<Employee> tmpEmp = employeeRepository.findById(empID);
        if(!tmpEmp.isPresent()) throw new NotFoundException("Employee not found");
        tmpEmp.get().setEmpName(employee.getEmpName());
        tmpEmp.get().setEmpDep(employee.getEmpDep());
        tmpEmp.get().setEmpEmail(employee.getEmpEmail());
        tmpEmp.get().setEmpProfile(employee.getEmpProfile());
    }

    @Override
    public EmployeeDTO getEmpbyId(String empID) {
        if(!employeeRepository.existsById(empID)) throw new InvalidException("Invalid Employee ID");
        Employee employeeByEmpID = employeeRepository.findEmployeeByEmpID(empID);
        return conversion.getEmpDTO(employeeByEmpID);
    }
}

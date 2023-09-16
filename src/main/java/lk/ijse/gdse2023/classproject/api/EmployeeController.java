package lk.ijse.gdse2023.classproject.api;

import lk.ijse.gdse2023.classproject.dto.EmployeeDTO;
import lk.ijse.gdse2023.classproject.exception.InvalidException;
import lk.ijse.gdse2023.classproject.service.EmpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmpService empService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   EmployeeDTO saveEmployee(
           @RequestPart String empName,
           @RequestPart String empEmail,
           @RequestPart String empDep,
           @RequestPart byte [] empProfile){

        if(empName == null || !empName.matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (empEmail == null) {
            throw new InvalidException("Invalid Email");
        } else if (empDep == null) {
            throw new InvalidException("Invalid Department Id");
        }

        //Convert byte[] as String / Base64
        String empProfileStr = Base64.getEncoder().encodeToString(empProfile);
        EmployeeDTO tmpEmp = new EmployeeDTO();
        tmpEmp.setEmpName(empName);
        tmpEmp.setEmpEmail(empEmail);
        tmpEmp.setEmpDep(empDep);
        tmpEmp.setEmpProfile(empProfileStr);

        return empService.saveEmployeee(tmpEmp);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
   @DeleteMapping("{id}")
   void deleteEmpoyee(@PathVariable String id){
       empService.deleteEmployee(id);
   }
    @ResponseStatus(HttpStatus.NO_CONTENT)
   @PatchMapping("{id}")
   void updateEmployee(
           @PathVariable String id,
           @RequestPart String empName,
           @RequestPart String empEmail,
           @RequestPart String empDepartment,
           @RequestPart byte [] empProfile
   ){

        if(empName == null || !empName.matches("[A-Za-z ]+")){
           throw new InvalidException("Invalid Name");
       } else if (empEmail == null) {
           throw new InvalidException("Invalid Email");
       } else if (empDepartment == null) {
           throw new InvalidException("Invalid Department");
       } else if (!id.matches("[A-Fa-f0-9\\-]{36}")) {
            throw new InvalidException("Invalid Employee Id");
        }


       String empProfileStrUpdate = Base64.getEncoder().encodeToString(empProfile);
       EmployeeDTO updateEmp = new EmployeeDTO();
       updateEmp.setEmpName(empName);
       updateEmp.setEmpEmail(empEmail);
       updateEmp.setEmpDep(empDepartment);
       updateEmp.setEmpProfile(empProfileStrUpdate);
       empService.updateEmployee(id,updateEmp);
   }
   @GetMapping(value = "{empId}",produces = MediaType.APPLICATION_JSON_VALUE)
   EmployeeDTO getSelectedEmp(@PathVariable String empId){
       if(!empId.matches("[A-Fa-f0-9\\-]{36}")) throw new InvalidException("Id is invalid");
      return empService.getEmpbyId(empId);
   }
}

package lk.ijse.gdse2023.classproject.api;

import lk.ijse.gdse2023.classproject.dto.EmployeeDTO;
import lk.ijse.gdse2023.classproject.service.EmpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmpService empService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   EmployeeDTO saveEmployee(
           @RequestPart String empName,
           @RequestPart String empEmail,
           @RequestPart String empDep,
           @RequestPart byte [] empProfile){

        //Convert byte[] as String / Base64
        String empProfileStr = Base64.getEncoder().encodeToString(empProfile);
        EmployeeDTO tmpEmp = new EmployeeDTO();
        tmpEmp.setEmpName(empName);
        tmpEmp.setEmpEmail(empEmail);
        tmpEmp.setEmpDep(empDep);
        tmpEmp.setEmpProfile(empProfileStr);
        return empService.saveEmployeee(tmpEmp);

    }
   @DeleteMapping("{id}")
   void deleteEmpoyee(@PathVariable String id){
       empService.deleteEmployee(id);
   }
   @PutMapping("{id}")
   void updateEmployee(
           @PathVariable String id
           ,@RequestBody EmployeeDTO employee){
      empService.updateEmployee(id,employee);
   }
   @GetMapping(value = "{empId}",produces = MediaType.APPLICATION_JSON_VALUE)
   EmployeeDTO getSelectedEmp(@PathVariable String empId){
      return empService.getEmpbyId(empId);
   }
}

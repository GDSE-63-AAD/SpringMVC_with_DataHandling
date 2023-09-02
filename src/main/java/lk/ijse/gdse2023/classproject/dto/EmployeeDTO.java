package lk.ijse.gdse2023.classproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String empID;
    private String empName;
    private String empEmail;
    private String empDep;
    private String empProfile;

    public EmployeeDTO(String empID, String empName, String empEmail, String empDep) {
        this.empID = empID;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empDep = empDep;
    }

}

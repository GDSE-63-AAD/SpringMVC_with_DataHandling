package lk.ijse.gdse2023.classproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee implements SuperEntity{
    @Id
    private String empID;
    private String empName;
    private String empEmail;
    private String empDep;
    private String empProfile;
}

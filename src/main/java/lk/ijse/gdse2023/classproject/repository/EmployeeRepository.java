package lk.ijse.gdse2023.classproject.repository;

import lk.ijse.gdse2023.classproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee save(Employee employee);
    Employee findEmployeeByEmpID(String id);
    void deleteByEmpID(String id);
}

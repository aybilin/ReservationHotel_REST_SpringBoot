package HotelRESTSpringB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import HotelRESTSpringB.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

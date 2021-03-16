package spring.furama.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.furama.model.employee.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
}

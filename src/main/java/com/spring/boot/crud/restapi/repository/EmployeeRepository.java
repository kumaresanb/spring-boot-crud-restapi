package com.spring.boot.crud.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.boot.crud.restapi.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query(value="from Employee emp order by emp.firstName ")
	public List<Employee> orderByFirstName();
	
	@Query(value="from Employee emp where emp.firstName like concat('%',:name,'%')")
	public List<Employee> findByFirstName(@Param("name") String name);

}

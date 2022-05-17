package com.jobiak.empapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobiak.empapi.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,String>{



}

package com.amogh.persistance;

import com.amogh.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Transactional
    @Modifying
    @Query("Update Employee set name=:name, age=:age where id=:id")
    int updateEmployee(String name, int age, int id);

}

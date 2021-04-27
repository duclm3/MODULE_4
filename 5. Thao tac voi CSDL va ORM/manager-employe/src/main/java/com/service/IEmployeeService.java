package com.service;

import com.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee saveOrUpdate(Employee employee);

    Employee findById(Long id);

    void update(int id, Employee employee);

    void remove(Long id);
}

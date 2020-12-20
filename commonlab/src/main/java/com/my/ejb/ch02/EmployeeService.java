package com.my.ejb.ch02;

import javax.persistence.EntityManager;

public class EmployeeService {
    protected EntityManager em;
    public EmployeeService(EntityManager em){
        this.em = em;
    }

    public Employee createEmployee(int id, String name, long salary){
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }
}

package com.my.ejb.ch02;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("EmployeeService").createEntityManager();
        EmployeeService employeeService = new EmployeeService(em);
        em.getTransaction().begin();
        employeeService.createEmployee(1, "Caca", 100);
        em.getTransaction().commit();
    }
}

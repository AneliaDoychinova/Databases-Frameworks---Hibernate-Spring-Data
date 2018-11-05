package exercise.b_ContainsEmployee03;


import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] name = bf.readLine().split("\\s+");
        em.getTransaction().begin();

        List<Employee> employeeList = em
                .createQuery("select e from Employee AS e where e.firstName=:firstName AND e.lastName=:lastName", Employee.class)
                .setParameter("firstName", name[0])
                .setParameter("lastName", name[1])
                .getResultList();

        System.out.println(employeeList.size() != 0 ? "Yes":"No");
        em.getTransaction().commit();
        em.close();
    }
}

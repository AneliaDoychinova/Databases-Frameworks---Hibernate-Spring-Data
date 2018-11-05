package exercise.i_IncreaseSalaries09;


import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();


        List<Employee> employees = em.createQuery("select e from Employee AS e where " +
                "e.department.name in ('Engineering', 'Tool Design', 'Marketing','Information Services')", Employee.class)
                .getResultList();
        em.getTransaction().begin();

        for (Employee employee : employees) {
            em.detach(employee);
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.2)));
            em.merge(employee);

        }

        employees
                .forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(),e.getLastName(),e.getSalary()));

        em.getTransaction().commit();
        em.close();
    }
}

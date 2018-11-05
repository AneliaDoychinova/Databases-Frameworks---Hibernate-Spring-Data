package exercise.c_EmployeesWithSalaryOver50000_04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<String> employeeList = em
                .createQuery("select e.firstName from Employee AS e where e.salary > 50000",String.class)
                .getResultList();

        for (String employeeName : employeeList) {
            System.out.println(employeeName);
        }
        em.getTransaction().commit();
        em.close();
    }
}

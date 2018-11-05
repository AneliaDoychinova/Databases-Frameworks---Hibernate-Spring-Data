package exercise.k_FindEmployeesByFirstName11;

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
        String emplNameStartsWith = bf.readLine();

        em.getTransaction().begin();

        List<Employee> empl = em.createQuery("select e FROM Employee AS e where e.firstName like :pattern",Employee.class)
                .setParameter("pattern", emplNameStartsWith + "%")
                .getResultList();

        empl.forEach(e->
                        System.out.printf("%s %s - %s - ($%.2f)%n",e.getFirstName(),e.getLastName(),
                                e.getJobTitle(),e.getSalary()));

        em.getTransaction().commit();


        em.close();
    }
}

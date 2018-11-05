package exercise.g_GetEmployeeWithProject07;


import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int employeeId = Integer.parseInt(bf.readLine());
        em.getTransaction().begin();

       Employee employee = em.createQuery("SELECT e FROM Employee AS e where e.id =:id",Employee.class)
               .setParameter("id",employeeId)
               .getSingleResult();

        System.out.printf("%s %s - %s%n", employee.getFirstName(),employee.getLastName(),employee.getJobTitle());

       employee.getProjects().stream().sorted(Comparator.comparing(Project::getName))
               .forEach(project -> System.out.printf("\t%s%n",project.getName()));

        em.getTransaction().commit();
        em.close();
    }
}

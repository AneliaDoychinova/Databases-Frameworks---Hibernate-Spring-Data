package exercise.d_EmployeesFromDepartment05;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employeeList = em
                .createQuery("select e from Employee AS e " +
                        "JOIN Department  AS d ON d.id = e.department.id where d.name = 'Research and Development'" +
                        "order by e.salary,e.id",Employee.class)
                .getResultList();

        for (Employee e : employeeList) {
            System.out.printf("%s %s from Research and Development - $%.2f%n",e.getFirstName(), e.getLastName(), e.getSalary());
        }
        em.getTransaction().commit();
        em.close();
    }
}

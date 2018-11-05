package exercise.l_EmployeesMaximumSalaries12;

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

        List<Employee> rs = em.
                createQuery("SELECT e FROM Employee AS e  where e.salary = (select max(em.salary) from Employee AS em " +
                        "where em.department.name = e.department.name)"+
                        "AND e.salary NOT between 30000 and 70000 group by e.department.id ", Employee.class)
                .getResultList();

        rs.forEach(r-> System.out.printf("%s - %.2f%n",r.getDepartment().getName(),r.getSalary()) );

        em.getTransaction().commit();
        em.close();
    }
}

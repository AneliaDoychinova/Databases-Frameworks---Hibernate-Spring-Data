package exercise.e_AddingNewAddressAndUpdatingEmployee05;


import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String lastName = bf.readLine();
        em.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");
        Town town = em.createQuery("select t from Town AS t WHERE t.name = 'Sofia'", Town.class)
                .getSingleResult();
        address.setTown(town);
        em.persist(address);

        Employee employee = em.createQuery("select e FROM Employee AS e where e.lastName =:lastName", Employee.class)
                .setParameter("lastName",lastName)
                .getSingleResult();
        em.detach(employee);
        employee.setAddress(address);
        em.merge(employee);
        em.getTransaction().commit();
        em.close();
    }
}

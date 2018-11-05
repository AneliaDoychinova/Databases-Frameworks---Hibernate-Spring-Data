package exercise.f_AddressesWithEmployeeCount06;


import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Address> list = em.createQuery("SELECT a FROM Address AS a order by size(a.employees) desc,a.town.id Asc", Address.class)
                .setMaxResults(10)
                .getResultList();
        for (Address a : list) {
            System.out.printf("%s, %s - %d employees%n", a.getText(),a.getTown().getName(),a.getEmployees().size());
        }

        em.getTransaction().commit();
        em.close();
    }
}

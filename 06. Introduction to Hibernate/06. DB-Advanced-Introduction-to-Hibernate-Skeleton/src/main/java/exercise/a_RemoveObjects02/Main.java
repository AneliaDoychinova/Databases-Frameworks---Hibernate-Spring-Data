package exercise.a_RemoveObjects02;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Town> townList = em.createQuery("select t from Town AS t where length(t.name)>5 ")
                .getResultList();

        for (Town town : townList) {
          em.detach(town);
        }

        List<Town> allTowns = em.createQuery("select t from Town AS t")
                .getResultList();
        for (Town t : allTowns) {
            t.setName(t.getName().toLowerCase());
            em.merge(t);
        }
        em.getTransaction().commit();
        em.close();
    }
}

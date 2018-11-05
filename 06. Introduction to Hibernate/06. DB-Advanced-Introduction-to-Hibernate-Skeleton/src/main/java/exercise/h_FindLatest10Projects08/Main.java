package exercise.h_FindLatest10Projects08;


import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Project> rs = em.createQuery("SELECT p FROM Project AS p order by p.startDate desc", Project.class)
                .setMaxResults(10)
                .getResultList();

        rs.stream().sorted(Comparator.comparing(Project::getName)).forEach(p ->{
            System.out.printf("Project name: %s%n",p.getName());
            System.out.printf(" \tProject Description: %s%n",p.getDescription());
            System.out.printf(" \tProject Start Date: %s%n",p.getStartDate());
            System.out.printf(" \tProject End Date: %s%n",p.getEndDate());
        });

        em.getTransaction().commit();
        em.close();
    }
}

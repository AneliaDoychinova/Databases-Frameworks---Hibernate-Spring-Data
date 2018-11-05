package exercise.j_RemoveTowns10;


import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import entities.Address;
import entities.Employee;
import entities.Town;

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
        String townName = bf.readLine();

        em.getTransaction().begin();

        setEmployeeAddress(em, townName);

        int count = deleteAddresses(em, townName);

        deleteTown(em, townName);

        em.getTransaction().commit();

        String text = count==1 ? "address":"addresses";
        System.out.printf("%d %s in %s deleted%n",count,text,townName);
        em.close();
    }

    private static void deleteTown(EntityManager em, String townName) {
        List<Town> townList = em.createQuery("select t from Town AS t where t.name =:town", Town.class).setParameter("town", townName)
                .getResultList();

        for (Town town : townList) {
            em.remove(town);
        }
    }

    private static int deleteAddresses(EntityManager em, String townName) {
        List<Address> ad = em.createQuery("select  a from Address AS a where a.town.name =:town", Address.class)
                .setParameter("town", townName)
                 .getResultList();
        for (Address address : ad) {
            em.remove(address);
        }
        return ad.size();
    }

    private static void setEmployeeAddress(EntityManager em, String townName) {
        List<Employee> empl = em.createQuery("select e from Employee AS e where e.address.town.name =:town",Employee.class)
                .setParameter("town",townName)
                .getResultList();
        for (Employee employee : empl) {
            employee.setAddress(null);
        }
    }
}

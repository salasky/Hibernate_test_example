package TEST_Lazy.eager;


import hibernate_test3_OneToMany_BI.entity.Department;
import hibernate_test3_OneToMany_BI.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Session session=null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            session = factory.getCurrentSession();

            session.beginTransaction();






            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

        }
    }
}

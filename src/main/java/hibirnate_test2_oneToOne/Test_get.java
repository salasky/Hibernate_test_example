package hibirnate_test2_oneToOne;

import hibirnate_test2_oneToOne.entity.Detail;
import hibirnate_test2_oneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Test_get {
    public static void main(String[] args) {

        Session session=null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {

            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail detail=session.get(Detail.class,4);
            System.out.println(detail.getEmployee());
            System.out.println(detail);


            session.getTransaction().commit();
        }
        finally {
            session.close();

        }

        //Так же всегда необходимо закрывать SessionFactory
    }
}

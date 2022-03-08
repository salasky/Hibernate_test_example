package hibernate_ManyToMany;

import hibernate_ManyToMany.entity.Child;
import hibernate_ManyToMany.entity.Section;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1  {
    public static void main(String[] args) {

        Session session=null;
        try ( SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Child.class).
                addAnnotatedClass(Section.class).buildSessionFactory();){
            session=factory.getCurrentSession();





//---------------------------------------------
            session.beginTransaction();

            Child child=session.get(Child.class,1);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }
}

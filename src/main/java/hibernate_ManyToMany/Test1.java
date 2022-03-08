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

            Child child1=new Child("Slava",12);
            Child child2=new Child("Lena",10);

            Section section1=new Section("Swim");

            child1.addSection(section1);
            child2.addSection(section1);


//---------------------------------------------
            session.beginTransaction();

            session.persist(child1);
            session.persist(child2);


            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }
}

package hibirnate_test2_oneToOne;

import hibirnate_test2_oneToOne.entity.Detail;
import hibirnate_test2_oneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Test2_Bi {
    public static void main(String[] args) {

        Session session=null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {

            session = factory.getCurrentSession();
            Employee employee=new Employee("Nikolay","Ivanov","ST",630);
            Detail detail=new Detail("NY","85464324","murray@gmail.com");
            session.beginTransaction();

            employee.setEmpdetail(detail);
            detail.setEmployee(employee);

            session.save(detail);
            session.getTransaction().commit();
        }
        finally {
            session.close();

        }

        //Так же всегда необходимо закрывать SessionFactory
    }
}

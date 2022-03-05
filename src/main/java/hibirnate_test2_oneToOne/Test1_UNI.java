package hibirnate_test2_oneToOne;


import hibirnate_test2_oneToOne.entity.Detail;
import hibirnate_test2_oneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_UNI {
    public static void main(String[] args) {
        //Создали объект SessionFactory

 /*       try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
            Session session = factory.getCurrentSession();
            Employee employee=new Employee("Salavat","Migranov","IT",330);
            Detail detail=new Detail("Ufa","89232434324","migranov77@gmail.com");
            employee.setEmpdetail(detail);
            //Открытие транзакции
            session.beginTransaction();

            session.save(employee);



            //Закрытие транзакции
            session.getTransaction().commit();*/
        Session session=null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
           session = factory.getCurrentSession();
            //Открытие транзакции
            session.beginTransaction();

            Employee employee=session.get(Employee.class,2);
            System.out.println(employee);
            System.out.println(employee.getEmpdetail());
            session.delete(employee);


            //Закрытие транзакции
            session.getTransaction().commit();
        }
        finally {
            session.close();

        }

        //Так же всегда необходимо закрывать SessionFactory
    }
}

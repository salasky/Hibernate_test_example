package hibernate_CRUD;

import hibernate_CRUD.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3_get_HQL {
    public static void main(String[] args) {
        //Создали объект SessionFactory
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory()) {
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
            Session session = factory.getCurrentSession();
            //Открытие транзакции
            session.beginTransaction();

            //всех работников
/*
            List<Employee > emps=session.createQuery("from  Employee ").getResultList();
            for (Employee emp:emps){
                System.out.println(emp);
            }
*/

            List<Employee > emps=session.createQuery("from  Employee "+"where department='IT' AND salary>455").getResultList();
            for (Employee emp:emps){
                System.out.println(emp);
            }
            //Закрытие транзакции
            session.getTransaction().commit();
            System.out.println("Done!");

            //получение объекта из БД
            //Закрытие транзакции
            session.getTransaction().commit();

        }

        //Так же всегда необходимо закрывать SessionFactory TRY WITH RESOURCES
    }
}

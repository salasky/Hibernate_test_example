package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5_Delete {
    public static void main(String[] args) {
        //Создали объект SessionFactory
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory()) {
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
            Session session = factory.getCurrentSession();
            //Открытие транзакции
            session.beginTransaction();

            //если есть готовый объект
/*            Employee employee=session.get(Employee.class,9);
            session.delete(employee);*/

            session.createQuery("delete Employee "+"WHERE department='IT'").executeUpdate();

            //Закрытие транзакции
            session.getTransaction().commit();
            System.out.println("Done!");

            //получение объекта из БД


        }

        //Так же всегда необходимо закрывать SessionFactory TRY WITH RESoURS
    }
}
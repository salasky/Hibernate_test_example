package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2_getID {
    public static void main(String[] args) {
        //Создали объект SessionFactory
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory()) {
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Katw ", "Lam", "HR", 330);
            //Открытие транзакции
            session.beginTransaction();
            //Сохранение в БД (INSERT)
            session.save(emp);

            int myid=emp.getId();
            Employee employee=session.get(Employee.class,myid);


            //Закрытие транзакции
            session.getTransaction().commit();
            System.out.println(employee);

            //получение объекта из БД


        }

        //Так же всегда необходимо закрывать SessionFactory TRY WITH RESURS
    }
}

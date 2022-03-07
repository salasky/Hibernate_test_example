package hibirnate_test3_OneToMany_UNI;




import hibirnate_test3_OneToMany_UNI.entity.Department;
import hibirnate_test3_OneToMany_UNI.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
/*        Session session=null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
            session = factory.getCurrentSession();
            Department department=new Department("ASU",1222,300);
            Employee employee1=new Employee("Mark","Neverov",1000);
            Employee employee2=new Employee("Ildar","Muratov",1200);
            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);
            session.beginTransaction();
            session.save(department);
            session.save(employee1);
            session.save(employee2);


            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

        }
    }
}*/
           Session session=null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
            session = factory.getCurrentSession();

            session.beginTransaction();
            Department department=session.get(Department.class,3);
            System.out.println(department);
            System.out.println(department.getEmpls());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

        }
    }
}

package hibernate_test3_OneToMany_BI;


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
            //Затем от данного объекта необходимо создать сессию,
            //где Session - обертка вокруг подключения к базе с помошью JDBC
            session = factory.getCurrentSession();

            Employee employee=new Employee("Anton","Isaev",1000);

            session.beginTransaction();


            List<Department> deps=session.createQuery("from  Department "+"where departmentName='HR'").getResultList();
            for (Department dep:deps){
                System.out.println(dep);
            }

/*            Department department=session.get(Department.class,1);
            System.out.println(department);*/
/*            department.addEmployeeToDepartment(employee);
            session.save(department);
            session.save(employee);*/



            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

        }
    }
}

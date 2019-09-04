package assignmenthibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UnosUposlenika {

    String name;
    int age;
    String address;
    int salary;

    public void unosUposlenika(String name, int age, String address, int salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;

        Transaction tx = null;
        Employees employees = new Employees(name, age, address, salary);
        try {
            tx = session.beginTransaction();
            session.persist(employees);
            System.out.println(employees.getEmployeesId());
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}

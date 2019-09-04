package assignmenthibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateKlasa {

    int id;
    String name;
    int age;
    String address;
    int salary;

    public void promijeniIme(int id, String name) {
        this.id = id;
        this.name = name;
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = null;
        try {
            tx1 = session1.beginTransaction();
            int i = id;
            Employees employees = (Employees) session1.load(Employees.class, i);
            employees.setName(name);
            tx1.commit();
        } catch (HibernateException ex) {
            if (tx1 != null) {
                tx1.rollback();
            }
        } finally {
            session1.close();
        }
    }

    public void promijeniGodine(int id, int age) {
        this.id = id;
        this.age = age;
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = null;
        try {
            tx2 = session2.beginTransaction();
            int i = id;
            Employees employees = (Employees) session2.load(Employees.class, i);

            employees.setAge(age);
            tx2.commit();
        } catch (HibernateException ex) {
            if (tx2 != null) {
                tx2.rollback();
            }
        } finally {
            session2.close();
        }
    }

    public void promijeniAdresu(int id, String address) {
        this.id=id;
        this.address=address;
        
        Session session3 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = null;
        try {
            tx3 = session3.beginTransaction();
            int i = id;
            Employees employees = (Employees) session3.load(Employees.class, i);
            employees.setName(address);
            tx3.commit();
        } catch (HibernateException ex) {
            if (tx3 != null) {
                tx3.rollback();
            }
        } finally {
            session3.close();
        }
    }
    public void promijeniPlatu(int id, int salary) {
        this.id=id;
        this.salary=salary;
        
        Session session3 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = null;
        try {
            tx3 = session3.beginTransaction();
            int i = id;
            Employees employees = (Employees) session3.load(Employees.class, i);
            employees.setSalary(salary);
            tx3.commit();
        } catch (HibernateException ex) {
            if (tx3 != null) {
                tx3.rollback();
            }
        } finally {
            session3.close();
        }
    }
}

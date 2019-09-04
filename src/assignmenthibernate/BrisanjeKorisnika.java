package assignmenthibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BrisanjeKorisnika {

    int id;
    
    public void izbrisiKorisnika (int id) {
        this.id=id;
        Session session = HibernateUtil.getSessionFactory().openSession();
                        Transaction tx = null;
                        try {
                            tx = session.beginTransaction();
                            int i = id;
                            Employees employees = (Employees) session.load(Employees.class, i);
                            session.delete(employees);
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

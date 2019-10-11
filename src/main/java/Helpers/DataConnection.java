package Helpers;

import Business.bLogging;
import Models.Customer;
import Models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;

public class DataConnection implements AutoCloseable {
    private Configuration con = null;
    private SessionFactory sf = null;
    private Session session = null;

    // Stel de closeables in
    public DataConnection()
    {
        this.con = new Configuration().configure();
        this.sf = this.con.buildSessionFactory();
        this.session = this.sf.openSession();
    }

    public boolean InsertObject(Class Class, Object object)
    {
        try
        {
            // Stel de juiste class in
            this.con.addAnnotatedClass(Class);

            // Begin transactie
            Transaction tx = this.session.beginTransaction();
            this.session.save(object);
            tx.commit();

            // Geen exceptie? Return dan true;
            return true;
        }
        catch(Exception ex)
        {
            bLogging.HandleError(ex);
        }

        return false;
    }

    public <T> T GetObjectFromQuery(T object, String query)
    {
        var em = this.sf.createEntityManager();
        try
        {
            TypedQuery<T> tq = (TypedQuery<T>) em.createQuery(query, object.getClass());
            return  (T) tq.getSingleResult();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }

        return null;
    }

    @Override
    public void close() throws Exception {
        this.session.close();
        this.sf.close();
    }
}

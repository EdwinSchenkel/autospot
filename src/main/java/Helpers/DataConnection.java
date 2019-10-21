package Helpers;

import Logging.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class DataConnection implements AutoCloseable {
    private Configuration con;
    private SessionFactory sf;
    private Session session;

    // Stel de closeables in
    public DataConnection()
    {
        this.con = new Configuration().configure();
        this.sf = this.con.buildSessionFactory();
        this.session = this.sf.openSession();
    }

    public boolean insertObject(Class Class, Object object)
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
            Logging.HandleError(ex);
        }

        return false;
    }

    public <T> T getObjectFromQuery(T object, String query)
    {
        var em = this.sf.createEntityManager();
        try
        {
            TypedQuery<T> tq = (TypedQuery<T>) em.createQuery(query, object.getClass());
            return tq.getSingleResult();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Logging.HandleError(ex);
        }
        finally {
            em.close();
        }

        return null;
    }

    public <T> ArrayList<T> getListFromQuery(T object, String query)
    {
        var em = this.sf.createEntityManager();
        try
        {
            TypedQuery<T> tq = (TypedQuery<T>) em.createQuery(query, object.getClass());
            return (ArrayList<T>) tq.getResultList();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Logging.HandleError(ex);
        }
        finally {
            em.close();
        }

        return null;
    }

    @Override
    public void close() {
        this.session.close();
        this.sf.close();
    }
}

package Helpers;

import Interfaces.ICanWriteToTextFile;
import Logging.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.io.File;
import java.util.ArrayList;

public class DataConnection implements AutoCloseable, ICanWriteToTextFile {
    private Configuration con;
    private SessionFactory sf;
    private Session session;

    public Configuration getCon() {
        return con;
    }

    public void setCon(Configuration con) {
        this.con = con;
    }

    public SessionFactory getSf() {
        return sf;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    // Stel de closeables in
    public DataConnection()
    {
        this.con = new Configuration().configure();
        this.sf = this.con.buildSessionFactory();
        this.session = this.sf.openSession();
    }

    public DataConnection(DataConnection db)
    {
        this.con = db.getCon();
        this.sf = db.getSf();
        this.session = db.getSession();
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
            Logging.HandleError(ex, this);
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
            Logging.HandleError(ex, this);
        }
        finally
        {
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
            Logging.HandleError(ex, this);
        }
        finally {
            em.close();
        }

        return null;
    }

    public void deleteItem(Object object)
    {
        try
        {
            // Stel de juiste class in
            this.con.addAnnotatedClass(object.getClass());

            // Begin transactie
            Transaction tx = this.session.beginTransaction();
            this.session.remove(object);
            tx.commit();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Logging.HandleError(ex, this);
        }
    }

    @Override
    public void close() {
        this.session.close();
        this.sf.close();
    }

    @Override
    public File OpenFile(String fileName) {
        return null;
    }

    @Override
    public void WriteToFile(File file) {

    }
}

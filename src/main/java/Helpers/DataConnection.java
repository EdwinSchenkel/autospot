package Helpers;

import Interfaces.ICanWriteToTextFile;
import Logging.Logging;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class DataConnection implements AutoCloseable, ICanWriteToTextFile {
    private Configuration con;
    private SessionFactory sf;
    private Session session;

    private FileWriterHelper fwHelper;

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

    public boolean editObject(Class Class, Object object, int Id)
    {
        try
        {
            // Stel de juiste class in
            this.con.addAnnotatedClass(Class);

            // Begin transactie
            Transaction tx = this.session.beginTransaction();
            var obj = session.find(Class, Id);
            BeanUtils.copyProperties(obj, object);
            this.session.save(obj);
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

    public boolean deleteItem(Object object)
    {
        try
        {
            if(object == null) return false;
            // Stel de juiste class in
            this.con.addAnnotatedClass(object.getClass());

            // Begin transactie
            Transaction tx = this.session.beginTransaction();
            this.session.remove(object);
            tx.commit();
            // TODO: controleren of item ook echt uit db is
            return true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Logging.HandleError(ex, this);
        }

        return false;
    }

    public void WriteMessageToLogging(String message)
    {
        fwHelper = new FileWriterHelper();

        try {
            var file = OpenFile("dataconnection.txt");
            var currentContent = fwHelper.FileContentToString(file);
            String msg = new Date() + " | MESSAGE : " + message + "\n";
            if(currentContent != null)
                msg = currentContent + msg;
            WriteToFile(file, msg);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void close() {
        this.session.close();
        this.sf.close();
    }

    @Override
    public File OpenFile(String fileName) throws IOException {
        if(fwHelper == null) return null;

        return fwHelper.OpenFile(fileName);
    }

    @Override
    public void WriteToFile(File file, String fileContent) {

    }
}

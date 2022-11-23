package classes.others;
import classes.appointment.CurrentAppointment;
import classes.appointment.PlannedAppointment;
import classes.car.Car;
import classes.person.Accountant;
import classes.person.Client;
import classes.person.Manager;
import classes.person.Mechanic;
import classes.service.ServiceState;
import jakarta.persistence.*;
import java.util.List;


public class DatabaseManager
{
    private static final EntityManagerFactory m_factory = Persistence.createEntityManagerFactory("default");


    //saving an object to the database
    public static void addToDatabase(Object obj)
    {
        EntityManager manager = m_factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try
        {
            transaction.begin();

            manager.persist(obj);
            transaction.commit();
        }
        finally
        {
            if (transaction.isActive())
            { transaction.rollback(); }

            manager.close();
        }
    }

    //finding an object by id, a utility method
    public static <T> T findById(Class<T> type, long id)
    {
        EntityManager manager = m_factory.createEntityManager();
        T object = manager.find(type,id);

        manager.close();
        return object;
    }


    //deleting by id, a utility method
    public static boolean deleteById(Class<?> type, long id)
    {
        EntityManager manager = m_factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        boolean res = false;

        try
        {
            transaction.begin();

            Object persistentInstance = manager.find(type, id);
            if (persistentInstance != null)
            {
                manager.remove(persistentInstance);
                res = true;
            }

            transaction.commit();
        }
        finally
        {
            if (transaction.isActive())
            { transaction.rollback(); }

            manager.close();
        }
        return res;
    }


    public static void updateServiceState(long current_appointment_id, long service_state_id)
    {
        EntityManager manager = m_factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try
        {
            //getting the objects from the database
            CurrentAppointment current_appointment_obj = findById(CurrentAppointment.class,current_appointment_id);
            ServiceState service_state_obj = findById(ServiceState.class,service_state_id);

            transaction.begin();
            //changing the state
            current_appointment_obj.setServiceState(service_state_obj);
            manager.merge(current_appointment_obj);

            transaction.commit();
        }
        finally
        {
            if (transaction.isActive())
            { transaction.rollback(); }

            manager.close();
        }
    }


    //getting clients using JPQL
    public static List<Client> getClients()
    {
        //creating a query and getting results
        EntityManager manager = m_factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM Client a", Client.class);

        List<Client> list = query.getResultList();
        manager.close();

        return list;
    }


    //getting current appointments using JPQL
    public static List<CurrentAppointment> getCurrentAppointments()
    {
        //creating a query and getting results
        EntityManager manager = m_factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM CurrentAppointment a", CurrentAppointment.class);

        List<CurrentAppointment> list = query.getResultList();
        manager.close();

        return list;
    }


    //getting planned appointments using JPQL
    public static List<PlannedAppointment> getPlannedAppointments()
    {
        //creating a query and getting results
        EntityManager manager = m_factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM PlannedAppointment a", PlannedAppointment.class);

        List<PlannedAppointment> list = query.getResultList();
        manager.close();

        return list;
    }


    //getting cars using JPQL
    public static List<Car> getCars()
    {
        //creating a query and getting results
        EntityManager manager = m_factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM Car a", Car.class);

        List<Car> list = query.getResultList();
        manager.close();

        return list;
    }


    //getting mechanics using JPQL
    public static List<Mechanic> getMechanics()
    {
        //creating a query and getting results
        EntityManager manager = m_factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM Mechanic a", Mechanic.class);

        List<Mechanic> list = query.getResultList();
        manager.close();

        return list;
    }


    //getting managers using JPQL
    public static List<Manager> getManagers()
    {
        //creating a query and getting results
        EntityManager manager = m_factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM Manager a", Manager.class);

        List<Manager> list = query.getResultList();
        manager.close();

        return list;
    }


    //getting accountants using JPQL
    public static List<Accountant> getAccountants()
    {
        //creating a query and getting results
        EntityManager manager = m_factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM Accountant a", Accountant.class);

        List<Accountant> list = query.getResultList();
        manager.close();

        return list;
    }
}

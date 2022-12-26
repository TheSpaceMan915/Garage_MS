package classes.others;
import classes.appointment.CurrentAppointment;
import classes.appointment.PlannedAppointment;
import classes.car.Car;
import classes.car.CarBrand;
import classes.car.Fuel;
import classes.car.Transmission;
import classes.person.Accountant;
import classes.person.Client;
import classes.person.Manager;
import classes.person.Mechanic;
import classes.service.Service;
import classes.service.ServiceState;
import jakarta.persistence.*;
import java.util.List;


public class DatabaseManager
{
    private static final EntityManagerFactory m_factory = Persistence.createEntityManagerFactory("default");
    private static final EntityManager m_manager = m_factory.createEntityManager();


    //saving an object to the database
    public static void addToDatabase(Object obj)
    {
        EntityTransaction transaction = m_manager.getTransaction();

        try
        {
            transaction.begin();

            m_manager.persist(obj);
            transaction.commit();
        }
        finally
        {
            if (transaction.isActive())
            { transaction.rollback(); }
        }
    }


    //finding an object by id, a utility method
    public static <T> T findById(Class<T> type, long id) { return m_manager.find(type,id); }


    //deleting by id, a utility method
    public static boolean deleteById(Class<?> type, long id)
    {
        EntityTransaction transaction = m_manager.getTransaction();
        boolean res = false;

        try
        {
            transaction.begin();

            Object persistentInstance = m_manager.find(type, id);
            if (persistentInstance != null)
            {
                m_manager.remove(persistentInstance);
                res = true;
            }

            transaction.commit();
        }
        finally
        {
            if (transaction.isActive())
            { transaction.rollback(); }
        }
        return res;
    }


    public static void updateServiceState(long current_appointment_id, long service_state_id)
    {
        EntityTransaction transaction = m_manager.getTransaction();

        try
        {
            //getting the objects from the database
            CurrentAppointment current_appointment_obj = findById(CurrentAppointment.class,current_appointment_id);
            ServiceState service_state_obj = findById(ServiceState.class,service_state_id);

            transaction.begin();
            //changing the state
            current_appointment_obj.setServiceState(service_state_obj);
            m_manager.merge(current_appointment_obj);

            transaction.commit();
        }
        finally
        {
            if (transaction.isActive())
            { transaction.rollback(); }
        }
    }


    //getting clients using JPQL
    public static List<Client> getClients()
    {
        //creating a query and getting results
        Query query = m_manager.createQuery("SELECT a FROM Client a", Client.class);
        List<Client> list = query.getResultList();

        return list;
    }


    //getting current appointments using JPQL
    public static List<CurrentAppointment> getCurrentAppointments()
    {
        //creating a query and getting results
        Query query = m_manager.createQuery("SELECT a FROM CurrentAppointment a", CurrentAppointment.class);
        List<CurrentAppointment> list = query.getResultList();

        return list;
    }


    //getting planned appointments using JPQL
    public static List<PlannedAppointment> getPlannedAppointments()
    {
        //creating a query and getting results
        Query query = m_manager.createQuery("SELECT a FROM PlannedAppointment a", PlannedAppointment.class);
        List<PlannedAppointment> list = query.getResultList();

        return list;
    }


    //getting cars using JPQL
    public static List<Car> getCars()
    {
        //creating a query and getting results
        Query query = m_manager.createQuery("SELECT a FROM Car a", Car.class);
        List<Car> list = query.getResultList();

        return list;
    }


    //getting mechanics using JPQL
    public static List<Mechanic> getMechanics()
    {
        //creating a query and getting results
        Query query = m_manager.createQuery("SELECT a FROM Mechanic a", Mechanic.class);
        List<Mechanic> list = query.getResultList();

        return list;
    }


    //getting managers using JPQL
    public static List<Manager> getManagers()
    {
        //creating a query and getting results
        Query query = m_manager.createQuery("SELECT a FROM Manager a", Manager.class);
        List<Manager> list = query.getResultList();

        return list;
    }


    //getting accountants using JPQL
    public static List<Accountant> getAccountants()
    {
        //creating a query and getting results
        Query query = m_manager.createQuery("SELECT a FROM Accountant a", Accountant.class);
        List<Accountant> list = query.getResultList();

        return list;
    }


    //getting car brands using JPQL
    public static List<CarBrand> getCarBrands()
    {
        Query query = m_manager.createQuery("SELECT a FROM CarBrand a", CarBrand.class);
        List<CarBrand> list = query.getResultList();

        return list;
    }


    //getting transmissions using JPQL
    public static List<Transmission> getTransmissions()
    {
        Query query = m_manager.createQuery("SELECT a FROM Transmission a", Transmission.class);
        List<Transmission> list = query.getResultList();

        return list;
    }


    //getting fuels using JPQL
    public static List<Fuel> getFuels()
    {
        Query query = m_manager.createQuery("SELECT a FROM Fuel a", Fuel.class);
        List<Fuel> list = query.getResultList();

        return list;
    }


    //getting services using JPQL
    public static List<Service> getServices()
    {
        Query query = m_manager.createQuery("SELECT a FROM Service a", Service.class);
        List<Service> list = query.getResultList();

        return list;
    }


    //getting service states using JPQL
    public static List<ServiceState> getServiceStates()
    {
        Query query = m_manager.createQuery("SELECT a FROM ServiceState a", ServiceState.class);
        List<ServiceState> list = query.getResultList();

        return list;
    }
}

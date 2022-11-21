package classes.others;
import classes.appointment.CurrentAppointment;
import classes.car.Car;
import classes.person.Client;
import classes.person.Mechanic;
import classes.service.Service;
import classes.service.ServiceState;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.List;


//Comment shortcuts:
// to comment one line          command + /
// to comment a block           option + command + /
public class DriveTest
{
    public static void main(String[] args)
    {
        System.out.println("The test has started");
/*
        //an example of creating an appointment
        try
        {
            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();

            Car temp = manager.find(Car.class,1);
            Service service_oil = manager.find(Service.class,1);
            ServiceState state = manager.find(ServiceState.class,1);
            Mechanic mechanic = manager.find(Mechanic.class,1);
            Timestamp time = Timestamp.valueOf("2022-11-03 20:30:22");

            CurrentAppointment appointment1 = new CurrentAppointment();
            appointment1.setService(service_oil);
            appointment1.setCarId(temp);
            appointment1.setServiceState(state);
            appointment1.setMechanic(mechanic);

            manager.persist(appointment1);
            transaction.commit();

        }
        finally
        {
            if (transaction.isActive())
            { transaction.rollback(); }

            manager.close();
            factory.close();
        }*/
/*        Timestamp time = Timestamp.valueOf("2022-11-03 20:30:22");
        System.out.println(time);*/

        System.out.println("9383!Pof".hashCode());
        System.out.println("Uirf@34".hashCode());
        System.out.println("V945?3e".hashCode());


        System.out.println("The test has ended");
    }
}

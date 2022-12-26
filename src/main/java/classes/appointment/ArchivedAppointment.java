package classes.appointment;
import classes.car.Car;
import classes.person.Mechanic;
import classes.service.Service;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;


@Entity
@Table(name = "archived_appointment", schema = "public", catalog = "postgres")
public class ArchivedAppointment extends Appointment
{
    @ManyToOne
    @JoinColumn(name = "mechanic_id",nullable = true)
    private Mechanic m_mechanic;


    public ArchivedAppointment() { super(); }

    public ArchivedAppointment(Car car, Service service, Mechanic mechanic, Timestamp appointment_time)
    {
        super(car,service,appointment_time);
        m_mechanic = mechanic;
    }

    public Mechanic getMechanic() { return m_mechanic; }
    public void setMechanic(Mechanic m_mechanic) { this.m_mechanic = m_mechanic; }
}

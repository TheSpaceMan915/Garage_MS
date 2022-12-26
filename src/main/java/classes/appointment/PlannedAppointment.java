package classes.appointment;
import classes.car.Car;
import classes.service.Service;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;


@Entity
@Table(name = "planned_appointment", schema = "public", catalog = "postgres")
public class PlannedAppointment extends Appointment
{
    @Basic
    @Column(name = "appointment_time")
    private Timestamp m_appointment_time;


    public PlannedAppointment() { super(); }

    public PlannedAppointment(Car car, Service service, Timestamp appointment_time)
    {
        super(car,service);
        m_appointment_time = appointment_time;
    }

    public Timestamp getAppointmentTime() { return m_appointment_time; }

    public void setAppointmentTime(Timestamp appointmentTime) { this.m_appointment_time = appointmentTime; }

}

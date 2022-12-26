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
    public PlannedAppointment() { super(); }

    public PlannedAppointment(Car car, Service service, Timestamp appointment_time)
    { super(car,service,appointment_time); }
}

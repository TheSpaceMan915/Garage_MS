package classes.appointment;

import classes.car.Car;
import classes.person.Mechanic;
import classes.service.Service;
import classes.service.ServiceState;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "current_appointment", schema = "public", catalog = "postgres")
public class CurrentAppointment extends Appointment
{
    @ManyToOne
    @JoinColumn(name = "service_state_id", nullable = true)
    private ServiceState m_service_state;

    @ManyToOne
    @JoinColumn(name = "mechanic_id",nullable = true)
    private Mechanic m_mechanic;



    public CurrentAppointment() { super(); }

    public CurrentAppointment(Car car, Service service, ServiceState service_state, Mechanic mechanic)
    {
        super(car,service);
        m_service_state = service_state;
        m_mechanic = mechanic;
    }

    public Mechanic getMechanic() { return m_mechanic; }

    public void setMechanic(Mechanic m_mechanic) { this.m_mechanic = m_mechanic; }

    public ServiceState getServiceState() { return m_service_state; }

    public void setServiceState(ServiceState m_service_state) { this.m_service_state = m_service_state; }
}

package classes.appointment;
import classes.car.Car;
import classes.service.Service;
import jakarta.persistence.*;

import java.sql.Timestamp;


@MappedSuperclass
public abstract class Appointment
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long m_id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = true)
    private Car m_car;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = true)
    private Service m_service;

    @Basic
    @Column(name = "appointment_time")
    private Timestamp m_appointment_time;


    public Appointment() {}

    public Appointment(Car car, Service service, Timestamp appointment_time)
    {
        m_car = car;
        m_service = service;
        m_appointment_time = appointment_time;
    }

    public Timestamp getAppointmentTime() { return m_appointment_time; }
    public void setAppointmentTime(Timestamp m_appointment_time) { this.m_appointment_time = m_appointment_time; }
    public long getId() {return m_id; }
    public void setId(long id) { this.m_id = id; }
    public Car getCar() { return m_car; }
    public void setCar(Car car) { this.m_car = car; }
    public Service getService() { return m_service; }
    public void setService(Service service) { this.m_service = service; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (m_id != that.m_id) return false;
        if (m_car != null ? !m_car.equals(that.m_car) : that.m_car != null) return false;
        if (m_service != null ? !m_service.equals(that.m_service) : that.m_service != null) return false;
//        if (appointmentTime != null ? !appointmentTime.equals(that.appointmentTime) : that.appointmentTime != null) return false;

        return true;
    }
}

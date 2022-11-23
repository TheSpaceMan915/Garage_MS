package classes.service;
import classes.appointment.CurrentAppointment;
import classes.appointment.PlannedAppointment;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "service", schema = "public", catalog = "postgres")
public class Service
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long m_id;

    @Basic
    @Column(name = "name")
    private String m_name;

    @Basic
    @Column(name = "price")
    private double m_price;

    @OneToMany(mappedBy = "m_service", cascade = CascadeType.ALL)
    private Set<CurrentAppointment> m_set_current_appointments;

    @OneToMany(mappedBy = "m_service", cascade = CascadeType.ALL)
    private Set<PlannedAppointment> m_set_planned_appointments;



    public long getId() {
        return m_id;
    }

    public void setId(long id) {
        this.m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public double getPrice() {
        return m_price;
    }

    public void setPrice(double price) {
        this.m_price = price;
    }

    public Set<CurrentAppointment> getCurrentAppointments() { return m_set_current_appointments; }

    public void setCurrentAppointments(Set<CurrentAppointment> m_set_current_appointments) { this.m_set_current_appointments = m_set_current_appointments; }

    public Set<PlannedAppointment> getPlannedAppointments() { return m_set_planned_appointments; }

    public void setPlannedAppointments(Set<PlannedAppointment> m_set_planned_appointments) { this.m_set_planned_appointments = m_set_planned_appointments; }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (m_id != service.m_id) return false;
        if (Double.compare(service.m_price, m_price) != 0) return false;
        if (m_name != null ? !m_name.equals(service.m_name) : service.m_name != null) return false;

        return true;
    }
}

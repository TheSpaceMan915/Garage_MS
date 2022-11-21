package classes.service;

import classes.appointment.CurrentAppointment;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "service_state", schema = "public", catalog = "postgres")
public class ServiceState
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int m_id;

    @Basic
    @Column(name = "name")
    private String m_name;


    @OneToMany(mappedBy = "m_service_state", cascade = CascadeType.ALL)
    private Set<CurrentAppointment> m_set_current_appointments;


    public int getId() { return m_id; }

    public void setId(int id) {
        this.m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String state) {
        this.m_name = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceState that = (ServiceState) o;

        if (m_id != that.m_id) return false;
        if (m_name != null ? !m_name.equals(that.m_name) : that.m_name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = m_id;
        result = 31 * result + (m_name != null ? m_name.hashCode() : 0);
        return result;
    }
}

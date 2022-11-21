package classes.car;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "fuel", schema = "public", catalog = "postgres")
public class Fuel
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int m_id;

    @Basic
    @Column(name = "type")
    private String m_type;


    @OneToMany(mappedBy = "m_fuel", cascade = CascadeType.ALL)
    private Set<Car> m_set_cars;


    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public String getType() {
        return m_type;
    }

    public void setType(String type) {
        this.m_type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fuel fuel = (Fuel) o;

        if (m_id != fuel.m_id) return false;
        if (m_type != null ? !m_type.equals(fuel.m_type) : fuel.m_type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = m_id;
        result = 31 * result + (m_type != null ? m_type.hashCode() : 0);
        return result;
    }
}

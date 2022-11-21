package classes.car;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "transmission", schema = "public", catalog = "postgres")
public class Transmission
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int m_id;

    @Basic
    @Column(name = "type")
    private String m_type;


    @OneToMany(mappedBy = "m_transmisson", cascade = CascadeType.ALL)
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

        Transmission that = (Transmission) o;

        if (m_id != that.m_id) return false;
        if (m_type != null ? !m_type.equals(that.m_type) : that.m_type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = m_id;
        result = 31 * result + (m_type != null ? m_type.hashCode() : 0);
        return result;
    }
}
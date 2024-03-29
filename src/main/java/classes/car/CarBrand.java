package classes.car;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "car_brand", schema = "public", catalog = "postgres")
public class CarBrand
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long m_id;

    @Basic
    @Column(name = "name")
    private String m_name;

    @OneToMany(mappedBy = "m_brand", cascade = CascadeType.ALL)
    private Set<Car> m_set_cars;


    public CarBrand() {}

    public long getId() {
        return m_id;
    }

    public void setId(long m_id) {
        this.m_id = m_id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarBrand that = (CarBrand) o;

        if (m_id != that.m_id) return false;
        if (m_name != null ? !m_name.equals(that.m_name) : that.m_name != null) return false;

        return true;
    }
}

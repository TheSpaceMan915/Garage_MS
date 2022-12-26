package classes.person;
import classes.car.Car;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "client", schema = "public", catalog = "postgres")
public class Client extends Person
{
    @Basic
    @Column(name = "phone_number")
    private String m_phone_number;

    @OneToMany(mappedBy = "m_client", cascade = CascadeType.ALL)
    private Set<Car> m_set_cars;


    public Client() { super(); }

    public Client(String first_name, String second_name, String phone_number)
    {
        super(first_name,second_name);
        m_phone_number = phone_number;
    }

    public String getPhoneNumber() {
        return m_phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.m_phone_number = phoneNumber;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (this.getId() != client.getId()) return false;
        if (this.getFirstName() != null ? !this.getFirstName().equals(client.getFirstName()) : client.getFirstName() != null) return false;
        if (this.getSecondName() != null ? !this.getSecondName().equals(client.getSecondName()) : client.getSecondName() != null) return false;
        if (m_phone_number != null ? !m_phone_number.equals(client.m_phone_number) : client.m_phone_number != null) return false;

        return true;
    }
}

package classes.car;

import classes.appointment.CurrentAppointment;
import classes.appointment.PlannedAppointment;
import classes.person.Client;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "car", schema = "public", catalog = "postgres")
public class Car
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long m_id;

    @Basic
    @Column(name = "plate_number")
    private String m_plate_number;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = true)
    private Client m_client;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = true)
    private CarBrand m_brand;

    @ManyToOne
    @JoinColumn(name = "transmission_id", nullable = true)
    private Transmission m_transmisson;

    @ManyToOne
    @JoinColumn(name = "fuel_id", nullable = true)
    private Fuel m_fuel;

    @OneToMany(mappedBy = "m_car", cascade = CascadeType.ALL)
    private Set<CurrentAppointment> m_set_current_appointments;

    @OneToMany(mappedBy = "m_car", cascade = CascadeType.ALL)
    private Set<PlannedAppointment> m_set_planned_appointments;


    public Car() {}

    public Car(String plate_number, Client client, CarBrand brand, Transmission transmission, Fuel fuel)
    {
        m_plate_number = plate_number;
        m_client = client;
        m_brand = brand;
        m_transmisson = transmission;
        m_fuel = fuel;
    }

    public long getId() { return m_id; }

    public void setId(long m_id) { this.m_id = m_id; }

    public String getPlateNumber() { return m_plate_number; }

    public void setPlateNumber(String m_plate_number) { this.m_plate_number = m_plate_number; }

    public Client getClient() { return m_client; }

    public void setClient(Client m_client) { this.m_client = m_client; }

    public CarBrand getBrand() { return m_brand; }

    public void setBrand(CarBrand m_brand) { this.m_brand = m_brand; }

    public Transmission getTransmisson() { return m_transmisson; }

    public void setTransmisson(Transmission m_transmisson) { this.m_transmisson = m_transmisson; }

    public Fuel getFuel() { return m_fuel; }

    public void setFuel(Fuel m_fuel) { this.m_fuel = m_fuel; }
}

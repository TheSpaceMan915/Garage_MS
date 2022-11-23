package classes.person;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long m_id;

    @Basic
    @Column(name = "first_name")
    private String m_first_name;

    @Basic
    @Column(name = "second_name")
    private String m_second_name;


    public Person() {}

    public Person(String first_name, String second_name)
    {
        m_first_name = first_name;
        m_second_name = second_name;
    }

    public long getId() { return m_id; }

    public void setId(long id) { this.m_id = id; }

    public String getFirstName() { return m_first_name; }

    public void setFirstName(String firstName) { this.m_first_name = firstName; }
    public String getSecondName() { return m_second_name; }

    public void setSecondName(String secondName) { this.m_second_name = secondName; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (m_id != person.m_id) return false;
        if (m_first_name != null ? !m_first_name.equals(person.m_first_name) : person.m_first_name != null) return false;
        if (m_second_name != null ? !m_second_name.equals(person.m_second_name) : person.m_second_name != null) return false;

        return true;
    }
}


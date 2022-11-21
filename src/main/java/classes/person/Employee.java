package classes.person;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.math.BigInteger;

@MappedSuperclass
public abstract class Employee extends Person
{
    @Basic
    @Column(name = "login")
    private String m_login;

    @Basic
    @Column(name = "password_hashcode")
    private long m_password_hashcode;


    public String getLogin() { return m_login; }

    public void setLogin(String m_login) { this.m_login = m_login; }

    public long getPasswordHashcode() { return m_password_hashcode; }

    public void setPasswordHashcode(long m_password_hashcode) { this.m_password_hashcode = m_password_hashcode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (this.getId() != employee.getId()) return false;
        if (this.getFirstName() != null ? !this.getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null) return false;
        if (this.getSecondName() != null ? !this.getSecondName().equals(employee.getSecondName()) : employee.getSecondName() != null) return false;
        if (m_login != null ? !m_login.equals(employee.m_login) : employee.m_login != null) return false;
        //if (m_password_hashcode != null ? !m_password_hashcode.equals(employee.m_password_hashcode) : employee.m_password_hashcode != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = this.getId();
        result = 31 * result + (this.getFirstName() != null ? this.getFirstName().hashCode() : 0);
        result = 31 * result + (this.getSecondName() != null ? this.getSecondName().hashCode() : 0);
        result = 31 * result + (m_login != null ? m_login.hashCode() : 0);
        //result = 31 * result + (m_password_hashcode != null ? m_password_hashcode.hashCode() : 0);
        return result;
    }
}

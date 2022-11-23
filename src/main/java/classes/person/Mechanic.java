package classes.person;
import classes.appointment.CurrentAppointment;
import classes.others.DatabaseManager;
import classes.service.ServiceState;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@Entity
@Table(name = "mechanic", schema = "public", catalog = "postgres")
public class Mechanic extends Employee
{
    @OneToMany(mappedBy = "m_mechanic", cascade = CascadeType.ALL)
    private Set<CurrentAppointment> m_set_current_appointments;



    public Set<CurrentAppointment> getCurrentAppointments() { return m_set_current_appointments; }

    public void setCurrentAppointments(Set<CurrentAppointment> m_set_current_appointments) { this.m_set_current_appointments = m_set_current_appointments; }

    public static void changeServiceState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //getting the data from the page
        long input_current_appointment_id = Long.parseLong(request.getParameter("field_current_appointment_id"));
        long input_service_state_id = Long.parseLong(request.getParameter("select_service_state"));


        //changing the state of the service
        DatabaseManager.updateServiceState(input_current_appointment_id,input_service_state_id);


        //redirecting the request to show the results to the user
        request.getRequestDispatcher("ServletViewer").forward(request,response);
    }
}

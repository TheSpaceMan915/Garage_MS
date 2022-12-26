package classes.person;
import classes.appointment.ArchivedAppointment;
import classes.appointment.CurrentAppointment;
import classes.car.Car;
import classes.others.DatabaseManager;
import classes.service.Service;
import classes.service.ServiceState;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Entity
@Table(name = "accountant", schema = "public", catalog = "postgres")
public class Accountant extends Employee
{
    public static void calculateServicesCost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //getting the client id
        long input_car_id = Long.parseLong(request.getParameter("select_car"));

        //getting the list of all current appointments
        List<CurrentAppointment> list_appointments = DatabaseManager.getCurrentAppointments();


        //calculating the cost
        double sum = 0.0;
        Car car_obj = null;
        Service service_obj = null;
        ServiceState service_state_obj = null;

        for (CurrentAppointment appointment : list_appointments)
        {
            car_obj = appointment.getCar();
            service_state_obj = appointment.getServiceState();
            service_obj = appointment.getService();

            if (input_car_id == car_obj.getId())
            {
                if (service_state_obj.getName().equals("Finished"))
                {
                    //summing the cost of services
                    sum += service_obj.getPrice();

                    //archiving the appointment
                    ArchivedAppointment appointment_archived_obj = new ArchivedAppointment(car_obj,service_obj, appointment.getMechanic(), appointment.getAppointmentTime());
                    DatabaseManager.addToDatabase(appointment_archived_obj);

                    //deleting the finished current appointment
                    DatabaseManager.deleteById(CurrentAppointment.class,appointment.getId());
                }
            }
        }


        //redirecting the request to show the results to the user
        request.setAttribute("cost_services",sum);
        request.getRequestDispatcher("ServletViewer").forward(request,response);
    }
}

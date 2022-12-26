package classes.person;
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
        Car car = null;
        Service service = null;
        ServiceState service_state = null;

        for (CurrentAppointment appointment : list_appointments)
        {
            car = appointment.getCar();
            service_state = appointment.getServiceState();
            service = appointment.getService();

            if (input_car_id == car.getId())
            {
                if (service_state.getName().equals("Finished"))
                {
                    //summing the cost of services
                    sum += service.getPrice();

                    //deleting the finished appointment
                    DatabaseManager.deleteById(CurrentAppointment.class,appointment.getId());
                }
            }
        }


        //redirecting the request to show the results to the user
        request.setAttribute("cost_services",sum);
        request.getRequestDispatcher("ServletViewer").forward(request,response);
    }
}

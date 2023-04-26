package classes.person;
import classes.appointment.CurrentAppointment;
import classes.appointment.PlannedAppointment;
import classes.car.Car;
import classes.car.CarBrand;
import classes.car.Fuel;
import classes.car.Transmission;
import classes.others.DatabaseManager;
import classes.service.Service;
import classes.service.ServiceState;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;


@Entity
@Table(name = "manager", schema = "public", catalog = "postgres")
public class Manager extends Employee
{

    //the function to format the date received from the html page
    private static String formatDate(String date)
    {
        StringBuilder builder = new StringBuilder();
        char letter = ' ';

        for (int i = 0; i < date.length(); i++)
        {
            letter = date.charAt(i);

            if (letter != 'T')
            { builder.append(letter); }
            else
            { builder.append(' '); }
        }

        builder.append(":00");
        return builder.toString();
    }


    //adding a new planned appointment
    public static void addPlannedAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //getting the data about a planned appointment
        long input_car_id = Long.parseLong(request.getParameter("select_car"));
        long input_service_id = Long.parseLong(request.getParameter("select_service"));
        String input_date = request.getParameter("field_time");
        //HTML: 2022-11-01T12:35

        //formatting the date
        String date_formatted = formatDate(input_date);

        //creating a planned appointment
        Timestamp time_obj = Timestamp.valueOf(date_formatted);
        Car car_obj = DatabaseManager.findById(Car.class,input_car_id);
        Service service_obj = DatabaseManager.findById(Service.class,input_service_id);

        PlannedAppointment planned_appointment_obj = new PlannedAppointment(car_obj,service_obj,time_obj);
        DatabaseManager.addToDatabase(planned_appointment_obj);

        //redirecting the request to show the results to the user
        request.getRequestDispatcher("ServletViewer").forward(request,response);
    }


    public static void addCurrentAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //getting the data from the hmtl page to create a current appointment
        long input_planned_appointment_id = Long.parseLong(request.getParameter("select_planned_appointment"));
        long input_mechanic_id = Long.parseLong(request.getParameter("select_mechanic"));

        //using a planned appointment object to get data about the service and car
        PlannedAppointment planned_appointment_obj = DatabaseManager.findById(PlannedAppointment.class,input_planned_appointment_id);
        Car car_obj = planned_appointment_obj.getCar();
        Service service_obj = planned_appointment_obj.getService();
        Timestamp appointment_time_obj = planned_appointment_obj.getAppointmentTime();

        //getting the default service state object
        ServiceState service_state_obj = DatabaseManager.findById(ServiceState.class,1);

        //getting the mechanic object
        Mechanic mechanic_obj = DatabaseManager.findById(Mechanic.class,input_mechanic_id);

        //creating a current appointment object
        CurrentAppointment current_appointment_obj = new CurrentAppointment(car_obj,service_obj,service_state_obj,mechanic_obj,appointment_time_obj);
        DatabaseManager.addToDatabase(current_appointment_obj);

        //deleting the planned appointment (because the car is on the service right now)
        boolean res = DatabaseManager.deleteById(PlannedAppointment.class,planned_appointment_obj.getId());

        //redirecting the request to show the results to the user
        request.getRequestDispatcher("ServletViewer").forward(request,response);
    }


    //adding a new client
    public static void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //getting the data from the user
        String input_first_name = request.getParameter("field_first_name");
        String input_second_name = request.getParameter("field_second_name");
        String input_phone_number = request.getParameter("field_phone_number");

        //creating a new client and adding it to the database
        Client client = new Client(input_first_name,input_second_name,input_phone_number);
        DatabaseManager.addToDatabase(client);

        //redirecting the request to show the results to the user
        request.getRequestDispatcher("ServletViewer").forward(request,response);
    }


    //adding a new car
    public static void addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //getting the data about a client's car
        long input_client_id = Long.parseLong(request.getParameter("select_client"));
        String input_plate_number = request.getParameter("field_plate_number");
        long input_brand_id = Long.parseLong(request.getParameter("select_brand"));
        long input_transmission_id = Long.parseLong(request.getParameter("select_transmission"));
        long input_fuel_id = Long.parseLong(request.getParameter("select_fuel"));

        //getting the links to the objects from the database
        Client client_obj = DatabaseManager.findById(Client.class,input_client_id);
        CarBrand brand_obj = DatabaseManager.findById(CarBrand.class,input_brand_id);
        Transmission transmission_obj = DatabaseManager.findById(Transmission.class,input_transmission_id);
        Fuel fuel_obj = DatabaseManager.findById(Fuel.class,input_fuel_id);

        Car car_obj = new Car(input_plate_number,client_obj,brand_obj,transmission_obj,fuel_obj);
        DatabaseManager.addToDatabase(car_obj);

        //redirecting the request to show the results to the user
        request.getRequestDispatcher("ServletViewer").forward(request,response);
    }
}

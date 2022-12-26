package servlets;
import classes.appointment.CurrentAppointment;
import classes.appointment.PlannedAppointment;
import classes.car.Car;
import classes.person.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "ServletViewer", value = "/ServletViewer")
public class ServletViewer extends HttpServlet
{
    private PrintWriter m_writer;


    private void showListClients(List<Client> list)
    {
        m_writer.println("<html>");

        m_writer.println("<head>");
        m_writer.println("<style>");
        m_writer.println("h1 {color:darkviolet; text-align:center}");
        m_writer.println("table {margin-left:auto; margin-right:auto}");
        m_writer.println("td {text-align:center; padding:10px}");
        m_writer.println("th {padding:10px}");
        m_writer.println("</style>");
        m_writer.println("<title>Clients</title>");
        m_writer.println("</head>");

        //add head with the style block
        m_writer.println("<body>");
        m_writer.println("<h1>Your clients</h1>");
        m_writer.println("<table>");
        m_writer.println("<tr>");
        m_writer.println("<th>Id</th>");
        m_writer.println("<th>First name</th>");
        m_writer.println("<th>Second name</th>");
        m_writer.println("<th>Phone number</th>");
        m_writer.println("</tr>");

        for (Client client : list)
        {
            m_writer.println("<tr>");
            m_writer.println("<td>" + client.getId() + "</td>");
            m_writer.println("<td>" + client.getFirstName() + "</td>");
            m_writer.println("<td>" + client.getSecondName() + "</td>");
            m_writer.println("<td>" + client.getPhoneNumber() + "</td>");
            m_writer.println("</tr>");
        }

        m_writer.println("</table>");
        m_writer.println("<br><br>");
        m_writer.println("<button type=button name=back onclick=history.back()>Go back</button>");
        m_writer.println("</body>");
        m_writer.println("</html>");
    }


    private void showListCars(List<Car> list)
    {
        m_writer.println("<html>");

        m_writer.println("<head>");
        m_writer.println("<style>");
        m_writer.println("h1 {color:darkviolet; text-align:center}");
        m_writer.println("table {margin-left:auto; margin-right:auto}");
        m_writer.println("td {text-align:center}");
        m_writer.println("th {padding:10px}");
        m_writer.println("</style>");
        m_writer.println("<title>Cars</title>");
        m_writer.println("</head>");

        m_writer.println("<body>");
        m_writer.println("<h1>Your cars</h1>");
        m_writer.println("<table>");
        m_writer.println("<tr>");
        m_writer.println("<th>Id</th>");
        m_writer.println("<th>Plate number</th>");
        m_writer.println("<th>Owner</th>");
        m_writer.println("<th>Brand</th>");
        m_writer.println("<th>Transmission type</th>");
        m_writer.println("<th>Fuel type</th>");
        m_writer.println("</tr>");

        for (Car car : list)
        {
            m_writer.println("<tr>");
            m_writer.println("<td>" + car.getId() + "</td>");
            m_writer.println("<td>" + car.getPlateNumber() + "</td>");
            m_writer.println("<td>" + car.getClient().getFirstName() + " " +  car.getClient().getSecondName() + "</td>");
            m_writer.println("<td>" + car.getBrand().getName() + "</td>");
            m_writer.println("<td>" + car.getTransmisson().getType() + "</td>");
            m_writer.println("<td>" + car.getFuel().getType() + "</td>");
            m_writer.println("</tr>");
        }

        m_writer.println("</table>");
        m_writer.println("<br><br>");
        m_writer.println("<button type=button name=back onclick=history.back()>Go back</button>");
        m_writer.println("</body>");
        m_writer.println("</html>");
    }


    private void showListPlannedAppointments(List<PlannedAppointment> list)
    {
        m_writer.println("<html>");

        m_writer.println("<head>");
        m_writer.println("<style>");
        m_writer.println("h1 {color:darkviolet; text-align:center}");
        m_writer.println("table {margin-left:auto; margin-right:auto}");
        m_writer.println("td {text-align:center}");
        m_writer.println("th {padding:10px}");
        m_writer.println("</style>");
        m_writer.println("<title>Planned appointments</title>");
        m_writer.println("</head>");

        m_writer.println("<body>");
        m_writer.println("<h1>Your planned appointments</h1>");
        m_writer.println("<table>");
        m_writer.println("<tr>");
        m_writer.println("<th>Id</th>");
        m_writer.println("<th>Car plate number</th>");
        m_writer.println("<th>Service name</th>");
        m_writer.println("<th>Time</th>");
        m_writer.println("</tr>");

        for (PlannedAppointment appointment : list)
        {
            m_writer.println("<tr>");
            m_writer.println("<td>" + appointment.getId() + "</td>");
            m_writer.println("<td>" + appointment.getCar().getPlateNumber() + "</td>");
            m_writer.println("<td>" + appointment.getService().getName() + "</td>");
            m_writer.println("<td>" + appointment.getAppointmentTime() + "</td>");
            m_writer.println("</tr>");
        }

        m_writer.println("</table>");
        m_writer.println("<br><br>");
        m_writer.println("<button type=button name=back onclick=history.back()>Go back</button>");
        m_writer.println("</body>");
        m_writer.println("</html>");
    }


    private void showListCurrentAppointments(List<CurrentAppointment> list)
    {
        m_writer.println("<html>");

        m_writer.println("<head>");
        m_writer.println("<style>");
        m_writer.println("h1 {color:darkviolet; text-align:center}");
        m_writer.println("table {margin-left:auto; margin-right:auto}");
        m_writer.println("td {text-align:center}");
        m_writer.println("th {padding:10px}");
        m_writer.println("</style>");
        m_writer.println("<title>Current appointments</title>");
        m_writer.println("</head>");

        m_writer.println("<body>");
        m_writer.println("<h1>Your current appointments</h1>");
        m_writer.println("<table>");
        m_writer.println("<tr>");
        m_writer.println("<th>Id</th>");
        m_writer.println("<th>Car plate number</th>");
        m_writer.println("<th>Service name</th>");
        m_writer.println("<th>Service state</th>");
        m_writer.println("</tr>");

        for (CurrentAppointment appointment : list)
        {
            m_writer.println("<tr>");
            m_writer.println("<td>" + appointment.getId() + "</td>");
            m_writer.println("<td>" + appointment.getCar().getPlateNumber() + "</td>");
            m_writer.println("<td>" + appointment.getService().getName() + "</td>");
            m_writer.println("<td>" + appointment.getServiceState().getName() + "</td>");
            m_writer.println("</tr>");
        }

        m_writer.println("</table>");
        m_writer.println("<br><br>");
        m_writer.println("<button type=button name=back onclick=history.back()>Go back</button>");
        m_writer.println("</body>");
        m_writer.println("</html>");
    }


    private void printMessage(String message)
    {
        m_writer.println("<html>");
        m_writer.println("<title>Message</title>");
        m_writer.println("<body>");

        m_writer.println("<p>" + message + "</p>");

        m_writer.println("<br><br>");
        m_writer.println("<button type=button name=back onclick=history.back()>Go back</button>");
        m_writer.println("</body>");
        m_writer.println("</html>");
    }


    //showing the needed list
    private void printList(HttpServletRequest request, HttpServletResponse response)
    {
        String chooser = request.getParameter("list");

        switch(chooser)
        {
            case "Clients" ->
            {
                List<Client> list_clients = (List<Client>) request.getAttribute("list_clients");
                showListClients(list_clients);
            }

            case "Cars" ->
            {
                List<Car> list_cars = (List<Car>) request.getAttribute("list_cars");
                showListCars(list_cars);
            }

            case "Planned appointments" ->
            {
                List<PlannedAppointment> list_planned_appointments = (List<PlannedAppointment>) request.getAttribute("list_planned_appointments");
                showListPlannedAppointments(list_planned_appointments);
            }

            case "Current appointments" ->
            {
                List<CurrentAppointment> list_current_appointments = (List<CurrentAppointment>) request.getAttribute("list_current_appointments");
                showListCurrentAppointments(list_current_appointments);
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { doPost(request,response); }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        m_writer = response.getWriter();
        String choice = request.getParameter("action");


        switch (choice)
        {
            case "View" -> printList(request,response);

            case "Add a new client" -> printMessage("A new client has been added");

            case "Add a new car" -> printMessage("A new car has been added");

            case "Create a planned appointment" -> printMessage("A planned appointment has been added");

            case "Create a current appointment" -> printMessage("A current appointment has been added");

            case "Change state" -> printMessage("The state of the service has been changed");

            case "Services cost" -> printMessage("The cost of services for this car: " + request.getAttribute("cost_services"));
        }
    }
}

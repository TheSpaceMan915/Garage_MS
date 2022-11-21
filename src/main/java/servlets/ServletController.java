package servlets;

import classes.appointment.CurrentAppointment;
import classes.appointment.PlannedAppointment;
import classes.car.Car;
import classes.car.CarBrand;
import classes.car.Fuel;
import classes.car.Transmission;
import classes.others.DatabaseManager;
import classes.person.Accountant;
import classes.person.Client;
import classes.person.Manager;
import classes.person.Mechanic;
import classes.service.Service;
import classes.service.ServiceState;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "ServletController", value = "/ServletController")
public class ServletController extends HttpServlet
{
    private void forwardListToViewer(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
    {
        //getting the list to be printed from the select on the view_data html
        String chooser = request.getParameter("list");


        //forwarding the list of objects to the viewer
        switch(chooser)
        {
            case "Clients" ->
            {
                List<Client> list_clients = DatabaseManager.getClients();
                request.setAttribute("list_clients",list_clients);

                //redirecting the request to show the results to the user
                request.getRequestDispatcher("ServletViewer").forward(request,response);
            }

            case "Cars" ->
            {
                List<Car> list_cars = DatabaseManager.getCars();
                request.setAttribute("list_cars",list_cars);

                //redirecting the request to show the results to the user
                request.getRequestDispatcher("ServletViewer").forward(request,response);
            }

            case "Planned appointments" ->
            {
                List<PlannedAppointment> list_planned_appointments = DatabaseManager.getPlannedAppointments();
                request.setAttribute("list_planned_appointments",list_planned_appointments);

                //redirecting the request to show the results to the user
                request.getRequestDispatcher("ServletViewer").forward(request,response);
            }

            case "Current appointments" ->
            {
                List<CurrentAppointment> list_current_appointments = DatabaseManager.getCurrentAppointments();
                request.setAttribute("list_current_appointments",list_current_appointments);

                //redirecting the request to show the results to the user
                request.getRequestDispatcher("ServletViewer").forward(request,response);
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { doPost(request,response); }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        String choice = request.getParameter("action");

        switch (choice)
        {
            case "View" -> forwardListToViewer(request,response);

            case "Add a new client" -> Manager.addClient(request,response);

            case "Add a new car" -> Manager.addCar(request,response);

            case "Create a planned appointment" -> Manager.addPlannedAppointment(request,response);

            case "Create a current appointment" -> Manager.addCurrentAppointment(request,response);

            case "Change state" -> Mechanic.changeServiceState(request,response);

            case "Services cost" -> Accountant.calculateServicesCost(request,response);
        }
    }
}

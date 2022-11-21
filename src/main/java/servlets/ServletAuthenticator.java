package servlets;
import classes.others.DatabaseManager;
import classes.person.Accountant;
import classes.person.Manager;
import classes.person.Mechanic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ServletAuthenticator", value = "/ServletAuthenticator")
public class ServletAuthenticator extends HttpServlet
{
    /*
    The mechanic
    Password: 9383!Pof
    Hashcode: 225384315

    The manager
    Password: Uirf@34
    Hashcode: 1242845625

    The accountant
    Password: V945?3e
    Hashcode: 697431085
    */

    private boolean authenticateMechanic(String login, long hashcode)
    {
        //getting the list of all mechanics
        List<Mechanic> list_mechanics = DatabaseManager.getMechanics();
        boolean res = false;

        for (Mechanic mechanic : list_mechanics)
        {
            if (mechanic.getLogin().equals(login))
                if (mechanic.getPasswordHashcode() == hashcode)
                {
                    res = true;
                    break;
                }
        }

        return res;
    }


    private boolean authenticateManager(String login, long hashcode)
    {
        //getting the list of all managers
        List<Manager> list_managers = DatabaseManager.getManagers();
        boolean res = false;

        for (Manager manager : list_managers)
        {
            if (manager.getLogin().equals(login))
                if (manager.getPasswordHashcode() == hashcode)
                {
                    res = true;
                    break;
                }
        }

        return res;
    }


    private boolean authenticateAccountant(String login, long hashcode)
    {
        //getting the list of all managers
        List<Accountant> list_accountants = DatabaseManager.getAccountants();
        boolean res = false;

        for (Accountant accountant : list_accountants)
        {
            if (accountant.getLogin().equals(login))
                if (accountant.getPasswordHashcode() == hashcode)
                {
                    res = true;
                    break;
                }
        }

        return res;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { doPost(request,response); }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");

        //getting the data from user
        String input_login = request.getParameter("field_login");
        String input_password = request.getParameter("field_password");
        long password_hashcode = input_password.hashCode();

        if (authenticateMechanic(input_login,password_hashcode))
        {
            //redirecting the request to the mechanic's menu
            request.getRequestDispatcher("jsp/mechanic_menu.jsp").forward(request,response);
            log("The mechanic has been authenticated");
        }
        else if (authenticateManager(input_login,password_hashcode))
        {
            //redirecting the request to the manager's menu
            request.getRequestDispatcher("jsp/manager_menu.jsp").forward(request,response);
            log("The manager has been authenticated");
        }
        else if (authenticateAccountant(input_login,password_hashcode))
        {
            //redirecting the request to the accountant's menu
            request.getRequestDispatcher("jsp/accountant_menu.jsp").forward(request,response);
            log("The accountant has been authenticated");
        }
        else
        {
            response.getWriter().println("Authentication error");
            log("Authentication has failed");
        }
    }
}

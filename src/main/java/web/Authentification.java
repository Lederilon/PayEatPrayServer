package web;

import DAO.DAOFactory;
import DAO.DAOFactoryMySQL;
import DAO.ProfileDAO;
import domain.Profile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by I on 17.04.2017.
 */
public class Authentification extends  javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    try {
        java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        DAOFactory daoFactory = new DAOFactoryMySQL("jdbc:mysql://localhost:3306/payeatpray?user=root&password=rootme");
        ProfileDAO profileRep = daoFactory.getProfileDAO();
        List<Profile> profiles = profileRep.getAll();
        Profile userProfile = null;
        for(Profile profile : profiles){
           if(profile.getLogin().equals(login)&&profile.getPassword().equals(password))
           {
               userProfile = profile;
               break;
           }
        }
        request.getSession().setAttribute("profile",userProfile);
        request.getRequestDispatcher("WEB-INF/pages/registration/AuthentificationConfirmed.jsp").forward(request, response);
        if (userProfile == null )
        {
            request.getRequestDispatcher("WEB-INF/pages/registration/AuthentificationFailed.html").forward(request, response);
        }

    }
    catch (Exception e) {
        request.getRequestDispatcher("WEB-INF/pages/registration/AuthentificationFailed.html").forward(request, response);
    }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}

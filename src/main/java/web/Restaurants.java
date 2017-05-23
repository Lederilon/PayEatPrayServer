package web;

import DAO.DAOFactory;
import DAO.DAOFactoryMySQL;
import DAO.ProfileDAO;
import domain.Profile;
import domain.ProfileCategory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by I on 23.04.2017.
 */
public class Restaurants extends javax.servlet.http.HttpServlet  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
            java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            DAOFactory daoFActory = new DAOFactoryMySQL("jdbc:mysql://localhost:3306/payeatpray?user=root&password=rootme");
            ProfileDAO profileRep = daoFActory.getProfileDAO();
            List<Profile> profiles = profileRep.getAll();
            List<Profile> restaurants = new LinkedList<Profile>();
            for(Profile profile : profiles){
               if(profile.getCategory().getName().equals(ProfileCategory.CategoryNames.F)) restaurants.add(profile);
            }
           request.setAttribute("caterings",restaurants);
           request.getRequestDispatcher("WEB-INF/pages/restaurants.jsp").forward(request,response);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

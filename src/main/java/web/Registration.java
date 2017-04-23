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
import java.util.Date;
/**
 * Created by I on 17.04.2017.
 */
public class Registration extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usertypeCooking = request.getParameter("usertypeCooking");
        String usertypeCustomer = request.getParameter("usertypeCustomer");
        String usertypeShipment = request.getParameter("usertypeShipment");

        String acountName = request.getParameter("name");
        String acountLogin = request.getParameter("login");

        String accountPassword  = request.getParameter("password");
        String accountPasswordConfirmation  = request.getParameter("passwordConfirmation");

        String birthDate = request.getParameter("passwordConfirmation");
        String email =  request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
      if(accountPassword.equals(accountPasswordConfirmation)) {
          try {
              //Class.forName("com.mysql.jdbc.Driver");
              java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());
              DAOFactory daoFActory = new DAOFactoryMySQL("jdbc:mysql://localhost:3306/PAYEATPRAY?user=root&password=FICTIO53");
              ProfileDAO profileRep = daoFActory.getProfileDAO();
              Date date = new Date();
              ProfileCategory category = new ProfileCategory(1, ProfileCategory.CategoryNames.C);
              profileRep.createProfile(acountLogin, accountPassword, date, acountName, Profile.Sex.M, email, category);
              request.getRequestDispatcher("WEB-INF/pages/registration/RegistrationApprowed.html").forward(request, response);
          } catch (Exception e) {
              log("Error while Saving");
              request.getRequestDispatcher("WEB-INF/pages/registration/RegistrationImposible.html").forward(request, response);
          }
      }
      else{
          request.getRequestDispatcher("WEB-INF/pages/registration/RegistrationImposible.html").forward(request, response);
      }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

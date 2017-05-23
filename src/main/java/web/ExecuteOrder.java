package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExecuteOrder extends javax.servlet.http.HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String restaurant = req.getParameter("restaurant");
        String meal = req.getParameter("meal");
        String address = req.getParameter("address");
        String deliveryTime = req.getParameter("deliveryTime");


    }
}

package servlet;

import entity.Address;
import entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EmployeeServlet",
        urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = new Address();
        address.setStreetName("Rue D'Anjou");
        address.setStreetNumber("5090B");
        address.setCity("Brossard");
        address.setState("Quebec");
        address.setZipCode("A1A B2B");
        address.setCountry("Canada");

        Employee employee = new Employee();
        employee.setId(1099);
        employee.setName("Charles Unjeye");
        employee.setAddress(address);
        req.setAttribute("employee", employee);
        Map<String, String> capitals = new HashMap<>();
        capitals.put("China", "beijing");
        capitals.put("Austria", "vienna");
        capitals.put("Australia", "canberra");
        capitals.put("Canada", "ottawa");
        req.setAttribute("capitals", capitals);

        req.getRequestDispatcher("/employee.jsp").forward(req, resp);
    }
}

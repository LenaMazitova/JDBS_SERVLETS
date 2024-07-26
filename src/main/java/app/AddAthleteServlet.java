package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddAthleteServlet extends HttpServlet {

    private AthleteDAO athleteDAO;

    public void init() {
        String URL;
        String USER;
        String PASSWORD;

        try {
            FileInputStream fis = new FileInputStream(
                    "C:/Users/Elena/Desktop/Aston/Homework/JDBC_Servlets/jdbc_servlets/src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(fis);
            URL = properties.getProperty("db.host");
            USER = properties.getProperty("db.username");
            PASSWORD = properties.getProperty("db.password");

            Class.forName("org.postgresql.Driver");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load PostgreSQL", e);
        }
        athleteDAO = new AthleteDAO(URL, USER, PASSWORD);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("addAthlete.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int coach_id = Integer.parseInt(request.getParameter("coach_id"));

        Athlete newAthlete = new Athlete(name, surname, coach_id);
        try {
            athleteDAO.insertAthlete(newAthlete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("athleteName", name);
        request.setAttribute("athleteSurname", surname);
        doGet(request, response);
    }
}
package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {

    private AthleteDAO athleteDAO;
    private CoachDAO coachDAO;

    public void init() {
        String URL;
        String USER;
        String PASSWORD;

        try {

            Properties properties = new Properties();
            properties.load(new FileInputStream(
                    "C:/Users/Elena/Desktop/Aston/Homework/JDBC_Servlets/jdbc_servlets/src/main/resources/config.properties"));
            URL = properties.getProperty("db.host");
            USER = properties.getProperty("db.username");
            PASSWORD = properties.getProperty("db.password");

            Class.forName("org.postgresql.Driver");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load PostgreSQL", e);
        }

        athleteDAO = new AthleteDAO(URL, USER, PASSWORD);
        coachDAO = new CoachDAO(URL, USER, PASSWORD);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Athlete> listAthletes;
        List<Coach> listCoaches;
        try {
            listAthletes = athleteDAO.listAllAthletes();
            listCoaches = coachDAO.listAllCoaches();

            request.setAttribute("listAthletes", listAthletes);
            request.setAttribute("listCoaches", listCoaches);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to load lists of athletes and coaches", e);
        }
    }
}

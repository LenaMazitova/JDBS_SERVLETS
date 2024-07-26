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

public class UpdateAthleteServlet extends HttpServlet {

    private AthleteDAO athleteDAO;

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
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("updateAthlete.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String coach_id = request.getParameter("coach_id");

        Athlete athlete = new Athlete();
        try {
            // Содержит 4 поля: id, name, surname, coach_id
            athlete = athleteDAO.getAthlete(Integer.parseInt(id));
            if (athlete != null) {
                if (name != "") {
                    athlete.setName(name);
                } else {
                    athlete.setName(athlete.getName());
                }
                ;
                if (surname != "") {
                    athlete.setSurname(surname);
                } else {
                    athlete.setSurname(athlete.getSurname());
                }
                ;
                if (coach_id != "") {
                    athlete.setCoach_id(Integer.parseInt(coach_id));
                } else {
                    athlete.setCoach_id(athlete.getCoach_id());
                }
                athleteDAO.updateAthlete(athlete);
                request.setAttribute("name", athlete.getName());
                doGet(request, response);
            } else {
                doGet(request, response);
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }
}
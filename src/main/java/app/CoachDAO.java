package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoachDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public CoachDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Failed to load PostgreSQL", e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertCoach(Coach coach, int speciality_id) throws SQLException {
        String sqlInsertCoach = "INSERT INTO coach (name, surname) VALUES (?, ?)";
        String sqlInsertSpeciality = "INSERT INTO coach_speciality (coach_id, speciality_id) VALUES (?, ?)";

        connect();
        PreparedStatement st1 = jdbcConnection.prepareStatement(sqlInsertCoach, Statement.RETURN_GENERATED_KEYS);
        st1.setString(1, coach.getName());
        st1.setString(2, coach.getSurname());
        st1.executeUpdate();
        ResultSet rs = st1.getGeneratedKeys();
        // Индекс 1
        int newCoachId = rs.getInt("id");

        st1.close();

        PreparedStatement st2 = jdbcConnection.prepareStatement(sqlInsertSpeciality);
        st2.setInt(1, newCoachId);
        st2.setInt(2, speciality_id);
        boolean rowInserted2 = st2.executeUpdate() > 0;
        st2.close();

        disconnect();
        return rowInserted2;
    }

    public List<Coach> listAllCoaches() throws SQLException {
        List<Coach> listCoaches = new ArrayList<>();

        // String sql = "SELECT * FROM coache";
        String sql = "SELECT c.name, c.surname, s.description " +
                "FROM coach c JOIN coach_speciality cs ON c.id = cs.coach_id " +
                "JOIN speciality s ON cs.speciality_id=s.id";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            String name = resultSet.getString(1);
            String surname = resultSet.getString(2);
            String descr = resultSet.getString(3);

            Coach coach = new Coach(name, surname, descr);
            listCoaches.add(coach);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listCoaches;
    }

}

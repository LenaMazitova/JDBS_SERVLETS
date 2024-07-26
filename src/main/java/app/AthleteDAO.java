package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AthleteDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public AthleteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public boolean insertAthlete(Athlete athlete) throws SQLException {
        String sql = "INSERT INTO athlete (name, surname, coach_id) VALUES (?, ?, ?)";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, athlete.getName());
        statement.setString(2, athlete.getSurname());
        statement.setInt(3, athlete.getCoach_id());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Athlete> listAllAthletes() throws SQLException {
        List<Athlete> listAthletes = new ArrayList<>();

        String sql = "SELECT a.name, a.surname, c.name, c.surname " +
                "FROM athlete a JOIN coach c ON a.coach_id=c.id";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String name = resultSet.getString(1);
            String surname = resultSet.getString(2);

            String coach_name = resultSet.getString(3);
            String coach_surname = resultSet.getString(4);

            Coach coach = new Coach(coach_name, coach_surname);
            Athlete athlete = new Athlete(name, surname, coach);
            listAthletes.add(athlete);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listAthletes;
    }

    public boolean deleteAthlete(int id) throws SQLException {
        String sql = "DELETE FROM athlete where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateAthlete(Athlete athlete) throws SQLException {
        String sql = "UPDATE athlete SET name = ?, surname = ?, coach_id = ?";
        sql += " WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, athlete.getName());
        statement.setString(2, athlete.getSurname());
        statement.setInt(3, athlete.getCoach_id());
        statement.setInt(4, athlete.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Athlete getAthlete(int id) throws SQLException {
        Athlete athlete = null;
        String sql = "SELECT * FROM athlete WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            int coach_id = resultSet.getInt(4);

            athlete = new Athlete(id, name, surname, coach_id);
        }

        resultSet.close();
        statement.close();

        return athlete;
    }
}

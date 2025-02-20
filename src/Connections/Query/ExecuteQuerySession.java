package Connections.Query;
import Connections.ConnectionSQL;
import Model.Session;
import java.sql.*;
import java.time.LocalDateTime;

public class ExecuteQuerySession {
    private Session session;
    public Session getSession() {
        return this.session;
    }

    public ExecuteQuerySession(String query) {
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            selectQuery(query, preparedStatement);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
    private void selectQuery(String query, PreparedStatement preparedStatement) throws SQLException {
        if (query.contains("SELECT * FROM sessions ORDER BY id LIMIT 1 OFFSET ")) {
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                LocalDateTime localDateTime;
                try {
                    Timestamp playedTimeData = rs.getTimestamp("played_time");
                    localDateTime = playedTimeData.toLocalDateTime();
                } catch (SQLException e) {
                    Date playedTimeData = rs.getDate("played_time");
                    localDateTime = playedTimeData.toLocalDate().atStartOfDay();
                }
                boolean finishedBoolean = (rs.getInt("finished") != 0);
                this.session = new Session(rs.getInt("id"), localDateTime, finishedBoolean, rs.getInt("rooms_id"));
            } else {
                System.out.println("No se encontró ninguna sesión con ID.");
            }
        } else if (query.trim().toUpperCase().startsWith("SELECT")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("played_time"));
            }
        } else {
            preparedStatement.executeUpdate();
        }
    }
}
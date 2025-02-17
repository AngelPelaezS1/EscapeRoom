package Connections.Query;
import Connections.ConnectionSQL;
import Model.Session;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ExecuteQuerySession {
    private Session session;
    public Session getSession() {
        return this.session;
    }

    public ExecuteQuerySession(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if(query.contains("SELECT * FROM sessions ORDER BY id LIMIT 1 OFFSET ")){
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    Date playedTimeData = rs.getDate("played_time");
                    LocalDateTime localDateTime = playedTimeData.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();
                    int finished = rs.getInt("finished");
                    boolean finishedBoolean = false;
                    if(finished!=0){finishedBoolean = true;}
                    int sesionId = rs.getInt("sesionId");
                    this.session=new Session(id, localDateTime,finishedBoolean,sesionId);
                } else {
                    System.out.println("No se encontró ninguna sesión con ID ");
                }
            } else if(query.trim().toUpperCase().startsWith("SELECT")){
                ResultSet rs = preparedStatement.executeQuery();
                System.out.println("Lista de sesiones:");
                while (rs.next()) {
                    String playedTime = rs.getString("played_time");
                    System.out.println(playedTime);
                }
        }else{
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
}

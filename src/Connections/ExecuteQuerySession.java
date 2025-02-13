package Connections;
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
                    this.session=new Session(id, localDateTime, finishedBoolean, sesionId);
                } else {
                    System.out.println("No se encontró ninguna sesión con ID ");
                }
            }else if(query.contains("SELECT name FROM sessions")){
                ResultSet rs = preparedStatement.executeQuery();
                System.out.println("Lista :");
                while (rs.next()) {
                    String name = rs.getString("played_time");
                    System.out.println(name);
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

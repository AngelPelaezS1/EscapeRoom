package Connections.Query;
import Connections.ConnectionSQL;
import Model.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryTrack {
    private Track track;

    public Track getTrack() {return this.track;}

    public ExecuteQueryTrack(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if(query.contains("SELECT * FROM tracks ORDER BY id LIMIT 1 OFFSET ")){
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String topics = rs.getString("topics");
                    String track_details = rs.getString("track_details");
                    int rooms_id = rs.getInt("rooms_id");
                    this.track=new Track(name, topics, track_details, rooms_id);
                } else {
                    System.out.println("No se encontró ningun track con ID ");
                }
            }else if(query.contains("SELECT name FROM tracks")){
                ResultSet rs = preparedStatement.executeQuery();
                System.out.println("Lista :");
                while (rs.next()) {
                    String name = rs.getString("name");
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

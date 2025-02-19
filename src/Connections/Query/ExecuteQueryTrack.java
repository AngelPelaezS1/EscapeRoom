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
            selectQuery(query, preparedStatement);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
    private void selectQuery(String query, PreparedStatement preparedStatement) throws SQLException {
        if(query.contains("SELECT * FROM tracks ORDER BY id LIMIT 1 OFFSET ")){
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                this.track=new Track(rs.getString("name"), rs.getString("topics"), rs.getString("track_details"), rs.getInt("rooms_id"));
            } else {
                System.out.println("No se encontró ningun track con ID ");
            }
        }else if(query.contains("SELECT name FROM tracks")){
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Lista :");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }else{
            preparedStatement.executeUpdate();
        }
    }
}

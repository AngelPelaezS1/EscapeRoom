package Connections.Query;
import Connections.ConnectionSQL;
import Model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryRoom {
    private Room room;
    public Room getRoom() {
        return this.room;
    }

    public ExecuteQueryRoom(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if(query.contains("SELECT * FROM rooms ORDER BY id LIMIT 1 OFFSET ")){
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int difficulty = rs.getInt("difficulty");
                    this.room=new Room(id, name,difficulty);
                } else {
                    System.out.println("No se encontró ninguna room con ID ");
                }
            }else if(query.contains("SELECT name FROM rooms")){
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    System.out.println(name);
                }
            }else{
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
    private void selectQuery(String query, PreparedStatement preparedStatement) throws SQLException {
        if(query.contains("SELECT * FROM rooms ORDER BY id LIMIT 1 OFFSET ")){
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                this.room=new Room(rs.getInt("id"), rs.getString("name"),rs.getInt("difficulty"));
            } else {
                System.out.println("No se encontró ninguna room con ID ");
            }
        }else if(query.contains("SELECT name FROM rooms")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }else{
            preparedStatement.executeUpdate();
        }
    }
}

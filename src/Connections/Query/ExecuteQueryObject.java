package Connections.Query;
import Connections.ConnectionSQL;
import Model.Object;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryObject {
    private Object object;

    public static Object getObject() {
        return this.object;
    }

    public ExecuteQueryObject(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if(query.contains("SELECT * FROM objects ORDER BY id LIMIT 1 OFFSET ")){
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String material = rs.getString("material");
                    float price = rs.getFloat("price");
                    int rooms_id = rs.getInt("rooms_id");
                    this.object=new Object(id, name, material, price, rooms_id);
                } else {
                    System.out.println("No se encontró ninguna objecto con ID ");
                }
            }else if(query.contains("SELECT name FROM objects")){
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
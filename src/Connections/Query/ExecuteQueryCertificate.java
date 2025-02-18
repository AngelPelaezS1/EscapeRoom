package Connections.Query;
import Connections.ConnectionSQL;
import Model.Certificate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryCertificate {
    private Certificate certificate;

    public Certificate getCertificate() {
        return this.certificate;
    }

    public ExecuteQueryCertificate(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if(query.contains("SELECT * FROM certificates ORDER BY id LIMIT 1 OFFSET ")){
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String achievement = rs.getString("achievement");
                    String gift = rs.getString("gift");
                    int players_id = rs.getInt("players_id");
                    this.certificate=new Certificate(id, name, achievement, gift, players_id);
                } else {
                    System.out.println("No se encontró ninguna certificate con ID ");
                }
            }else if(query.contains("SELECT name FROM certificates")){
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

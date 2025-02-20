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
             selectQuery(query, preparedStatement);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
    private void selectQuery(String query, PreparedStatement preparedStatement) throws SQLException {
        if(query.contains("SELECT * FROM certificates ORDER BY id LIMIT 1 OFFSET ")){
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                this.certificate=new Certificate(rs.getInt("id"), rs.getString("name"), rs.getString("achievement"), rs.getString("gift"), rs.getInt("players_id"));
            } else {
                System.out.println("No se encontró ninguna certificate con ID ");
            }
        }else if(query.contains("SELECT name FROM certificates")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {System.out.println(rs.getString("name"));}
        }else{
            preparedStatement.executeUpdate();
        }
    }
}

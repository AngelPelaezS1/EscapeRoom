package Connections.Query;
import Connections.ConnectionSQL;
import Model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryClient {
    private Client client;
    public Client getClient() {
        return this.client;
    }

    public ExecuteQueryClient(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             selectQuery(query, preparedStatement);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
    private void selectQuery(String query, PreparedStatement preparedStatement) throws SQLException {
        if(query.contains("SELECT * FROM clients ORDER BY id LIMIT 1 OFFSET ")){
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                boolean notificationBoolean = false;
                if(rs.getInt("notification")!=0){notificationBoolean = true;}
                this.client = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("mail"), notificationBoolean, rs.getInt("sessions_id"));
            } else {
                System.out.println("No se encontró ninguna client con ID ");
            }
        }else if(query.contains("SELECT name FROM clients")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }else{
            preparedStatement.executeUpdate();
        }
    }
}

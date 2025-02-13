package Connections;
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
            if(query.contains("SELECT * FROM clients ORDER BY id LIMIT 1 OFFSET ")){
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String mail = rs.getString("mail");
                    int notification = rs.getInt("notification");
                    boolean notificationBoolean = false;
                    if(notification!=0){notificationBoolean = true;}
                    int sesionId = rs.getInt("sesionId");
                    this.client=new Client(id, name, mail, notificationBoolean, sesionId);
                } else {
                    System.out.println("No se encontró ninguna client con ID ");
                }
            }else if(query.contains("SELECT name FROM clients")){
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

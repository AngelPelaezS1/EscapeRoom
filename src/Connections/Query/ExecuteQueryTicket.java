package Connections.Query;
import Connections.ConnectionSQL;
import Model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryTicket {
    private Ticket ticket;

    public Ticket getTicket() {
        return this.ticket;
    }

    public ExecuteQueryTicket(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if(query.contains("SELECT * FROM tickets ORDER BY id LIMIT 1 OFFSET ")){
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    double price = rs.getDouble("price");
                    int players_id = rs.getInt("players_id");
                    this.ticket=new Ticket(id, price, players_id);
                } else {
                    System.out.println("No se encontró ninguna ticket con ID ");
                }
            }else if(query.contains("SELECT name FROM tickets")){
                ResultSet rs = preparedStatement.executeQuery();
                System.out.println("Lista :");
                while (rs.next()) {
                    String name = rs.getString("players_id");
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

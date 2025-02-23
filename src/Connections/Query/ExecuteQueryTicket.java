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
            selectQuery(query, preparedStatement);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
    private void selectQuery(String query, PreparedStatement preparedStatement) throws SQLException {
        if(query.contains("SELECT * FROM tickets ORDER BY id LIMIT 1 OFFSET ")){
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                this.ticket=new Ticket(rs.getInt("id"), rs.getFloat("price"), rs.getInt("players_id"));
            } else {
                System.out.println("No se encontró ninguna ticket con ID ");
            }
        }else if(query.contains("SELECT price FROM tickets")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("price"));
            }
        }else{
            preparedStatement.executeUpdate();
        }
    }
}

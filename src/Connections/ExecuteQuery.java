package Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteQuery {

    public ExecuteQuery(String query){

        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
            System.out.println("Query ejecutada correctamente: " + query);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }
}

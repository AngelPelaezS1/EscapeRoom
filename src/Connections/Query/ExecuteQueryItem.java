package Connections.Query;
import Connections.ConnectionSQL;
import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryItem {
    private Item item;
    private double totalValueObjects=-1;

    public Item getItem() {return this.item;}

    public double getTotalValueObjects() {
        return totalValueObjects;
    }

    public ExecuteQueryItem(String query){
        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        try (Connection connection = ConnectionSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            selectQuery(query, preparedStatement);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la query: " + e.getMessage());
        }
    }

    private void selectQuery(String query, PreparedStatement preparedStatement) throws SQLException {
        if (query.contains("SELECT * FROM objects ORDER BY id LIMIT 1 OFFSET ")) {
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                this.item = new Item(rs.getInt("id"), rs.getString("name"), rs.getString("material"), rs.getFloat("price"), rs.getInt("rooms_id"));
            } else {
                System.out.println("No se encontró ninguna objecto con ID ");
            }
        } else if (query.contains("SELECT name FROM objects")) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } else if (query.contains("SELECT SUM(price) AS total_price FROM objects")) {
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) { // Mueve el cursor a la primera fila
                totalValueObjects = rs.getDouble("total_price");
            } else {
                totalValueObjects = 0; // Si no hay registros, devuelve 0 en lugar de -1
            }
        }else{
            preparedStatement.executeUpdate();
        }
    }
}
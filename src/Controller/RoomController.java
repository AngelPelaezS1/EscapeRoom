package Controller;

import Model.DatabaseManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RoomController {
    Scanner sc = new Scanner(System.in);

    public void addRoom(){
        System.out.println("Introduce el nombre de la habitacion");
        String name = sc.nextLine();
        System.out.println("Introduce la dificultad (1-10)");
        int difficulty = sc.nextInt();
        sc.nextLine();

        String query = "Insert Into rooms(name, difficulty) Values('" + name + "', " + difficulty + ")";
        try (Connection connection = DatabaseManager.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Habitacion añadida con exito");
        } catch(SQLException e){
            System.out.println("Error al añadir la habitacion: " + e.getMessage());
        }
    }

    public void deleteRoom(){
        System.out.println("Introduce el ID de la room a eliminar");
        int id = sc.nextInt();
        sc.nextLine();

        String query = "Delete From rooms Where id=" +id;
        try (Connection connection = DatabaseManager.getConnection(); Statement statement = connection.createStatement()){
            int affectedRows = statement.executeUpdate(query);
            if (affectedRows > 0){
                System.out.println("Habitacion eliminada");
            }else{
                System.out.println("No se encontro ninguna habitacion con ese ID");
            }
        }catch(SQLException e){
            System.out.println("Error al eliminar la habitacion: " + e.getMessage());
        }
    }

    public void showRooms(){
        String query = "Select id, name, difficulty From rooms";

        try (Connection connection = DatabaseManager.getConnection(); Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Lista de habitaciones:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("name") + ", Dificultad: " + resultSet.getInt("difficulty"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar las habitaciones: " + e.getMessage());
        }
    }

    public void modifyRoom(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduce el ID de la habitación a modificar:");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Introduce el nuevo nombre de la habitación:");
            String newName = scanner.nextLine();

            String query = "Update rooms set name = '" + newName + "' where id = " + id;

            try (Connection connection = DatabaseManager.getConnection(); Statement statement = connection.createStatement()) {
                int affectedRows = statement.executeUpdate(query);
                if (affectedRows > 0) {
                    System.out.println("Habitación modificada correctamente.");
                } else {
                    System.out.println("No se encontró ninguna habitación con ese ID.");
                }
            } catch (SQLException e) {
                System.out.println("Error al modificar la habitación: " + e.getMessage());
            }
        }

    }

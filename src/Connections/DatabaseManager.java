package Connections;
import java.sql.*;

public class DatabaseManager {
    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/escaperoom";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        // Prueba de inserción
        //addRoom("El Misterio del Laberinto", 4);
        //addRoom("El Misterio del Terror", 2);
        getAllRoomNames();
        ExecuteQuery executeQuery=new ExecuteQuery("INSERT INTO rooms (name, difficulty) VALUES ('Laa', 3)");
        getAllRoomNames();
        //deleteRoom(1);
        //getAllRoomNames();
        //getRoomById(1);
        // Prueba de lectura de todos los nombres de las rooms
        //getAllRoomNames();
        //getRoomByName("El Misterio del Laberinto");
    }

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para añadir una nueva room
    public static void addRoom(String name, int difficulty) throws SQLException {
        String sql = "INSERT INTO rooms (name, difficulty) VALUES (?, ?)";

        ConnectionSQL connectionSQL = ConnectionSQL.getInstanceConnectionSQL();
        //Connection connection = connectionSQL.getConnection();

        try (Connection connection = ConnectionSQL.getConnection();//Connection conn = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, difficulty);
            pstmt.executeUpdate();

            System.out.println("Room añadida correctamente: " + name);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al insertar la room: " + e.getMessage());
        }
    }

    // Método para eliminar una room por su ID
    public static void deleteRoom(int roomId) {
        String sql = "DELETE FROM rooms WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, roomId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Room con ID " + roomId + " eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna room con ID " + roomId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al eliminar la room: " + e.getMessage());
        }
    }


    // Método para leer una room por su ID
    public static void getRoomById(int roomId) {
        String sql = "SELECT * FROM rooms WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int difficulty = rs.getInt("difficulty");

                System.out.println("Room encontrada:");
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + name);
                System.out.println("Dificultad: " + difficulty);
            } else {
                System.out.println("No se encontró ninguna room con ID " + roomId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al leer la room: " + e.getMessage());
        }
    }

    // Método para buscar una room por su nombre
    public static void getRoomByName(String roomName) {
        String sql = "SELECT * FROM rooms WHERE name = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, roomName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int difficulty = rs.getInt("difficulty");

                System.out.println("Room encontrada:");
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + name);
                System.out.println("Dificultad: " + difficulty);
            } else {
                System.out.println("No se encontró ninguna room con el nombre: " + roomName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al buscar la room: " + e.getMessage());
        }
    }

    // Método para obtener y mostrar los nombres de todas las rooms
    public static void getAllRoomNames() {
        String sql = "SELECT name FROM rooms";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Lista de Rooms:");
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al leer los nombres de las rooms: " + e.getMessage());
        }
    }
}

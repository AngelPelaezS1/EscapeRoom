package Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    private static ConnectionSQL instanceConnectionSQL;
    private String URL;
    private String USER;
    private String PASSWORD;

    private ConnectionSQL(){
        this.URL="jdbc:mysql://localhost:3306/escaperoom?serverTimezone=Europe/Madrid";
        this.USER="root";
        this.PASSWORD="";
    }

    public static ConnectionSQL getInstanceConnectionSQL(){
        if(instanceConnectionSQL==null){
            instanceConnectionSQL = new ConnectionSQL();
        }
        return instanceConnectionSQL;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(instanceConnectionSQL.URL, instanceConnectionSQL.USER, instanceConnectionSQL.PASSWORD);
    }
}

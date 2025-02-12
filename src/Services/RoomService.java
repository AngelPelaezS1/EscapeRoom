package Services;
import Connections.ExecuteQuery;
import Model.Room;

import static Connections.DatabaseManager.getAllRoomNames;

public class RoomService {
    public static void addRoom(Room room){
        String name=room.getName();
        int difficulty=room.getDifficulty();
        ExecuteQuery executeQuery=new ExecuteQuery("INSERT INTO rooms (name, difficulty) VALUES ('"+name+"', "+difficulty+")");
    }
    public static void deleteRoom(int roomPosition){
        ExecuteQuery executeQuery=new ExecuteQuery("DELETE FROM rooms WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM rooms ORDER BY id LIMIT 1 OFFSET "+(roomPosition-1)+") AS subquery)");
    }
    public static void seeRooms(){
        getAllRoomNames();
    }

    public static Room getRoom(int roomPosition){
        ExecuteQuery executeQuery=new ExecuteQuery("SELECT * FROM rooms ORDER BY id LIMIT 1 OFFSET "+(roomPosition-1));
        return executeQuery.getRoom();
    }

    public static void updateRoom(Room room){
        System.err.println(room.getName());
        System.err.println(room.getId());
        ExecuteQuery executeQuery=new ExecuteQuery("UPDATE rooms SET name = '"+room.getName()+"', difficulty = "+room.getDifficulty()+" WHERE id = "+room.getId());
    }
}

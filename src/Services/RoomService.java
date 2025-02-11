package Services;
import Connections.ExecuteQuery;
import Model.Room;

import java.sql.ResultSet;

import static Connections.DatabaseManager.getAllRoomNames;

public class RoomService {
    public void addRoom(Room room){
        String name=room.getName();
        int difficulty=room.getDifficulty();
        ExecuteQuery executeQuery=new ExecuteQuery("INSERT INTO rooms (name, difficulty) VALUES ('"+name+"', "+difficulty+")");
    }
    public void deleteRoom(int roomPosition){
        ExecuteQuery executeQuery=new ExecuteQuery("DELETE FROM rooms WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM rooms ORDER BY id LIMIT 1 OFFSET "+(roomPosition-1)+") AS subquery)");
    }
    public void seeRooms(){
        getAllRoomNames();
    }
}

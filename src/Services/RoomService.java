package Services;
import Connections.Query.ExecuteQueryRoom;
import Model.Room;

public class RoomService {
    ExecuteQueryRoom executeQueryRoom;
    public void addRoom(Room room){
        executeQueryRoom =new ExecuteQueryRoom("INSERT INTO rooms (name, difficulty) VALUES ('"+room.getName()+"', "+room.getDifficulty()+")");
    }
    public void deleteRoom(int roomPosition){
        executeQueryRoom =new ExecuteQueryRoom("DELETE FROM rooms WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM rooms ORDER BY id LIMIT 1 OFFSET "+(roomPosition-1)+") AS subquery)");
    }
    public void seeRooms(){
        executeQueryRoom =new ExecuteQueryRoom("SELECT name FROM rooms");
    }
    public Room getRoom(int roomPosition){
        executeQueryRoom =new ExecuteQueryRoom("SELECT * FROM rooms ORDER BY id LIMIT 1 OFFSET "+(roomPosition-1));
        return executeQueryRoom.getRoom();
    }
    public void updateRoom(Room room){
        executeQueryRoom =new ExecuteQueryRoom("UPDATE rooms SET name = '"+room.getName()+"', difficulty = "+room.getDifficulty()+" WHERE id = "+room.getId());
    }
}

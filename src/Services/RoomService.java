package Services;
import Connections.Query.ExecuteQueryRoom;
import Model.Room;

public class RoomService {
    public void addRoom(Room room){
        String name=room.getName();
        int difficulty=room.getDifficulty();
        ExecuteQueryRoom executeQueryRoom =new ExecuteQueryRoom("INSERT INTO rooms (name, difficulty) VALUES ('"+name+"', "+difficulty+")");
    }
    public void deleteRoom(int roomPosition){
        ExecuteQueryRoom executeQueryRoom =new ExecuteQueryRoom("DELETE FROM rooms WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM rooms ORDER BY id LIMIT 1 OFFSET "+(roomPosition-1)+") AS subquery)");
    }
    public void seeRooms(){
        ExecuteQueryRoom executeQueryRoom =new ExecuteQueryRoom("SELECT name FROM rooms");
    }

    public Room getRoom(int roomPosition){
        ExecuteQueryRoom executeQueryRoom =new ExecuteQueryRoom("SELECT * FROM rooms ORDER BY id LIMIT 1 OFFSET "+(roomPosition-1));
        return executeQueryRoom.getRoom();
    }

    public void updateRoom(Room room){
        ExecuteQueryRoom executeQueryRoom =new ExecuteQueryRoom("UPDATE rooms SET name = '"+room.getName()+"', difficulty = "+room.getDifficulty()+" WHERE id = "+room.getId());
    }
}

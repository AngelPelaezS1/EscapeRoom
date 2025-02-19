package Services;
import Connections.Query.ExecuteQueryTrack;
import Model.Track;

public class TrackService {
    ExecuteQueryTrack executeQueryTrack;
    public void addTrack(Track track){
        executeQueryTrack=new ExecuteQueryTrack("INSERT INTO tracks (name, topics, track_details, rooms_Id) VALUES ('"+track.getName()+"', '"+track.getTopics()+"', '"+track.getDetails()+"', "+track.getRoomId()+")");
    }
    public void deleteTrack(int trackPosition){
        executeQueryTrack=new ExecuteQueryTrack("DELETE FROM tracks WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM tracks ORDER BY id LIMIT 1 OFFSET "+(trackPosition-1)+") AS subquery)");
    }
    public void seeTrack(){
        executeQueryTrack =new ExecuteQueryTrack("SELECT name FROM tracks");
    }
    public Track getTrack(int trackPosition){
        executeQueryTrack=new ExecuteQueryTrack("SELECT * FROM tracks ORDER BY id LIMIT 1 OFFSET "+(trackPosition-1));
        return executeQueryTrack.getTrack();
    }
    public void updateTrack(Track track){
        executeQueryTrack=new ExecuteQueryTrack("UPDATE tracks SET name = '"+track.getName()+"', topics = '"+track.getTopics()+"', track_details = '"+track.getDetails()+"', rooms_id = "+track.getRoomId()+" WHERE id = "+track.getId());
    }
}

package Services;
import Connections.Query.ExecuteQueryItem;
import Connections.Query.ExecuteQueryTrack;
import Model.Track;

public class TrackService {
    public void addTrack(Track track){
        String name=track.getName();
        String topics=track.getTopics();
        String track_details=track.getDetails();
        int rooms_Id=track.getId();
        ExecuteQueryTrack executeQueryTrack =new ExecuteQueryTrack("INSERT INTO tracks (name, topics, track_details, rooms_Id) VALUES ('"+name+"', '"+topics+"', '"+track_details+"', "+rooms_Id+")");
    }
    public void deleteTrack(int trackPosition){
        ExecuteQueryTrack executeQueryTrack =new ExecuteQueryTrack("DELETE FROM tracks WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM tracks ORDER BY id LIMIT 1 OFFSET "+(trackPosition-1)+") AS subquery)");
    }
    public void seeTrack(){
        ExecuteQueryTrack executeQueryTrack =new ExecuteQueryTrack("SELECT name FROM tracks");
    }

    public Track getTrack(int trackPosition){
        ExecuteQueryTrack executeQueryTrack =new ExecuteQueryTrack("SELECT * FROM tracks ORDER BY id LIMIT 1 OFFSET "+(trackPosition-1));
        return executeQueryTrack.getTrack();
    }

    public void updateTrack(Track track){
        ExecuteQueryTrack executeQueryTrack =new ExecuteQueryTrack("UPDATE tracks SET name = '"+track.getName()+"', topics = '"+track.getTopics()+"', track_details = "+track.getDetails()+", rooms_Id = "+track.getRoomId()+" WHERE id = "+track.getId());
    }
}

package Services;
import Connections.Query.ExecuteQuerySession;
import Model.Session;

public class SessionService {
    ExecuteQuerySession executeQuerySession;
    public void addSession(Session session){
        int finichedBoolean=0;
        if(session.isFinished()){finichedBoolean=1;}
        executeQuerySession =new ExecuteQuerySession("INSERT INTO sessions (played_time, finished, rooms_id) VALUES ('"+session.getPlayedTime()+"', "+finichedBoolean+", "+session.getRoomId()+")");
    }
    public void deleteSession(int sessionPosition){
        executeQuerySession =new ExecuteQuerySession("DELETE FROM sessions WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM sessions ORDER BY id LIMIT 1 OFFSET "+(sessionPosition-1)+") AS subquery)");
    }
    public void seeSessions(){
        executeQuerySession = new ExecuteQuerySession("SELECT id, played_time, finished, rooms_id FROM sessions");
    }

    public Session getSession(int sessionPosition){

        ExecuteQuerySession executeQuerySession =new ExecuteQuerySession("SELECT * FROM sessions ORDER BY id LIMIT 1 OFFSET "+(sessionPosition-1));

        return executeQuerySession.getSession();
    }
    public void updateSession(Session session){
        int finished=0;
        if(session.isFinished()){finished=1;}
        executeQuerySession =new ExecuteQuerySession("UPDATE sessions SET played_time = '"+session.getPlayedTime()+"', finished = "+finished+", rooms_id = "+session.getRoomId()+" WHERE id = "+session.getId());
    }
}

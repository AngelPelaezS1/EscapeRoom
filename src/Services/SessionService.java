package Services;
import Connections.ExecuteQuerySession;
import Model.Session;
import java.time.LocalDateTime;

public class SessionService {
    public static void addSession(Session session){
        LocalDateTime played_time=session.getPlayedTime();
        boolean finished=session.isFinished();
        int finichedBoolean=0;
        if(finished){finichedBoolean=1;}
        int rooms_id=session.getRoomId();
        ExecuteQuerySession executeQuerySession =new ExecuteQuerySession("INSERT INTO sessions (played_time, finished, rooms_id) VALUES ('"+played_time+"', "+finichedBoolean+", "+rooms_id+")");
    }
    public static void deleteSession(int sessionPosition){
        ExecuteQuerySession executeQuerySession =new ExecuteQuerySession("DELETE FROM sessions WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM sessions ORDER BY id LIMIT 1 OFFSET "+(sessionPosition-1)+") AS subquery)");
    }
    public static void seeSessions(){
        ExecuteQuerySession executeQuerySession =new ExecuteQuerySession("SELECT name FROM sessions");
    }

    public static Session getSession(int sessionPosition){
        ExecuteQuerySession executeQuerySession =new ExecuteQuerySession("SELECT * FROM sessions ORDER BY id LIMIT 1 OFFSET "+(sessionPosition-1));
        return executeQuerySession.getSession();
    }

    public static void updateSession(Session session){
        int finished=0;
        if(session.isFinished()==true){finished=1;}
        ExecuteQuerySession executeQuerySession =new ExecuteQuerySession("UPDATE sessions SET played_time = '"+session.getPlayedTime()+"', finished = "+finished+", rooms_id = "+session.getRoomId()+" WHERE id = "+session.getId());
    }
}

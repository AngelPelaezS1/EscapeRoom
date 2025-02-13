package Model;

import java.time.LocalDateTime;

public class Session {
    private int id;
    private LocalDateTime playedTime;
    private boolean finished=false;
    private int roomId;


    public Session(LocalDateTime playedTime, int roomId) {
        this.playedTime = playedTime;
        this.roomId = roomId;
    }


    public Session(int id, LocalDateTime playedTime ,boolean finished,int roomId) {
        this.id = id;
        this.playedTime = playedTime;
        this.finished = finished;
        this.roomId=roomId;
    }


    public int getId() {
        return id;
    }

    public LocalDateTime getPlayedTime() {
        return playedTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setPlayedTime(LocalDateTime playedTime) {
        this.playedTime = playedTime;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", playedTime=" + playedTime +
                ", finished=" + finished +
                ", roomId=" + roomId +
                '}';
    }
}

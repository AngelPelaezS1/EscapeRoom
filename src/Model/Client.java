package Model;

public class Client {
    private int id;
    private String name;
    private  String mail;
    private boolean notifications;
    private int sessionId;

    public Client( String name, String mail, boolean notifications, int sessionId) {
        this.name = name;
        this.mail = mail;
        this.notifications = notifications;
        this.sessionId=sessionId;
    }

    public Client(int id, String name, String mail, boolean notifications, int sessionId) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.notifications = notifications;
        this.sessionId = sessionId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", notifications=" + notifications +
                ", sesionId=" + sessionId +
                '}';
    }
}

package Classes;

public class Ticket {
    private int  id;
    private int  userId;
    private int  roomId;
    private double price;

    public Ticket(int id, int userId, int roomId, double price) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.price = price;
    }
}

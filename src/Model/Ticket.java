package Model;

public class Ticket {
    private int  id;
    private int  userId;
    private double price;

    public Ticket( float price,int userId) {
        this.userId = userId;
        this.price = price;
    }

    public Ticket(int id, float price, int userId) {
        this.id = id;
        this.userId = userId;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getUserId() {
        return userId;
    }
    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", price=" + price +
                '}';
    }
}

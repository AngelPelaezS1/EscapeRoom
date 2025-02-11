package Model;

public class Room {

    private int id;
    private String name;
    private int difficulty;

    public Room(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}

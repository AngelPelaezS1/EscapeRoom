package Services;
import Connections.Query.ExecuteQueryItem;
import Model.Item;

public class ItemService {
    ExecuteQueryItem executeQueryItem;

    public void addItem(Item item) {
        executeQueryItem = new ExecuteQueryItem("INSERT INTO objects (name, material, price, rooms_id) VALUES ('" + item.getName() + "', '" + item.getMaterial() + "', " + item.getPrice() + ", " + item.getRoomId() + ")");
    }

    public void deleteItem(int itemPosition) {
        executeQueryItem = new ExecuteQueryItem("DELETE FROM objects WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM objects ORDER BY id LIMIT 1 OFFSET " + (itemPosition - 1) + ") AS subquery)");
    }

    public void seeItem() {
        executeQueryItem = new ExecuteQueryItem("SELECT name FROM objects");
    }

    public Item getItem(int itemPosition) {
        executeQueryItem = new ExecuteQueryItem("SELECT * FROM objects ORDER BY id LIMIT 1 OFFSET " + (itemPosition - 1));
        return executeQueryItem.getItem();
    }

    public void updateItem(Item item) {
        executeQueryItem = new ExecuteQueryItem("UPDATE objects SET name = '" + item.getName() + "', material = '" + item.getMaterial() + "', price = " + item.getPrice() + ", rooms_Id = " + item.getRoomId() + " WHERE id = " + item.getId());
    }

    public double totalValueObjects() {
        executeQueryItem = new ExecuteQueryItem("SELECT SUM(price) AS total_price FROM objects");
        double total = executeQueryItem.getTotalValueObjects();
        System.out.println("El precio total del inventario es: " + total);
        return total;
    }
}
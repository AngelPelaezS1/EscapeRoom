package Services;
import Connections.Query.ExecuteQueryItem;
import Model.Item;

public class ItemService {
    public void addItem(Item item){
            ExecuteQueryItem executeQueryItem = new ExecuteQueryItem("INSERT INTO objects (name, material, price, rooms_Id) VALUES ('"+item.getName()+"', '"+item.getMaterial()+"', "+item.getPrice()+", "+item.getRoomId()+")");
    }
    public void deleteItem(int itemPosition){
        ExecuteQueryItem executeQueryItem =new ExecuteQueryItem("DELETE FROM objects WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM objects ORDER BY id LIMIT 1 OFFSET "+(itemPosition-1)+") AS subquery)");
    }
    public void seeItem(){
        ExecuteQueryItem executeQueryItem =new ExecuteQueryItem("SELECT name FROM objects");
    }

    public Item getItem(int itemPosition){
        ExecuteQueryItem executeQueryItem =new ExecuteQueryItem("SELECT * FROM objects ORDER BY id LIMIT 1 OFFSET "+(itemPosition-1));
        return executeQueryItem.getItem();
    }

    public void updateItem(Item item){
        ExecuteQueryItem executeQueryItem =new ExecuteQueryItem("UPDATE objects SET name = '"+item.getName()+"', material = '"+item.getMaterial()+"', price = "+item.getPrice()+", rooms_Id = "+item.getRoomId()+" WHERE id = "+item.getId());
    }
}

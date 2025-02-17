package Services;
import Connections.Query.ExecuteQueryItem;
import Model.Item;

public class ItemService {
    public void addItem(Item item){
        String name=item.getName();
        String material=item.getMaterial();
        float price=item.getPrice();
        int rooms_Id=item.getId();
        ExecuteQueryItem executeQueryItem =new ExecuteQueryItem("INSERT INTO objects (name, material, price, rooms_Id) VALUES ('"+name+"', '"+material+"', "+price+", "+rooms_Id+")");
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
        return ExecuteQueryItem.getItem();
    }

    public void updateObject(Item item){
        ExecuteQueryItem executeQueryItem =new ExecuteQueryItem("UPDATE objects SET name = '"+item.getName()+"', material = '"+item.getMaterial()+"', price = "+item.getPrice()+", rooms_Id = "+item.getRoomId()+" WHERE id = "+item.getId());
    }
}

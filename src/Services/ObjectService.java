package Services;
import Connections.Query.ExecuteQueryObject;
import Model.Object;

public class ObjectService {
    public static void addObject(Object object){
        String name=object.getName();
        String material=object.getMaterial();
        float price=object.getPrice();
        int rooms_Id=object.getId();
        ExecuteQueryObject executeQueryObject =new ExecuteQueryObject("INSERT INTO objects (name, material, price, rooms_Id) VALUES ('"+name+"', '"+material+"', "+price+", "+rooms_Id+")");
    }
    public static void deleteObject(int objectPosition){
        ExecuteQueryObject executeQueryObject =new ExecuteQueryObject("DELETE FROM objects WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM objects ORDER BY id LIMIT 1 OFFSET "+(objectPosition-1)+") AS subquery)");
    }
    public static void seeObject(){
        ExecuteQueryObject executeQueryObject =new ExecuteQueryObject("SELECT name FROM objects");
    }

    public static Object getObject(int objectPosition){
        ExecuteQueryObject executeQueryObject =new ExecuteQueryObject("SELECT * FROM objects ORDER BY id LIMIT 1 OFFSET "+(objectPosition-1));
        return ExecuteQueryObject.getObject();
    }

    public static void updateObject(Object object){
        ExecuteQueryObject executeQueryObject =new ExecuteQueryObject("UPDATE objects SET name = '"+object.getName()+"', material = '"+object.getMaterial()+"', price = "+object.getPrice()+", rooms_Id = "+object.getRoomId()+" WHERE id = "+object.getId());
    }
}

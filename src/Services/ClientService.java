package Services;
import Connections.Query.ExecuteQueryClient;
import Model.Client;

public class ClientService {
    public static void addClient(Client client){
        String name=client.getName();
        String mail=client.getMail();
        int notifications=0;
        if(client.isNotifications()==true){notifications=1;}
        int sesionId=client.getSesionId();
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("INSERT INTO clients (name, mail, notification, sessions_id) VALUES ('"+name+"', '"+mail+"', "+notifications+", "+sesionId+")");
    }
    public static void deleteClient(int clientPosition){
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("DELETE FROM clients WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM clients ORDER BY id LIMIT 1 OFFSET "+(clientPosition-1)+") AS subquery)");
    }
    public static void seeClients(){
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("SELECT name FROM clients");
    }

    public static Client getClient(int clientPosition){
        ExecuteQueryClient ExecuteQueryClient =new ExecuteQueryClient("SELECT * FROM clients ORDER BY id LIMIT 1 OFFSET "+(clientPosition-1));
        return ExecuteQueryClient.getClient();
    }

    public static void updateClient(Client client){
        int notifications=0;
        if(client.isNotifications()==true){notifications=1;}
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("UPDATE clients SET name = '"+client.getName()+"', mail = '"+client.getMail()+"', mail = "+notifications+" WHERE id = "+client.getId());
    }
}

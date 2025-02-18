package Services;
import Connections.Query.ExecuteQueryClient;
import Model.Client;

public class ClientService {
    public void addClient(Client client){
        int notifications=0;
        if(client.isNotifications()==true){notifications=1;}
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("INSERT INTO clients (name, mail, notification, sessions_id) VALUES ('"+client.getName()+"', '"+client.getMail()+"', "+notifications+", "+client.getSesionId()+")");
    }
    public void deleteClient(int clientPosition){
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("DELETE FROM clients WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM clients ORDER BY id LIMIT 1 OFFSET "+(clientPosition-1)+") AS subquery)");
    }
    public void seeClients(){
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("SELECT name FROM clients");
    }

    public Client getClient(int clientPosition){
        ExecuteQueryClient ExecuteQueryClient =new ExecuteQueryClient("SELECT * FROM clients ORDER BY id LIMIT 1 OFFSET "+(clientPosition-1));
        return ExecuteQueryClient.getClient();
    }

    public void updateClient(Client client){
        int notifications=0;
        if(client.isNotifications()==true){notifications=1;}
        ExecuteQueryClient executeQueryClient =new ExecuteQueryClient("UPDATE clients SET name = '"+client.getName()+"', mail = '"+client.getMail()+"', mail = "+notifications+" WHERE id = "+client.getId());
    }
}

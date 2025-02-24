package Services;
import Connections.Query.ExecuteQueryClient;
import Model.Client;

public class ClientService {
    ExecuteQueryClient executeQueryClient;
    public void addClient(Client client){
        int notifications=0;
        if(client.isNotifications()){notifications=1;}
        executeQueryClient = new ExecuteQueryClient("INSERT INTO clients (name, mail, notification, sessions_id) VALUES ('" + client.getName() + "', '" + client.getMail() + "', " + notifications + ", " + client.getSessionId() + ")");
    }
    public void deleteClient(int clientPosition) {
        ExecuteQueryClient deleteTickets = new ExecuteQueryClient("DELETE FROM tickets WHERE players_id = ( " +
                "SELECT id FROM (SELECT id FROM clients ORDER BY id LIMIT 1 OFFSET "+(clientPosition-1)+") AS subquery)");
        executeQueryClient = new ExecuteQueryClient("DELETE FROM clients WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM clients ORDER BY id LIMIT 1 OFFSET "+(clientPosition-1)+") AS subquery)");
    }
    public void seeClients(){
        executeQueryClient =new ExecuteQueryClient("SELECT name FROM clients");
    }

    public Client getClient(int clientPosition){
        executeQueryClient =new ExecuteQueryClient("SELECT * FROM clients ORDER BY id LIMIT 1 OFFSET "+(clientPosition-1));
        return executeQueryClient.getClient();
    }

    public void updateClient(Client client){
        int notifications=0;
        if(client.isNotifications()){notifications=1;}
        executeQueryClient = new ExecuteQueryClient("UPDATE clients SET name = '" + client.getName() + "', mail = '" + client.getMail() + "', notification = " + notifications + " WHERE id = " + client.getId());
    }
}

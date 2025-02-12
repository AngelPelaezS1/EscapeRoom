package Services;

import Connections.ExecuteQuery;
import Model.Client;
import Model.Room;

public class ClientService {
    public void addClient(Client client){
        int id=client.getId();
        String name=client.getName();
        String mail=client.getMail();
        boolean notifications=client.isNotifications();
        int sesionId=client.getSesionId();
        ExecuteQuery executeQuery=new ExecuteQuery("INSERT INTO clients (id, name, mail, notifications, sesionId) VALUES ('"+id+"', "+name+")");
    }
}

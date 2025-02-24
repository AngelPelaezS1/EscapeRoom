package Services;
import Connections.Query.ExecuteQueryTicket;
import Model.Ticket;

public class TicketService {
    ExecuteQueryTicket executeQueryTicket;
    public void addTicket(Ticket ticket){
        executeQueryTicket =new ExecuteQueryTicket("INSERT INTO tickets (price,players_id) VALUES ("+ticket.getPrice()+", "+ticket.getUserId()+")");
    }
    public void deleteTicket(int ticketPosition){
        executeQueryTicket =new ExecuteQueryTicket("DELETE FROM tickets WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM tickets ORDER BY id LIMIT 1 OFFSET "+(ticketPosition-1)+") AS subquery)");
    }
    public void seeTickets(){
        executeQueryTicket =new ExecuteQueryTicket("SELECT price FROM tickets");
    }

    public Ticket getTicket(int ticketPosition){
        executeQueryTicket =new ExecuteQueryTicket("SELECT * FROM tickets ORDER BY id LIMIT 1 OFFSET "+(ticketPosition-1));
        return executeQueryTicket.getTicket();
    }
    public void updateTicket(Ticket ticket){
        executeQueryTicket =new ExecuteQueryTicket("UPDATE tickets SET price = "+ticket.getPrice()+", players_id = "+ticket.getUserId()+" WHERE id = "+ticket.getId());
    }
}

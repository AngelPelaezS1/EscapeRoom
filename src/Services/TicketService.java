package Services;
import Connections.Query.ExecuteQueryTicket;
import Model.Ticket;

public class TicketService {
    public void addTicket(Ticket ticket){
        double price=ticket.getPrice();
        int players_id=ticket.getUserId();
        ExecuteQueryTicket executeQueryTicket =new ExecuteQueryTicket("INSERT INTO tickets (price, players_id) VALUES ("+price+", "+players_id+")");
    }
    public void deleteTicket(int ticketPosition){
        ExecuteQueryTicket executeQueryTicket =new ExecuteQueryTicket("DELETE FROM tickets WHERE id = ( " +
                "SELECT id FROM (SELECT id FROM tickets ORDER BY id LIMIT 1 OFFSET "+(ticketPosition-1)+") AS subquery)");
    }
    public void seeTickets(){
        ExecuteQueryTicket executeQueryTicket =new ExecuteQueryTicket("SELECT name FROM tickets");
    }

    public Ticket getTicket(int ticketPosition){
        ExecuteQueryTicket executeQueryTicket =new ExecuteQueryTicket("SELECT * FROM tickets ORDER BY id LIMIT 1 OFFSET "+(ticketPosition-1));
        return executeQueryTicket.getTicket();
    }

    public void updateTicket(Ticket ticket){
        ExecuteQueryTicket executeQueryTicket =new ExecuteQueryTicket("UPDATE tickets SET price = "+ticket.getPrice()+", players_id = "+ticket.getUserId()+" WHERE id = "+ticket.getId());
    }
}

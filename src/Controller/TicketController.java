package Controller;

import Model.Client;
import Model.Session;
import Model.Ticket;
import Services.ClientService;
import Services.RoomService;
import Services.SessionService;
import Services.TicketService;

import java.util.Scanner;

import static Controller.ClientController.showClient;
import static Controller.RoomController.showRooms;
import static Controller.SessionController.showSessions;

public class TicketController {
    public void createTicketClient(){
        Scanner sc= new Scanner(System.in);
        RoomService roomService=new RoomService();
        ClientService clientService=new ClientService();
        SessionService sessionService= new SessionService();
        TicketService ticketService= new TicketService();
        int idUser=0;
        int choose;
        int sessionId=0;
        float price= 24.95f;

        System.out.println("Lista de salas:");
        showRooms();
        System.out.println("Selecciona la posicion de la room a la que quieres añadir un ticket:");
        choose=sc.nextInt();
        sc.nextLine();
        System.out.println("Lista de sesiones:");
        showSessions();
        System.out.println("Selecciona la posicion de la sesion para la que quieres el ticket");
        choose=sc.nextInt();
        sc.nextLine();
        Session session;
        session =sessionService.getSession(choose);
        sessionId=session.getId();
        System.out.println("Lista de clientes:");
        showClient();
        System.out.println("Selecciona la posicion del cliente al que quieres añadir un ticket:");
        choose=sc.nextInt();
        sc.nextLine();
        Client client=clientService.getClient(choose);
        client.setSessionId(sessionId);
        idUser=client.getId();
        Ticket ticket= new Ticket(price,idUser);
        ticketService.addTicket(ticket);
        System.out.println("Se le ha asignado ticket");
    }
    /*public void createTicket(){
        Scanner sc= new Scanner(System.in);
        RoomService roomService= new RoomService();
        SessionService sessionService= new SessionService();
        TicketService ticketService= new TicketService();
        int idUser;
        int sessionId=0;
        int choose;
        float price= 24.95f;

        System.out.println("Lista de salas:");
        showRooms();
        sc.nextLine();
        System.out.println("Selecciona la posicion de la sala a la que quieres añadir un ticket:");
        choose=sc.nextInt();
        sc.nextLine();
        Room room=roomService.getRoom(choose);
        System.out.println("Lista de sesiones:");
        showSessions();
        sc.nextLine();
        System.out.println("Selecciona la posicion de la sesion para la que quieres el ticket");
        choose=sc.nextInt();
        sc.nextLine();
        Session session= sessionService.getSession(choose);
        sessionId=session.getId();
        Client client =createClient(sessionId);
        idUser=client.getId();
        System.out.println( idUser);
        Ticket ticket= new Ticket(price,idUser);
        ticketService.addTicket(ticket);
        System.out.println("Ticket creado con exito.");
    }*/

    public void showTicket(){
        ClientService clientService = new ClientService();
        SessionService sessionService= new SessionService();
        TicketService ticketService = new TicketService();
        Scanner sc= new Scanner(System.in);
        int idUser=0;
        int chooseTicket;
        System.out.println("lista de clientes:");
        showClient();
        System.out.println("Selecciona la posicion del cliente al que quieres mostrar los  tickets:");
        chooseTicket=sc.nextInt();
        sc.nextLine();
        Client client=clientService.getClient(chooseTicket);
        System.out.println("Lista de tickets del cliente " +client.getName()+ " :");
        ticketService.seeTickets();
    }
    public void deleteTicket(){
        Scanner sc=new Scanner(System.in);
        TicketService ticketService = new TicketService();
        SessionService sessionService= new SessionService();
        int chooseTicket;
        System.out.println("Lista de tickets:");
        showTicket();
        System.out.println("Selecciona la posicion del ticket que quieres eliminar :");
        chooseTicket= sc.nextInt();
        sc.nextLine();
        ticketService.deleteTicket(chooseTicket);
        System.out.println("Ticket eliminado con exito.");
    }
}

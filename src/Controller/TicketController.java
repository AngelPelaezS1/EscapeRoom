package Controller;

import Model.Ticket;

import java.util.Scanner;

import static Controller.ClientController.createClient;
import static Controller.ClientController.showClient;

public class TicketController {
    public static void createTicketClient(){
        Scanner sc= new Scanner(System.in);
        int idUser=0;
        float price= 24.95f;
        showClient();
        System.out.println("Selecciona la posicion del cliente al que quieres añadir un tiket:");
        // metodo que te devuelba el cliente por posicion;
        //idUser=user.getID();
        Ticket ticket= new Ticket(idUser,price);
        //metodo servicio para asignar tiket a user
        System.out.println("Se le ha asignado ticket");
    }
    public static void createTicket(){
        int idUser;
        float price= 24.95f;
        idUser=createClient().getId();
        Ticket ticket= new Ticket(idUser,price);
        //metodo servicio para asignar tiket a user;
    }
    PUBLI

}

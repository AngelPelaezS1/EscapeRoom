package Controller;

import Menus.MenusItems.RoomMenu;
import Model.Client;
import Model.Room;
import Model.Ticket;

import java.util.Scanner;

import Controller.ClientController;
import Controller.ClientController;
import Controller.RoomController;
import Services.ClientService;
import Services.RoomService;

public class TicketController {
    public void createTicketClient(){
        Scanner sc= new Scanner(System.in);
        int idUser=0;
        int choose;
        int sesionId=0;
        float price= 24.95f;

        System.out.println("Selecciona la posicion de la room a la que quieres añadir un ticket:");
        RoomMenu roomMenu = new RoomMenu();
        showRooms();
        choose=sc.nextInt();
        sc.nextLine();
        Room room=getRoom(choose);
        System.out.println("Selecciona la posicion de la sesion para la que quieres el ticket");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo que devuelva la sesion por posicion;
        //sesionId=sesion.getID();
        System.out.println("Selecciona la posicion del cliente al que quieres añadir un ticket:");
        showClient();
        choose=sc.nextInt();
        sc.nextLine();
        Client client=getClient(choose);

        client.setSesionId(sesionId);
        idUser=client.getId();
        Ticket ticket= new Ticket(idUser,price);
        //metodo servicio para asignar tiket a user
        System.out.println("Se le ha asignado ticket");
    }
    public void createTicket(){
        Scanner sc= new Scanner(System.in);
        int idUser;
        int sesionId=0;
        int choose;
        float price= 24.95f;

        System.out.println("Selecciona la posicion de la room a la que quieres añadir un ticket:");
        showRooms();
        choose=sc.nextInt();
        sc.nextLine();
        Room room=getRoom(choose);
        System.out.println("Selecciona la posicion de la sesion para la que quieres el ticket");
        choose=sc.nextInt();
        sc.nextLine();
        //sesionID=sesion.getID();

        idUser=createClient(sesionId).getId();
        Ticket ticket= new Ticket(idUser,price);
        //metodo servicio para asignar tiket a user;
    }
    public void showTicket(){
        Scanner sc= new Scanner(System.in);
        int idUser=0;
        int choose;
        showClient();
        System.out.println("Selecciona la posicion del cliente al que quieres mostrar los  tikets:");
        choose=sc.nextInt();
        sc.nextLine();
        Client client=getClient(choose);
        //print tiket por posicion ;
    }
    public void deleteTicket(){
        Scanner sc=new Scanner(System.in);
        int choose;
        showTicket();
        System.out.println("Selecciona la posicion del tiket que quieres eliminar :");
        choose= sc.nextInt();
        sc.nextLine();
        //eliminar tiket por posicion;
    }


}

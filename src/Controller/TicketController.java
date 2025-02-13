package Controller;

import Model.Ticket;

import java.util.Scanner;

import static Controller.ClientController.createClient;
import static Controller.ClientController.showClient;
import static Controller.RoomController.showRooms;

public class TicketController {
    public static void createTicketClient(){
        Scanner sc= new Scanner(System.in);
        int idUser=0;
        int choose;
        int sesionId;
        float price= 24.95f;

        System.out.println("Selecciona la posicion de la room a la que quieres añadir un ticket:");
        showRooms();
        choose=sc.nextInt();
        sc.nextLine();
        //metodo que devuelva la room por posicion ;
        System.out.println("Selecciona la posicion de la sesion para la que quieres el ticket");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo que devuelva la sesion por posicion;
        //sesionID=sesion.getID();
        System.out.println("Selecciona la posicion del cliente al que quieres añadir un ticket:");
        showClient();
        choose=sc.nextInt();
        sc.nextLine();
        // metodo que te devuelba el cliente por posicion;
        //user.setSesionId(sesionID);
        //idUser=user.getID();
        Ticket ticket= new Ticket(idUser,price);
        //metodo servicio para asignar tiket a user
        System.out.println("Se le ha asignado ticket");
    }
    public static void createTicket(){
        Scanner sc= new Scanner(System.in);
        int idUser;
        int sesionId=0;
        int choose;
        float price= 24.95f;

        System.out.println("Selecciona la posicion de la room a la que quieres añadir un ticket:");
        showRooms();
        choose=sc.nextInt();
        sc.nextLine();
        //metodo que devuelva la room por posicion ;
        System.out.println("Selecciona la posicion de la sesion para la que quieres el ticket");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo que devuelva la sesion por posicion;
        //sesionID=sesion.getID();

        idUser=createClient(sesionId).getId();
        Ticket ticket= new Ticket(idUser,price);
        //metodo servicio para asignar tiket a user;
    }
    public static void showTicket(){
        Scanner sc= new Scanner(System.in);
        int idUser=0;
        showClient();
        System.out.println("Selecciona la posicion del cliente al que quieres mostrar los  tikets:");
        // metodo servicio que te devuelba los tikets de cliente  por posicion;
    }
    public static void deleteTicket(){
        Scanner sc=new Scanner(System.in);
        int choose;
        showTicket();
        System.out.println("Selecciona la posicion del tiket que quieres eliminar :");
        // metodo  servicio que  elimina los tikets por posicion
    }


}

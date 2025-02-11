package Controller;

import Model.Object;

import java.util.Scanner;

import static Controller.RoomController.showRooms;

public class ObjectController {

    public static void createObject(){
        Scanner sc= new Scanner(System.in);
        int choose;
        int idRoom=0;
        String name;
        String material;
        float price;
        showRooms();
        System.out.println("Selecciona la posicion de la habitacion a la que quieres añadir un objeto");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo servicio que devuelva la room por posicion
        // room.getId(idRoom);
        System.out.println("Cual es el nombre del objeto?");
        name=sc.nextLine();
        System.out.println("Cual es el material del objeto?");
        material=sc.nextLine();
        System.out.println("Cual es el precio del objeto?");
        price=sc.nextFloat();
        sc.nextLine();
        Object object =new Object(name, material,price,idRoom);
        // metodo servicio crear objeto
    }
    public static void showObject(){
        Scanner sc= new Scanner(System.in);
        int choose;
        showRooms();
        System.out.println("Selecciona la posicion de la habitacion a la que quieres mostrar  objetos");
        choose=sc.nextInt();
        sc.nextLine();
        //metodo servicio que devuelva la room por posicion
        //metodo servicio que devuelva los objetos de la room;
    }
}

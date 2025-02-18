package Controller;

import Model.Item;
import Model.Room;
import Services.RoomService;

import java.util.Scanner;

import static Controller.RoomController.showRooms;

public class ItemController {

    public void createObject(){
        Scanner sc= new Scanner(System.in);
        RoomService service= new RoomService();
        int choose;
        int idRoom=0;
        String name;
        String material;
        float price;
        showRooms();
        System.out.println("Selecciona la posicion de la habitacion a la que quieres añadir un objeto");
        choose=sc.nextInt();
        sc.nextLine();
        Room room =service.getRoom(choose);
        idRoom=room.getId();
        System.out.println("Cual es el nombre del objeto?");
        name=sc.nextLine();
        System.out.println("Cual es el material del objeto?");
        material=sc.nextLine();
        System.out.println("Cual es el precio del objeto?");
        price=sc.nextFloat();
        sc.nextLine();
        Item item =new Item(name, material,price,idRoom);
        // metodo servicio crear objeto
    }
    public void showObject(){
        Scanner sc= new Scanner(System.in);
        RoomService service= new RoomService();
        int choose;
        int idRoom;
        showRooms();
        System.out.println("Selecciona la posicion de la habitacion de que quieres mostrar  objetos");
        choose=sc.nextInt();
        sc.nextLine();
        Room room =service.getRoom(choose);
        idRoom=room.getId();
        //metodo servicio que devuelva los objetos de la room;
    }
    public void removeObject(){
        Scanner sc= new Scanner(System.in);
        int choose;
        showObject();
        System.out.println("Selecciona la posicion del objeto que quieres eliminar)");
        choose= sc.nextInt();
        sc.nextLine();
        // metodo servivcio que devuelva objeto por posicion;
        //metodo servicio para eliminar por posicion;
    }
    public void modyfyObject(){
        Scanner sc= new Scanner(System.in);
        int choose;
        int idRoom;
        String name;
        String material;
        float price;

        showObject();
        System.out.println("Selecciona la posicion del objeto que quieres modificar");
        choose=sc.nextInt();
        sc.nextLine();
        // metodo servivcio que devuelva objeto por posicion;
        // idRoom=object.getRoomId;
        System.out.println("Que quieres modificar:");
        System.out.println("1.-Nombre");
        System.out.println("2.-Material");
        System.out.println("3.-Price");
        choose= sc.nextInt();
        sc.nextLine();

        switch (choose){
            case 1:
                System.out.println("Que nombre quieres poner?");
                name=sc.nextLine();
                //object.setName(name);
                break;
            case 2:
                System.out.println("De que material esta hecho?");
                material=sc.nextLine();
                //object.setMaterial(material);
                break;
            case 3:
                System.out.println("Que precio tiene ? ");
                price=sc.nextFloat();
                sc.nextLine();
                //object.setPrice(price);
                break;
            default:
                System.out.println("Introduce un numero del 1 al 3");
                //metodo servicio para hacer el update del object;
        }

    }

}

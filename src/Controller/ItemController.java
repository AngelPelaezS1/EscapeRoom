package Controller;

import Model.Item;
import Model.Room;
import Services.ItemService;
import Services.RoomService;

import java.util.Scanner;

import static Controller.RoomController.showRooms;

public class ItemController {

    public void createItem() {
        Scanner sc = new Scanner(System.in);
        RoomService roomService = new RoomService();
        ItemService itemService = new ItemService();
        int choose;
        int idRoom = 0;
        String name;
        String material;
        float price;
        showRooms();
        System.out.println("Selecciona la posicion de la habitacion a la que quieres añadir un objeto");
        choose = sc.nextInt();
        sc.nextLine();
        Room room = roomService.getRoom(choose);
        idRoom = room.getId();
        System.out.println("Cual es el nombre del objeto?");
        name = sc.nextLine();
        System.out.println("Cual es el material del objeto?");
        material = sc.nextLine();
        System.out.println("Cual es el precio del objeto?");
        price = sc.nextFloat();
        sc.nextLine();
        Item item = new Item(name, material, price, idRoom);
        itemService.addItem(item);
    }

    public void showItem() {
        Scanner sc = new Scanner(System.in);
        RoomService roomService = new RoomService();
        ItemService itemService = new ItemService();
        int choose;
        int idRoom;
        showRooms();
        System.out.println("Selecciona la posicion de la habitacion de que quieres mostrar  objetos");
        choose = sc.nextInt();
        sc.nextLine();
        Room room = roomService.getRoom(choose);
        idRoom = room.getId();
        itemService.seeItem();
    }

    public void removeItem() {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();
        int choose;
        showItem();
        System.out.println("Selecciona la posicion del objeto que quieres eliminar)");
        choose = sc.nextInt();
        sc.nextLine();
        service.deleteItem(choose);
    }

    public void modyfyItem() {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();
        int choose;
        int idRoom;
        String name;
        String material;
        float price;

        showItem();
        System.out.println("Selecciona la posicion del objeto que quieres modificar");
        choose = sc.nextInt();
        sc.nextLine();
        Item item = service.getItem(choose);
        idRoom = item.getRoomId();
        System.out.println("Que quieres modificar:");
        System.out.println("1.-Nombre");
        System.out.println("2.-Material");
        System.out.println("3.-Price");
        choose = sc.nextInt();
        sc.nextLine();

        switch (choose) {
            case 1:
                System.out.println("Que nombre quieres poner?");
                name = sc.nextLine();
                item.setName(name);
                service.updateItem(item);
                break;
            case 2:
                System.out.println("De que material esta hecho?");
                material = sc.nextLine();
                item.setMaterial(material);
                service.updateItem(item);
                break;
            case 3:
                System.out.println("Que precio tiene ? ");
                price = sc.nextFloat();
                sc.nextLine();
                item.setPrice(price);
                service.updateItem(item);
                break;
            default:
                System.out.println("Introduce un numero del 1 al 3");
        }
    }
}

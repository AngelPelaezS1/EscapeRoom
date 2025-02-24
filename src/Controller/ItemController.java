package Controller;

import Model.Item;
import Model.Room;
import Services.ItemService;
import Services.RoomService;

import java.util.Scanner;

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
        System.out.println(" ");
        System.out.println("Lista de salas:");
        roomService.seeRooms();
        System.out.println(" ");
        System.out.println("Selecciona la posicion de la habitacion a la que quieres añadir un objeto.");
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
        System.out.println("Objeto creado con exito.");
    }

    public void showItem() {
        Scanner sc = new Scanner(System.in);
        RoomService roomService = new RoomService();
        ItemService itemService = new ItemService();
        int choose;
        int idRoom;

        System.out.println(" ");
        System.out.println("Lista de salas:");
        roomService.seeRooms();
        System.out.println(" ");
        System.out.println("Selecciona la posicion de la sala de que quieres mostrar  objetos.");
        choose = sc.nextInt();
        sc.nextLine();
        Room room = roomService.getRoom(choose);
        idRoom = room.getId();
        System.out.println("Lista de objetos de la sala " +room.getName()+ ":");
        itemService.seeItem();
    }

    public void removeItem() {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();
        int choose;

        System.out.println(" ");
        System.out.println("Lista de objetos:");
        service.seeItem();
        System.out.println(" ");
        System.out.println("Selecciona la posicion del objeto que quieres eliminar.");
        choose = sc.nextInt();
        sc.nextLine();
        service.deleteItem(choose);
        System.out.println("Objeto eliminado con exito.");
    }

    public void modyfyItem() {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();
        int choose;
        int idRoom;
        String name;
        String material;
        float price;
        System.out.println(" ");
        System.out.println("Lista de objetos:");
        service.seeItem();
        System.out.println(" ");
        System.out.println("Selecciona la posicion del objeto que quieres modificar.");
        choose = sc.nextInt();
        sc.nextLine();
        Item item = service.getItem(choose);
        idRoom = item.getRoomId();
        System.out.println(" ");
        System.out.println("Que quieres modificar:");
        System.out.println("1.-Nombre.");
        System.out.println("2.-Material.");
        System.out.println("3.-Price.");
        choose = sc.nextInt();
        sc.nextLine();

        switch (choose) {
            case 1:
                System.out.println("Que nombre quieres poner?");
                name = sc.nextLine();
                item.setName(name);
                service.updateItem(item);
                System.out.println("Nombre actualizado.");
                break;
            case 2:
                System.out.println("De que material esta hecho?");
                material = sc.nextLine();
                item.setMaterial(material);
                service.updateItem(item);
                System.out.println("Material actualizado.");
                break;
            case 3:
                System.out.println("Que precio quieres poner?");
                price = sc.nextFloat();
                sc.nextLine();
                item.setPrice(price);
                service.updateItem(item);
                System.out.println("Precio actualizado.");
                break;
            default:
                System.out.println("Introduce un numero del 1 al 3.");
        }
    }

    public void totalValue(){
        ItemService service = new ItemService();
        System.out.println(" ");
        service.totalValueObjects();
    }

}

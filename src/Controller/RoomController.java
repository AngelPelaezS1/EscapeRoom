package Controller;

import Model.Room;
import Services.RoomService;

import java.util.Scanner;

public class RoomController {
    static Scanner sc = new Scanner(System.in);


    public static void createRoom(){
        RoomService service= new RoomService();
        System.out.println(" ");
        System.out.println("Introduce el nombre de la habitacion.");
        String name = sc.nextLine();
        System.out.println("Introduce la dificultad (1-10).");
        int difficulty = sc.nextInt();
        sc.nextLine();

        while(difficulty <= 0 || difficulty > 10){
            System.out.println("Error, introduce un numero del 1 al 10.");
            difficulty = sc.nextInt();
        }
        System.out.println("Sala " +name+ ", creada con exito.");
        Room room = new Room(name, difficulty);
        service.addRoom(room);
    }

    public static void showRooms(){
        System.out.println(" ");
        System.out.println("Lista de salas:");
        RoomService service = new RoomService();
        service.seeRooms();
    }


    public static void removeRoom(){
        RoomService service= new RoomService();
        System.out.println(" ");
        System.out.println("Lista de salas:");
        service.seeRooms();
        System.out.println(" ");
        System.out.println("Introduce la posicion de la sala a eliminar.");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido.");
            index = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Sala eliminada con exito.");
        service.deleteRoom(index);
    }


    public static void modifyRoom(){
        RoomService service= new RoomService();
        System.out.println(" ");
        showRooms();
        System.out.println(" ");
        System.out.println("Introduce la posicion de la sala a modificar.");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido.");
            index = sc.nextInt();
            sc.nextLine();
        }

        Room room = service.getRoom(index);

            System.out.println("Elige una opción:");
            System.out.println("1.Nombre.");
            System.out.println("2.Dificultad.");
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose){
                case 1:
                    System.out.println("Introduce el nuevo nombre:");
                    String newName = sc.nextLine();
                    room.setName(newName);
                    service.updateRoom(room);
                    System.out.println("Nombre actualizado.");
                    break;
                case 2:
                    System.out.println("Introduce la nueva dificultad:");
                    int newDifficulty = sc.nextInt();
                    sc.nextLine();
                    room.setDifficulty(newDifficulty);
                    service.updateRoom(room);
                    System.out.println("Dificultad actualizada.");
                    break;
                default:
                    System.out.println("Introduce un numero del 1 al 2.");
            }
    }
}

package Controller;

import Model.Room;

import java.util.Scanner;

import static Services.RoomService.*;

public class RoomController {
    static Scanner sc = new Scanner(System.in);

    public static void createRoom(){
        System.out.println("Introduce el nombre de la habitacion");
        String name = sc.nextLine();
        System.out.println("Introduce la dificultad (1-10)");
        int difficulty = sc.nextInt();
        sc.nextLine();

        while(difficulty <= 0 || difficulty > 10){
            System.out.println("Error, introduce un numero del 1 al 10");
            difficulty = sc.nextInt();
        }
        System.out.println("Sala " +name+ ", creada con exito.");
        Room room = new Room(name, difficulty);
        addRoom(room);
    }

    public static void showRooms(){
        System.out.println("Lista de salas");
        seeRooms();
    }

    public static void removeRoom(){
        showRooms();
        System.out.println("Introduce la posicion de la sala a eliminar");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido");
            index = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Sala eliminada con exito");
        deleteRoom(index);
    }

    public static void modifyRoom(){
        showRooms();
        System.out.println("Introduce la posicion de la sala a modificar");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido");
            index = sc.nextInt();
            sc.nextLine();
        }

        Room room = getRoom(index);

            System.out.println("Elige una opción: 1-Nombre, 2-Dificultad");
            int choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1:
                    System.out.println("Introduce el nuevo nombre:");
                    String newName = sc.nextLine();
                    room.setName(newName);
                    updateRoom(room);
                    System.out.println("Nombre actualizado");
                    break;
                case 2:
                    System.out.println("Introduce la nueva dificultad:");
                    int newDifficulty = sc.nextInt();
                    sc.nextLine();
                    room.setDifficulty(newDifficulty);
                    updateRoom(room);
                    System.out.println("Dificultad actualizada");
                    break;
                default:
                    System.out.println("Introduce un numero del 1 al 2");
            }
    }
}

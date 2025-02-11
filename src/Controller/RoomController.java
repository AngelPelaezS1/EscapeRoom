package Controller;

import Model.Room;

import java.util.Scanner;

public class RoomController {
    Scanner sc = new Scanner(System.in);

    public void createRoom(){
        System.out.println("Introduce el nombre de la habitacion");
        String name = sc.nextLine();
        System.out.println("Introduce la dificultad (1-10)");
        int difficulty = sc.nextInt();
        sc.nextLine();

        while(difficulty <= 0 || difficulty > 10){
            System.out.println("Error, introduce un numero del 1 al 10");
            difficulty = sc.nextInt();
        }
        System.out.println("Dificultad de la sala:" +difficulty);
        Room room = new Room(name, difficulty);
        //Metodo para añadir la room.
    }

    public void showRooms(){
        //Metodo para mostrar las rooms
    }

    public void removeRoom(){
        showRooms();
        System.out.println("Introduce la posicion de la sala a eliminar");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido");
            index = sc.nextInt();
            sc.nextLine();
            //Metodo para eliminar la room.
        }
    }

    public void modifyRoom(){
        showRooms();
        System.out.println("Introduce la posicion de la sala a modificar");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido");
            index = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Elige una opcion : 1-Nombre, 2-Dificultad");
        int choose = sc.nextInt();
        sc.nextLine();
        switch(choose){
            case 1:
                System.out.println("Inrtroduce el nuevo nombre");
                String newName = sc.nextLine();
                //room.setName;
                //metodo update name
                break;
            case 2:
                System.out.println("Introduce la nueva dificultad");
                int newDifficulty = sc.nextInt();
                //room.setDificulty;
                //metodo update difficulty
                break;
        }
    }
}

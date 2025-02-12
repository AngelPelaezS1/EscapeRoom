package Controller;

import Model.Track;

import java.util.Scanner;

import static Controller.RoomController.showRooms;

public class TrackController {
    static Scanner sc = new Scanner(System.in);

    public static void createTrack(){
        int idRooms = 0;
        showRooms();
        System.out.println("Introduce la posicion de la room a la quieres añadir la pista");
        int indice = sc.nextInt();
        sc.nextLine();

        //metodo para que devuelva room
        //room.getId(idRoom);

        System.out.println("Introduce el nombre de la pista");
        String name = sc.nextLine();
        System.out.println("Introduce el tema de la pista");
        String topics = sc.nextLine();
        System.out.println("Haz una breve descripcion");
        String details = sc.nextLine();
        System.out.println("Introduce a que room pertenece la pista");
        int roomId = sc.nextInt();
        sc.nextLine();
        Track track = new Track(name, topics,details,roomId);

        //metodo para añadir una nueva track
    }

    public static void showTracks(){
        //metodo para mostrar las tracks

    }

    public static void removeTrack(){
        //metodo para mostrar las tracks
        System.out.println("Introduce la posicion de la pista a eliminar");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero correcto");
            index = sc.nextInt();
            sc.nextLine();
        }
        //metodo para eliminar track
    }

    public static void modifyTrack(){
        //metodo para mostrar los tracks
        System.out.println("Introduce la posicion de la pista a modificar");
        int index = sc.nextInt();
        sc.nextLine();
        
        while(index < 0){
            System.out.println("Error, introduce un numero correcto");
            index = sc.nextInt();
            sc.nextLine();
        }
        //metodo para coger la track de la lista(por indice);

        System.out.println("Elige una opción: 1-Nombre, 2-Tema, 3-Descripcion");
        int choose = sc.nextInt();
        sc.nextLine();

        switch(choose){
            case 1:
                System.out.println("Introduce el nuevo nombre");
                String newName = sc.nextLine();
                //setname;
                break;
            case 2:
                System.out.println("Introduce el nuevo tema");
                String newTopic = sc.nextLine();
                //setTopics
                break;
            case 3:
                System.out.println("Introduce la nueva descripcion");
                String newDetails = sc.nextLine();
                //setDetails
                break;
        }
        //metodo para modificar
    }
}

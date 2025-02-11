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
        Track track = new Track(name, topics,details);

        //metodo para añadir una nueva track
    }

    public static void showTracks(){
        //metodo para mostrar las tracks

    }

    public static void removeTrack(){

    }


}

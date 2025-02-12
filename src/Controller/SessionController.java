package Controller;

import java.util.Scanner;
import static Controller.RoomController.showRooms;

public class SessionController {
    static Scanner sc = new Scanner(System.in);

    public static void createSesion(){
        int idRooms = 0;
        System.out.println("Lista de salas:");
        showRooms();
        System.out.println("Introduce la posicion de la sala de esta sesion");
        int indice = sc.nextInt();
        sc.nextLine();
        //metodo para que devuelva room
        //room.getId(idRoom);
        System.out.println("Introduce fecha y hora(yyyy-MM-dd HH:mm");
        String dateTimeInput = sc.nextLine();


    }
}

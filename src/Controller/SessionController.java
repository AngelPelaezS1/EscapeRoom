package Controller;

import Model.Session;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import static Controller.RoomController.showRooms;


public class SessionController {
    static Scanner sc = new Scanner(System.in);

    public static void createSesion(){
        int idRooms = 0;
        boolean finished = true;
        boolean exit = true;

        System.out.println("Lista de salas:");
        showRooms();

        System.out.println("Introduce la posicion de la sala de esta sesion");
        int indice = sc.nextInt();
        sc.nextLine();
        //metodo para que devuelva room
        //room.getId(idRoom);
        System.out.println("Introduce fecha y hora(yyyy-MM-dd HH:mm");
        String dateTimeInput = sc.nextLine();
        LocalDateTime playedTime = null;
        try {
            playedTime = LocalDateTime.parse(dateTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            System.out.println("Formato incorrecto, usa yyyy-MM-dd HH:mm.");
            return;
        }
        do{
            System.out.println("Has acabado la partida? (Si/No)");
            String choose = sc.nextLine();
            String lowerCase = choose.toLowerCase();
            char election = lowerCase.charAt(1);

            if(election == 's'){
                finished = true;
                exit = false;
            }else if(election == 'n'){
                finished = false;
                exit = false;
            }else{
                System.out.println("Error, escribe si o no");
            }
        }while(exit);

        System.out.println("Introduce la sala a la que pertenece esta sesion");
        int roomId = sc.nextInt();
        sc.nextLine();

        Session session = new Session(playedTime, finished, roomId);
        //metodo para añadir session
    }


}

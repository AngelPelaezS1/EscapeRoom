package Controller;


import Model.Room;
import Model.Session;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Controller.RoomController.showRooms;
import static Services.RoomService.getRoom;
import static Services.SessionService.addSession;

public class SessionController {
    static Scanner sc = new Scanner(System.in);

    public static void createSesion() {
        int idRooms = 0;

        System.out.println("Lista de salas:");
        showRooms();

        System.out.println("Introduce la posicion de la sala de esta sesion.");
        int index = sc.nextInt();
        sc.nextLine();
        Room room=getRoom(index);
        idRooms=room.getId();
        System.out.println("Introduce fecha y hora(yyyy-MM-dd HH:mm.");
        String dateTimeInput = sc.nextLine();
        LocalDateTime playedTime = null;
        try {
            playedTime = LocalDateTime.parse(dateTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            System.out.println("Formato incorrecto, usa yyyy-MM-dd HH:mm.");
            return;
        }
        sc.nextLine();
        Session session = new Session(playedTime,idRooms);
        addSession(session);

    }

    public static void removeSession() {
        System.out.println("Lista de sesiones:");
        showSessions();
        System.out.println("Introduce la posicion de la sesion a eliminar.");
        int index = sc.nextInt();
        sc.nextLine();

        while (index < 0) {
            System.out.println("Error, introduce un numero valido.");
            index = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Sesion eliminada con exito.");
    }

    public static void showSessions() {
        System.out.println("Lista de sesiones:");
        //metodo para listar sesiones

    }

    public static void markSessionAsPassed(){
        boolean finished = true;
        boolean exit = true;
        showSessions();
        System.out.println("Introduce la posicion de la sesion que quieres marcar como pasada.");
        int index = sc.nextInt();
        sc.nextLine();

        while(index < 0){
            System.out.println("Error, introduce un numero valido.");
            index = sc.nextInt();
            sc.nextLine();
        }

        //Session session = getSession(index);

            /*while(session.isFinished){
             System.out.println("Esta sesion ya esta marcada");
             }
        */

        do{
            System.out.println("Has acabado la partida? (Si/No).");
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
                System.out.println("Error, escribe si o no.");
            }
        }while(exit);

        if (finished){
           /*session.setFinished(true);
           updateSession(session);
           System.out.println("Sesión marcada como pasada exitosamente.");*/
        }else{
            System.out.println("La sesión no ha sido marcada como pasada.");
        }
    }
}


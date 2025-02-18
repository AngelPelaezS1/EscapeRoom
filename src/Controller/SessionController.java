package Controller;

import Model.Room;
import Model.Session;
import Services.RoomService;
import Services.SessionService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static Controller.RoomController.showRooms;

public class SessionController {
    static Scanner sc = new Scanner(System.in);


    public static void createSesion() {
        RoomService service= new RoomService();
        SessionService sessionService= new SessionService();

        int idRooms = 0;

        System.out.println("Lista de salas:");
        showRooms();

        System.out.println("Introduce la posicion de la sala de esta sesion.");
        int index = sc.nextInt();
        sc.nextLine();

        Room room = service.getRoom(index);
        idRooms = room.getId();

        System.out.println("Introduce fecha y hora (yyyy-MM-dd HH:mm.)");
        String dateTimeInput = sc.nextLine();
        LocalDateTime playedTime = null;
        try {
            playedTime = LocalDateTime.parse(dateTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            System.out.println("Formato incorrecto, usa (yyyy-MM-dd HH:mm.)");
            return;
        }
        sc.nextLine();

        Session session = new Session(playedTime, idRooms);
        sessionService.addSession(session);

    }


    public static void removeSession() {
        SessionService service= new SessionService();

        showSessions();
        System.out.println("Introduce la posicion de la sesion a eliminar.");
        int index = sc.nextInt();
        sc.nextLine();

        while (index < 0) {
            System.out.println("Error, introduce un numero valido.");
            index = sc.nextInt();
            sc.nextLine();
        }

        service.deleteSession(index);
      
        System.out.println("Sesion eliminada con exito.");
    }

    public static void showSessions() {
        SessionService service= new SessionService();
        service.seeSessions();
    }

    public static void markSessionAsPassed() {
        SessionService service= new SessionService();

        boolean finished = true;
        boolean exit = true;
        showSessions();
        System.out.println("Introduce la posicion de la sesion que quieres marcar como pasada.");
        int index = sc.nextInt();
        sc.nextLine();

        while (index < 0) {
            System.out.println("Error, introduce un numero valido.");
            index = sc.nextInt();
            sc.nextLine();
        }

        Session session = service.getSession(index);

        if (session.isFinished()) {
            System.out.println("Esta sesión ya está marcada como pasada.");
            return;
        }

            do {
                System.out.println("Marca si se ha pasado la partida. (Si/No).");
                String choose = sc.nextLine().trim().toLowerCase();

                if (choose.equals("si")) {
                    finished = true;
                    exit = false;
                } else if (choose.equals("no")) {
                    finished = false;
                    exit = false;
                } else {
                    System.out.println("Error, escribe 'si' o 'no'.");
                }
            } while (exit);

            if (finished) {
                session.setFinished(true);
                service.updateSession(session);
                System.out.println("Sesión marcada como pasada.");
            } else {
                System.out.println("La sesión no ha sido marcada como pasada.");
            }
        }
    }
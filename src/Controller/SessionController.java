package Controller;

import Model.Room;
import Model.Session;
import Services.RoomService;
import Services.SessionService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SessionController {
    static Scanner sc = new Scanner(System.in);

    public static void createSesion() {
        RoomService roomService = new RoomService();
        SessionService sessionService = new SessionService();

        int idRooms = 0;
        System.out.println(" ");
        System.out.println("Lista de salas:");
        roomService.seeRooms();
        System.out.println(" ");
        System.out.println("Introduce la posicion de la sala de esta sesion.");
        int index = sc.nextInt();
        sc.nextLine();

        Room room = roomService.getRoom(index);
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

        Session session = new Session(playedTime, idRooms);
        sessionService.addSession(session);
        System.out.println("Session creada con exito.");

    }

    public static void removeSession() {
        SessionService service = new SessionService();
        RoomService roomService = new RoomService();

        System.out.println(" ");
        System.out.println("Lista de sesiones:");
        service.seeSessions();
        System.out.println(" ");
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
        SessionService service = new SessionService();
        System.out.println(" ");
        System.out.println("Lista de sesiones:");
        service.seeSessions();
    }

    public static void markSessionAsPassed() {
        SessionService service = new SessionService();
        boolean exit = true;
        System.out.println(" ");
        System.out.println("Lista de sesiones:");
        service.seeSessions();
        System.out.println(" ");
        System.out.println("Introduce la posición de la sesión que quieres marcar como pasada.");
        int index = sc.nextInt();
        sc.nextLine();
        Session session = service.getSession(index);

        do {
            System.out.println("Marca si se ha pasado la partida. (Si/No).");
            String option = sc.nextLine().trim().toLowerCase();

            if (option.equals("si")) {
                session.setFinished(true);
                service.updateSession(session);
                System.out.println("Sesión marcada como pasada.");
                exit = false;
            } else if (option.equals("no")) {
                session.setFinished(false);
                service.updateSession(session);
                System.out.println("La sesión ha sido marcada como no finalizada.");
                exit = false;
            } else {
                System.out.println("Por favor, escribe 'si' o 'no':");
            }
        } while (exit);
    }
}
package Menus;

import java.util.Scanner;

public class Menu {

  public static void Start() {
      Scanner sc = new Scanner(System.in);
      ClientMenu clientsMenu = new ClientMenu();
      int choose;
      boolean exit = true;
      do {
          try {
              System.out.println("***Bienvenido al gestor de scape room***");
              System.out.println("1.-Gestion de Escaperoom");
              System.out.println("2.-Gestion de jugadores");
              System.out.println("3.-Salir de la aplicacion");
              System.out.print("Elige una opción: ");

              choose = sc.nextInt();
              sc.nextLine();

              switch (choose) {

                  case 1: RoomsMenu.roomsStart();
                      break;
                  case 2: clientsMenu.ClientStart();
                      break;
                  case 3:
                      System.out.println("Saliendo de la aplicacion...");
                      exit = false;
                      break;
                  default:
                      System.out.println("Valor incorrecto");
                      break;
              }
          } catch (Exception e) {
              System.out.println("Error: Debes ingresar un número entero.");
              sc.nextLine();
          }
      } while (exit);
  }
}
package Menus;

import Menus.MenusItems.EscapeRoomMenu;
import Menus.MenusUser.UserMenu;

import java.util.Scanner;

public class MainMenu {

  public void Start() {
      Scanner sc = new Scanner(System.in);
      int choose;
      boolean exit = true;
      do {

              System.out.println(" ");
              System.out.println("***Bienvenido al gestor del scape room***");
              System.out.println("1.-Gestión de Escaperoom");
              System.out.println("2.-Gestión de jugadores");
              System.out.println("3.-Salir de la aplicación");
              System.out.print("Elige una opción: ");

              choose = sc.nextInt();
              sc.nextLine();

              switch (choose) {

                  case 1: EscapeRoomMenu escapeRoomMenu = new EscapeRoomMenu();
                          escapeRoomMenu.escapeRoomStart();
                      break;
                  case 2: UserMenu userMenu = new UserMenu();
                          userMenu.userStart();
                      break;
                  case 3:
                      System.out.println("Saliendo de la aplicación...");
                      exit = false;
                      break;
                  default:
                      System.out.println("Valor incorrecto");
                      break;
              }
      } while (exit);
  }
}
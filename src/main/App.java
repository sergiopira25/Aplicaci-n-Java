package main;

import java.util.Scanner;
import model.Password;
import service.PasswordValidator;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordValidator validator = new PasswordValidator();

        boolean valida = false;

        while (!valida) {
            System.out.print("Ingrese una contraseña: ");
            String input = scanner.nextLine();

            Password password = new Password(input);

            if (validator.esValida(password)) {
                System.out.println("✅ La contraseña es válida.");
                valida = true;
            } else {
                System.out.println("❌ La contraseña no cumple con los requisitos:");
                System.out.println("- Debe tener al menos 8 caracteres.");
                System.out.println("- Debe contener al menos un número.");
                System.out.println("Intente nuevamente.\n");
            }
        }

        scanner.close();
    }
}


import java.util.Scanner;

import controllers.MetodoBusquedaBinaria;
import models.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de personas del listado ");
        int total = scanner.nextInt();
        scanner.nextLine(); 

        Persona[] people = new Persona[total];

        for (int i = 0; i < total; i++) {
            System.out.println("Ingrese persona " + (i + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); 

            people[i] = new Persona(edad, nombre);
        }

        MetodoBusquedaBinaria mBB = new MetodoBusquedaBinaria(people);

        mBB.showPersonByEdad();


        scanner.close();


        

    }
}
    


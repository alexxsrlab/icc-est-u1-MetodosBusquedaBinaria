package controllers;

import models.Persona;
import views.ShowConsole;

public class MetodoBusquedaBinaria {
    private Persona[] people;
    private ShowConsole pantalla;

    public MetodoBusquedaBinaria(Persona[] people) {
        this.people = people;
        this.pantalla = new ShowConsole();
        pantalla.showMessage("Metodo de Busqueda Binaria");
    }

    public void burbujaedad() {
        int n = people.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (people[j].getEdad() > people[j + 1].getEdad()) {
                    Persona temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    private int findPersonByEdad(int edad) {
        burbujaedad();
        int bajo = 0;
        int alto = people.length - 1;

        while (alto >= bajo) {
            int central = (bajo + alto) / 2;
            int i = bajo;
            while (i <= alto) {
                System.out.print(people[i].getEdad());
                if (i < alto) {
                    System.out.print(" | ");
                }
                i++;
            }
            System.out.println();

            int valorCentro = people[central].getEdad();
            System.out.println("bajo=" + bajo + " alto=" + alto + " centro=" + central + " valorCentro=" + valorCentro);

            if (people[central].getEdad() == edad) {
                System.out.println(" --> ENCONTRADO");
                return central;
            }
            if (people[central].getEdad() > edad) {
                System.out.println(" --> IZQUIERDA");
                alto = central - 1;// izquierda

            } else {
                System.out.println(" --> DERECHA");
                bajo = central + 1;// derecha
            }
        }
        return -1;
    }

    public void showPersonByEdad() {
        int edadTofind = pantalla.inmputedad();
        int indexPerson = findPersonByEdad(edadTofind);

        if (indexPerson == -1) {
            pantalla.showMessage("Persona con edad " + edadTofind + " no encontrada");
        } else {
            pantalla.showMessage("Persona con edad " + edadTofind + " encontrada");
            pantalla.showMessage(people[indexPerson].toString());
        }
    }

    private void burbujanombre() {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getNombre().compareToIgnoreCase(people[j + 1].getNombre()) > 0) {
                    Persona temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    private int findPersonByNombre(String nombre) {
        burbujanombre();
        int bajo = 0;
        int alto = people.length - 1;

        while (alto >= bajo) {
            int central = (bajo + alto) / 2;

            if (people[central].getNombre().equalsIgnoreCase(nombre)) {
                return central;
            }
            if (people[central].getNombre().compareToIgnoreCase(nombre) > 0) {
                alto = central - 1;// izquierda

            } else {
                bajo = central + 1;// derecha
            }
        }
        return -1;
    }

    public void showPersonByName() {
        String nombreToFind = pantalla.inputNombre();
        int indexPerson = findPersonByNombre(nombreToFind);

        if (indexPerson == -1) {
            pantalla.showMessage("Persona con nombre " + nombreToFind + " no encontrada");
        } else {
            pantalla.showMessage("Persona con nombre " + nombreToFind + " encontrada");
            pantalla.showMessage(people[indexPerson].toString());
        }
    }
}

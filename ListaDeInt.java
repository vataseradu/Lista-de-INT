package ListaDeInt;

import javax.swing.*;

public class ListaDeInt {
    int[] elemente;
    int dimensiuneaMaxima;
    int numarCurentDeElemente;

    ListaDeInt(int dimensiuneaMaxima, int numarCurentDeElemente) {
        this.dimensiuneaMaxima = dimensiuneaMaxima;
        numarCurentDeElemente = 0;
        this.numarCurentDeElemente = numarCurentDeElemente;
        elemente = new int[dimensiuneaMaxima];

    }

    public void afisareElemente() {
        if (numarCurentDeElemente == 0) {
            System.out.println("Lista nu contine elemente");
        } else {
            System.out.println("Elementele listei sunt: ");
            for (int i = 0; i < dimensiuneaMaxima; i++) {
                System.out.println("elementul " + i + ": " + elemente[i]);
            }
        }

    }

    public void adaugareElement(int elementInserat) {
        try {
            if (numarCurentDeElemente == dimensiuneaMaxima) {
                System.out.println("\n" + "Nu se mai pot adauga elemente..");
                System.out.println("Numarul curent de elemente este:" + numarCurentDeElemente);

            } else if (numarCurentDeElemente == 0) {
                elemente[0] = elementInserat;
                numarCurentDeElemente++;
                System.out.println("A fost adaugat elementul: " + elementInserat);
                System.out.println("Numarul curent de elemente este:" + numarCurentDeElemente);
            } else {
                for (int i = dimensiuneaMaxima - 1; i > 0; i--) {
                    elemente[i] = elemente[i - 1];
                }
                elemente[0] = elementInserat;
                numarCurentDeElemente++;
                System.out.println("A fost adaugat elementul: " + elementInserat);
                System.out.println("Numarul curent de elemente este:" + numarCurentDeElemente);
            }
        } catch (NumberFormatException e) {
            System.out.println("Introdu un numar");
        }
    }

    public int getNumarCurentDeElemente() {
        return numarCurentDeElemente;
    }

    public int getDimensiuneaMaxima() {
        return dimensiuneaMaxima;
    }

    public void stergereElement() {

        if (numarCurentDeElemente == 0) {
            System.out.println("Nu mai exista niciun element pentru a fi sters");
        } else {
            System.out.println("\n" + "A fost sters elementul: " + elemente[numarCurentDeElemente - 1]);
            elemente[numarCurentDeElemente - 1] = 0;

            numarCurentDeElemente--;
            System.out.println("Numarul curent de elemente este:" + numarCurentDeElemente);
        }
    }

    public String toString() {
        String listaMea = "";
        for (int i = 0; i < dimensiuneaMaxima; i++) {
            if (elemente[i] == 0) {

            } else {

                listaMea += elemente[i] + "\n" + "   ";
            }
        }
        return listaMea;
    }

    public void sortareElemente() {
        boolean bul = true;
        while (bul) {
            for (int j = 0; j < dimensiuneaMaxima - 1; j++) {
                for (int i = 0; i < dimensiuneaMaxima - 1; i++) {
                    if (elemente[i] > elemente[i + 1]) {
                        int temporar = elemente[i];
                        elemente[i] = elemente[i + 1];
                        elemente[i + 1] = temporar;
                    }
                }
            }
            bul = false;
            System.out.println("Elementele au fost sortate crescator");
        }

    }

}

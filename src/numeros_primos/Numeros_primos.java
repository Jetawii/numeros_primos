/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros_primos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ycoz
 */
public class Numeros_primos {

    // CONSTANTE
    public static String RUTA = "numeros.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> primos = new ArrayList<>();
        // PUNTO DOS 
        // Almacenamos los números primos que nos pida el usuario en un array. 
        System.out.println("Números primos almacenados en el fichero: ");
        leerFichero();
        boolean salir = false;
        do {
            System.out.println("1. Añadir primos.");
            System.out.println("2. Vaciar contenido fichero.");
            System.out.println("3. Mostrar contenido fichero.");
            System.out.println("");
            System.out.println("4. Salir.");
            System.out.print("Elige una opción: ");
            String opcion = sc.next();
            switch (opcion) {
                case "1":
                    System.out.println("¿Cuántos números primos más quieres añadir?");
                    int numero = sc.nextInt();
                    int contador = 0;
                    boolean completado = false;
                    for (int i = primos.size(); i >= 0 && !completado; i++) {
                        if (numeroPrimo(i)) {
                            primos.add(i);
                            contador = contador + 1;
                        }
                        if (primos.size() == numero) {
                            completado = true;
                        }
                    }
                    escribirFichero(primos);
                    break;
                case "2":
                    vaciarFichero();
                    break;
                case "3":
                    leerFichero();
                    break;
                case "4":
                    salir = true;
                    System.out.println("Nos vemos pronto :)");
                    break;
                default:
                    System.out.println("Solo números del 1 al 7.");
            }
        } while (!salir);

        // Mostramos el contenido del array.
        // System.out.print("Tus números primos son: ");
        // for (int i = 0; i < primos.size(); i++) {
        //      System.out.println(primos.get(i));
        // }
        // Escribimos el array en el fichero.
    }

    // PUNTO UNO 
    // Vamos a empezar por lo más básico. 
    // Hagamos un programa que compruebe si un número es primo o no.
    public static boolean numeroPrimo(int numero) {
        boolean primo = false;
        if (numero % 2 != 0 && numero != 1) {
            if (numero % 5 != 0 && numero != 1) {
                if (numero % 3 != 0 && numero != 1) {
                    if (numero % 7 != 0 && numero != 1) {
                        primo = true;
                    }
                }
            }
        }
        if ((numero > 1 && numero <= 3) || numero == 5 || numero == 7) {
            primo = true;
        }
        return primo;
    }

    public static void escribirFichero(ArrayList<Integer> primos) {
        // Creamos un objeto fichero
        //File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        FileWriter f = null;
        BufferedWriter s = null;
        try {
            f = new FileWriter(fichero, true);
            s = new BufferedWriter(f);
            int tamaño = primos.size();
            for (int i = 0; i < tamaño; i++) {
                s.write(primos.get(i) + " ");
            }

        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        } finally {
            // Cerramos el fichero se haya escrito la info o no. 
            try {
                s.close();
                f.close();
            } catch (IOException ex2) {
                System.out.println("Mensaje de la excepción: " + ex2.getMessage());
            }
        }
    }

    public static void leerFichero()  {
        // Creamos un objeto fichero
        // File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        FileReader f = null;
        BufferedReader s = null;
        String numero="";
        try {
            f = new FileReader(fichero);
            s = new BufferedReader(f);
            numero=s.readLine();
            System.out.println(numero);
        } catch (FileNotFoundException ex) {
            try {
                fichero.createNewFile();
                System.out.println("Mensaje de la excepción: " + ex.getMessage());
            } catch (IOException ex1) {
                System.out.println("Mensaje de la excepción: " + ex1.getMessage());
            }
        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        } finally {
            // Cerramos el fichero se haya escrito la info o no. 
            try {
                s.close();
                f.close();
            } catch (IOException ex2) {
                System.out.println("Mensaje de la excepción: " + ex2.getMessage());
            }
        }
    }

    public static void vaciarFichero() {
        // Creamos un objeto fichero
        //File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        FileWriter f = null;
        BufferedWriter s = null;
        try {
            f = new FileWriter(fichero);
            s = new BufferedWriter(f);
            s.write("");
        } catch (FileNotFoundException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        } finally {
            // Cerramos el fichero se haya escrito la info o no. 
            try {
                s.close();
                f.close();
            } catch (IOException ex2) {
                System.out.println("Mensaje de la excepción: " + ex2.getMessage());
            }
        }
    }

}

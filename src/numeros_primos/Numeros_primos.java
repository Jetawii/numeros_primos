/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros_primos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("¿Cuántos números primos más quieres añadir?");
        System.out.println("¿Quieres eliminar el contenido del fichero?");
        int numero = sc.nextInt();
        int contador = 0;
        boolean completado = false;
        for (int i = leerPrimero()+1; i >= 0 && !completado; i++) {
            if (numeroPrimo(i)) {
                primos.add(i);
                contador = contador + 1;
            }
            if (primos.size() == numero) {
                completado = true;
            }
        }
        escribirFichero(primos);
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
            f = new FileWriter(fichero,true);
            s = new BufferedWriter(f);
            int tamaño = primos.size();
            for (int i = 0; i < tamaño; i++) {
                s.write(Integer.toString(primos.get(i))+" ");
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
    
    public static void eliminarFichero(ArrayList<Integer> primos) {
        // Creamos un objeto fichero
        //File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        FileWriter f = null;
        BufferedWriter s = null;
        try {
            f = new FileWriter(fichero,true);
            s = new BufferedWriter(f);
            int tamaño = primos.size();
            for (int i = 0; i < tamaño; i++) {
                s.write(Integer.toString(primos.get(i))+" ");
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

    public static void leerFichero() {
        // Creamos un objeto fichero
        // File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        FileReader f = null;
        BufferedReader s = null;
        String numero = "";
        try {
            f = new FileReader(fichero);
            s = new BufferedReader(f);
            numero = s.readLine();
            System.out.println(numero);
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

    public static int leerPrimero() {
        // Creamos un objeto fichero
        // File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        FileReader f = null;
        BufferedReader s = null;
        String numero = "";
        int primo=0;
        try {
            f = new FileReader(fichero);
            s = new BufferedReader(f);
            numero = s.readLine();
            String numeroultimo=numero.substring(numero.length()-3, numero.length()-1);
            if(numeroultimo.contains(" ")){
                numeroultimo=numeroultimo.replace(" ", "");
            }
            primo=Integer.parseInt(numeroultimo);
            System.out.println(primo);
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
        return primo;
    }

}
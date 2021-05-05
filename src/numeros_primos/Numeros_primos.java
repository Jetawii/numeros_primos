/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros_primos;


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
        
        // PUNTO UNO 
        // Vamos a empezar por lo más básico. 
        // Hagamos un programa que nos de un determinado número de números primos. 
        // Los números primos solo se pueden dividir por uno y por si mismo. 
        System.out.println("¿Cuántos números primos necesitas?");
        int user=sc.nextInt();
        // Hacemos un bucle que va a determinar si un número es primo o no. 
        // En caso de que si lo sea lo vamos a almacenar en un array. 
        ArrayList<Integer> primos = new ArrayList<>();
        int lista=primos.size()-1;
        do{
            int primo=1;
            if(primo%2!=0){
                 if(primo%3!=0){
                     if (primo%5!=0){
                         if(primo%7!=0){
                             primos.add(primo);
                         }
                     }
                 }
            }
            primo++;
        }while(lista!=user);
        for(int i=0;i<primos.size();i++){
            System.out.println("Tú listado de primos: "+ primos.get(i));
        }
    }
    
    
    
}

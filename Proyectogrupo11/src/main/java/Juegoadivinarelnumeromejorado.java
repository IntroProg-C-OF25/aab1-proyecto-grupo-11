/***
 *Se le solicita desarrollar un demo tipo juego, que permita generar un número
 *aleatorio y le rete al usuario que lo adivine. Si no adivina el número, el juego
 *debe sugerirle lo intente nuevamente con pistas (es mayor, menor, es par,
 *impar, es primo, pertenece a la serie de fibonacy, es multiplo de N, etc.), el
 *usuario es quien deberá ir pidiendo repetitivamente que el sistema le muestre o
 *no, más pintas, solo que, si el usuario pide más pistas, el sistema
 *automáticamente le resta un intento y le informa cuantos intentos le quedan. Al
 *finalizar el juego, se debe felicitar al usuario si gana y como, o pedir que lo
 *intente de nuevo.
 *
 * @author Hans
 */
import java.util.Scanner;

public class Juegoadivinarelnumeromejorado {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // VARIABLES.
        int aleatorio = (int) (Math.random() * 50); // Cambie el rango a 0-50
        int num, intentos = 10;
        String pistas;
        String reglas = """
                       REGLAS BASICAS
                       1) Tienes 10 intentos para adivinar el numero.
                       2) Vas a ir encontrando diferentes pistas conforme te acerques al numero correcto.
                       3) Puedes solicitar pistas en cualquier momento, pero se te penalizara restandote intentos.
                       4) Si pides dos o mas pistas seguidas la resta de intentos va a aumentar.
                          Primer pista: Gratis, Segunda pista: -1 intento, Tercer pista: -2 intentos
                       """;
        // IMPRESIÓN DE LAS REGLAS 
        System.out.println(reglas);

        // INICIO DEL CICLO WHILE
        while (intentos > 0) {
            System.out.println("TIENES " + intentos + " INTENTOS PARA ADIVINAR.");
            System.out.print("ADIVINA UN NUMERO (0-50): ");
            num = teclado.nextInt();
            teclado.nextLine();

            // Validar el rango del numero
            if (num < 0 || num > 50) {
                System.out.println("Por favor, ingresa un numero entre 0 y 50.");
                continue;
            }

            // CONDICIONAL EN CASO DE ADIVINAR EL NÚMERO O EN CASO DE QUE SE LE ACABEN LOS INTENTOS.
            if (aleatorio == num) {
                System.out.println("FELICIDADES GANASTE");
                break; // Termina el juego si adivina correctamente
            } else {
                intentos--; // Restar un intento solo si no adivina
                if (intentos == 0) {
                    System.out.println("MALA SUERTE. El numero era " + aleatorio + ". Puedes intentarlo nuevamente.");
                    break; // Termina el juego si se acaban los intentos
                }
            }

            // CONDICIONALES DE LAS PISTAS.
            System.out.println("AQUI TIENES UNA PISTA: ");
            if (aleatorio > num) {
                System.out.println("PISTA: ES MAYOR A " + num);
            } else {
                System.out.println("PISTA: ES MENOR A " + num);
            }

            // Solicitar segunda pista
            System.out.print("QUIERES UNA SEGUNDA PISTA (SI/NO): ");
            pistas = teclado.nextLine();
            if (pistas.equalsIgnoreCase("SI") && intentos > 0) {
                intentos--; // Restar un intento por la segunda pista
                if (aleatorio % 3 == 0) {
                    System.out.println("PISTA: El numero es multiplo de 3.");
                } else {
                    System.out.println("PISTA: El numero no es multiplo de 3.");
                }
            }

            // Solicitar tercera pista
            System.out.print("QUIERES UNA TERCERA PISTA (SI/NO): ");
            pistas = teclado.nextLine();
            if (pistas.equalsIgnoreCase("SI") && intentos > 0) {
                intentos -= 2; // Restar dos intentos por la tercera pista
                System.out.println("INTENTOS RESTANTES: " + intentos);
                if (aleatorio % 2 == 0) {
                    System.out.println("PISTA: EL NUMERO ES PAR.");
                } else {
                    System.out.println("PISTA: EL NUMERO ES IMPAR.");
                }
            }

            // Comprobar si el numero ingresado es primo o no es primo
            if (pistas.equalsIgnoreCase("SI") && intentos > 0) {
                intentos -= 2;
                System.out.println("INTENTOS RESTANTES: " + intentos);
                if (aleatorio % 1 == 0) {
                    System.out.println("PISTA: EL NUMERO ES PRIMO.");
                } else {
                    System.out.println("PISTA: EL NUMERO NO ES PRIMO.");
                }
            }
        }

    }
}
/***
 * Run
 * REGLAS BASICAS
 * 1) Tienes 10 intentos para adivinar el numero.
 * 2) Vas a ir encontrando diferentes pistas conforme te acerques al numero correcto.
 * 3) Puedes solicitar pistas en cualquier momento, pero se te penalizara restandote intentos.
 * 4) Si pides dos o mas pistas seguidas la resta de intentos va a aumentar.
 * Primer pista: Gratis, Segunda pista: -1 intento, Tercer pista: -2 intentos

 * TIENES 10 INTENTOS PARA ADIVINAR.
 * ADIVINA UN NUMERO (0-50): 15
 * AQUI TIENES UNA PISTA: 
 * PISTA: ES MENOR A 15
 * QUIERES UNA SEGUNDA PISTA (SI/NO): no
 * QUIERES UNA TERCERA PISTA (SI/NO): NO
 * TIENES 9 INTENTOS PARA ADIVINAR.
 * ADIVINA UN NUMERO (0-50): 10
 * AQUI TIENES UNA PISTA: 
 * PISTA: ES MENOR A 10
 * QUIERES UNA SEGUNDA PISTA (SI/NO): si
 * PISTA: El numero no es multiplo de 3.
 * QUIERES UNA TERCERA PISTA (SI/NO): 13
 * TIENES 7 INTENTOS PARA ADIVINAR.
 * ADIVINA UN NUMERO (0-50): 12
 * AQUI TIENES UNA PISTA: 
 * PISTA: ES MENOR A 12
 * QUIERES UNA SEGUNDA PISTA (SI/NO): si
 * PISTA: El numero no es multiplo de 3.
 * QUIERES UNA TERCERA PISTA (SI/NO): si
 * INTENTOS RESTANTES: 3
 * PISTA: EL NUMERO ES IMPAR.
 * INTENTOS RESTANTES: 1
 * PISTA: EL NUMERO ES PRIMO.
 * TIENES 1 INTENTOS PARA ADIVINAR.
 * ADIVINA UN NUMERO (0-50): 9
 * MALA SUERTE. El numero era 7. Puedes intentarlo nuevamente.
 */
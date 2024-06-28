import com.Alura.Divisas.Modelo.CalculadoraDeDivisas;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion=0;
        double cantidadAConvertir;
        String menu = """
                1.- Dolar USD => peso argentino
                2.- Peso argentino => dolar USD
                3.- Dolar USD => peso brasileño
                4.- Peso brasiño => dolar USD
                5.- Dolar USD => peso colombiano
                6.- Peso colombiano => dolar USD
                7.- Salir
                """;
        CalculadoraDeDivisas monedas = new CalculadoraDeDivisas();
        Scanner capturar = new Scanner(System.in);
        while(true){
            System.out.println(menu);
            System.out.print("Ingresa la opcion: ");
            opcion = capturar.nextInt();
            if (opcion==7){
                break;
            }
            System.out.print("Ingresa la cantidad a convertir: ");
            cantidadAConvertir = capturar.nextDouble();
            switch (opcion){
                case 1:
                    monedas.conversor(cantidadAConvertir, "USD", "ARS");
                    break;
                case 2:
                    monedas.conversor(cantidadAConvertir, "ARS", "USD");
                    break;
                case 3:
                    monedas.conversor(cantidadAConvertir, "USD", "BRL");
                    break;
                case 4:
                    monedas.conversor(cantidadAConvertir, "BRL", "USD");
                    break;
                case 5:
                    monedas.conversor(cantidadAConvertir, "USD", "COP");
                    break;
                case 6:
                    monedas.conversor(cantidadAConvertir, "COP", "USD");
                    break;
                default:
                    System.out.println("Esa opcion no esta dentro del menu");
                    break;
            }
        }

    }
}

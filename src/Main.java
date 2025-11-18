import com.practice.apiexchange.DTOs.ExancheAPI;
import com.practice.apiexchange.http.ApiClient;
import com.practice.apiexchange.models.Moneda;
import com.practice.apiexchange.utils.GsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in); //Implementando el metodo Scanner
        List<Moneda> listaConversiones = new ArrayList<>();
        int opc = 0;
        double montoConvertir = 0;

        while(opc != 12){
            System.out.println("**** API - CONVERTIDOR DE DIVISAS ****");
            System.out.println("Ingrese el monto que desea convertir");
            montoConvertir = sc.nextDouble();

            opc = menu(sc);

            switch (opc){
                case 1:
                    System.out.println("Conversion USD A CLP");
                    procesarConversion("USD","CLP",montoConvertir, listaConversiones);
                    break;
                case 2:
                    System.out.println("Conversion USD A JYP");
                    procesarConversion("USD","JPY",montoConvertir,listaConversiones);
                    break;
                case 3:
                    System.out.println("Conversion ARG A USD");
                    procesarConversion("ARG","USD",montoConvertir,listaConversiones);
                    break;
                case 4:
                    System.out.println("Conversion EUR A USD");
                    procesarConversion("EUR","USD",montoConvertir,listaConversiones );
                    break;
                case 5:
                    System.out.println("Conversion USD A LIBRA");
                    procesarConversion("USD","GBP",montoConvertir,listaConversiones);
                    break;
                case 6:
                    System.out.println("Conversion USD A AUD");
                    procesarConversion("USD","AUD",montoConvertir,listaConversiones);
                    break;
                case 7:
                    System.out.println("Conversion CLP A WON");
                    procesarConversion("CLP","WON",montoConvertir,listaConversiones);
                    break;
                case 8:
                    System.out.println("Conversion USD A WON");
                    procesarConversion("USD","WON",montoConvertir,listaConversiones);
                    break;
                case 9:
                    System.out.println("Conversion JPY A WON");
                    procesarConversion("JPY","WON",montoConvertir,listaConversiones);
                    break;
                case 10:
                    String monedaBase = "";
                    String monedaTarget = "";
                    double monto = 0;
                    sc.nextLine();
                    System.out.println("Ingrese una conversion personalizada");
                    System.out.println("Moneda base");
                    monedaBase = sc.nextLine();
                    System.out.println("Moneda objetivo");
                    monedaTarget = sc.nextLine();
                    System.out.println("Ingrese monto");
                    monto = sc.nextDouble();
                    procesarConversion(monedaBase, monedaTarget, monto, listaConversiones);
                    break;
                default:
                    System.out.println("La dirección ingresada no es valida");
            }
        }
        sc.close(); //Cerrando el metodo Scanner();
    }

    public static int menu(Scanner scan){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n***** Conversor de monedas ************* \nElige entre las opciones 1 - 10");
        System.out.println("[1] Convertir de USD A CLP");
        System.out.println("[2] Convertir de USD A JYP");
        System.out.println("[3] Convertir de ARG A USD");
        System.out.println("[4] Convertir de EUR A USD");
        System.out.println("[5] Convertir de USD A LIBRA");
        System.out.println("[6] Convertir de USD A AUD");
        System.out.println("[7] Convertir de CLP A WON");
        System.out.println("[8] Convertir de USD A WON");
        System.out.println("[9] Convertir de USD A CLP");
        System.out.println("[10] Ingrese una conversion Personalizada");
        System.out.println("[11] Obtener historico de precio por una Divisa");
        System.out.println("[12] Abandonar el conversor...");
        return scan.nextInt();
    }

    /**
     * @param monedaBase == Moneda de Origen
     * @param monedaObjetivo == Moneda Objetivo
     * @param monto == Monto por el cual se realizara la conversión
     * @param listaConversiones == List<> que entra por parametro para ir añadiendo cada conversion realizada
     * @throws IOException // Manejo de Excepcion relacionadas al paquete LANG.NET
     * @throws InterruptedException // Manejo de exepcion por interrupcion de ejecucion
     */
    private static void procesarConversion(String monedaBase, String monedaObjetivo, double monto, List<Moneda> listaConversiones)
            throws IOException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        var json = apiClient.busquedaPrefinida(monedaBase, monedaObjetivo ,monto);
        var api = GsonUtils.fromJson(json, ExancheAPI.class);
        var moneda = new Moneda(api);
        listaConversiones.add(moneda);
        System.out.println(moneda);
    }
}
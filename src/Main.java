import com.practice.apiexchange.DTOs.ExancheAPI;
import com.practice.apiexchange.http.ApiClient;
import com.practice.apiexchange.models.Moneda;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiClient apiClient = new ApiClient();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        int cont = 1;

        var findByUsdClp = apiClient.busquedaPrefinida("USD","CLP",400);

        ExancheAPI exancheAPI = GsonUtils.fromJson(findByUsdClp, ExancheAPI.class);
        Moneda moneda = new Moneda(exancheAPI);
        System.out.println(moneda.toString());

        while(true){
            opc = menu();
            if(opc == 10){
                System.out.println("Gracias por utilizar Api Exanche \nVuelva Pronto !!");
                break;
            }

            cont +=1;
            System.out.println("Valor de cont: "+cont);
            switch (opc){
                case 1:
                    System.out.println("Opcion 1");
                    break;
                case 2:
                    System.out.println("Opcion 2");
                    break;
                case 3:
                    System.out.println("Opcion 3");
                    break;
                case 4:
                    System.out.println("Opcion 4");
                    break;
                case 5:
                    System.out.println("Opcion 5");
                    break;
                case 6:
                    System.out.println("Opcion 6");
                    break;
                case 7:
                    System.out.println("Opcion 7");
                    break;
                case 8:
                    System.out.println("Opcion 8");
                    break;
                case 9:
                    System.out.println("Opcion 9");
                    break;
                default:
                    System.out.println("La dirección ingresada no es valida");
            }
        }
    }

    public static int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n***** Conversor de monedas ************* \nElige entre las opciones 1 - 7");
        System.out.println("[1] Convertir de USD A CLP");
        System.out.println("[2] Convertir de USD A CLP");
        System.out.println("[3] Convertir de USD A CLP");
        System.out.println("[4] Convertir de USD A CLP");
        System.out.println("[5] Convertir de USD A CLP");
        System.out.println("[6] Convertir de USD A CLP");
        System.out.println("[7] Convertir de USD A CLP");
        System.out.println("[8] Convertir de USD A CLP");
        System.out.println("[9] Convertir de USD A CLP");
        System.out.println("[10] Abandonar el conversor...");
        return sc.nextInt();
    }


}
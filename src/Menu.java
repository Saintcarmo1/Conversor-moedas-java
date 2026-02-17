import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner sc;
    Gson gson;

    private static final Map<Integer, ParMoeda> OPCOES = Map.of(
            1, new ParMoeda("USD", "BRL"),
               2, new ParMoeda("GBP", "USD"),
                3, new ParMoeda("JPY", "EUR"),
                    4, new ParMoeda("CHF", "CAD"),
                        5, new ParMoeda("BRL", "AUD"),
                             6, new ParMoeda("HKD", "CNY")
    );

    public Menu () {
        this.sc = new Scanner(System.in);
        this.gson = (new GsonBuilder()).setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
    }



    public void mudanca (int i ) throws IOException {
        System.out.println("**************************************************");
        // Como funciona o chamado de map e chaves . Utilizar isso depois.
        ParMoeda par = OPCOES.get(i);
        if (par == null){
            System.out.println("Opção invalida");
        }
        else {
            System.out.println("digite o valor que deseja converter: ");
            int valor = sc.nextInt();
            Conversao conversao = new Conversao();
            double resultado = conversao.converterMoeda(par, valor);
            System.out.println(par);
            System.out.println(
                    "O valor " + valor + " " + par.conversor() +
                            " foi convertido para " + resultado + " " + par.convertido()
            );
        }




    }



    public void exibir () throws IOException {
        int x = 1;
        while (x!=0) {
            System.out.println("**************************************************");
            System.out.println("Bem vindo ao conversor de moedas.");
            System.out.println("1) Dólar Americano para Real");
            System.out.println("2) Libra Esterlina para Dólar Americano");
            System.out.println("3) Iene para Euro");
            System.out.println("4) Franco Suíço para Dólar Canadense");
            System.out.println("5) Real para Dólar Australiano");
            System.out.println("6) Dólar de Hong Kong para Yuan Chinês");

            System.out.println("0) Sair do programa");
            System.out.println("**************************************************");
            x = this.sc.nextInt();
            if (x==0){
                System.out.println("Ate a proxima =)");
            }else{
                System.out.println("A opção selecionado foi: " + x );
                mudanca(x);
            }
        }

    }
}

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Conversao {
    Gson gson = new Gson();

    //https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD



    public String ApiCall(String moeda) {
        try {
            String Dinheiro = "https://v6.exchangerate-api.com/v6/cb263770349d31b06f3cfff6"+ "/latest/" + moeda;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Dinheiro)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return (String)response.body();
        } catch (Exception e) {
            throw new RuntimeException("Algo deu errado:", e);
        }
    }

    public double converterMoeda(ParMoeda par, double valor) throws IOException {
        String json = ApiCall(par.conversor());

        ExchangeResponse resp = gson.fromJson(json, ExchangeResponse.class);

        Double taxa = resp.conversion_rates().get(par.convertido());
        if (taxa == null) {
            throw new IllegalArgumentException("Moeda destino não encontrada: " + par.convertido());
        }

        return valor * taxa;
    }
}


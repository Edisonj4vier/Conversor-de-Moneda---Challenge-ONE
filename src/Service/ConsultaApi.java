package Service;

import Model.RespuestaApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    private static final String API_KEY = "0d3a251360646a3c0c5cbaf5";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private HttpClient client;
    private Gson gson;

    public ConsultaApi() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    /**
     *  Obtiene las tasas de cambio para una moneda base
     */
    public RespuestaApi obtenerTasasCambio(String monedaBase) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/" + monedaBase;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200){
            return gson.fromJson(response.body(), RespuestaApi.class);
        }else{
            throw new IOException("Error en la API: " + response.statusCode());
        }
    }

    /**
     *  Convierte una cantidad de moneda a otra
     */
    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) throws IOException, InterruptedException {
        RespuestaApi respuesta = obtenerTasasCambio(monedaOrigen);

        if (respuesta.getConversion_rates().containsKey(monedaDestino)){
            double tasa = respuesta.getConversion_rates().get(monedaDestino);
            return cantidad * tasa;
        }else {
            throw new IllegalArgumentException("Moneda destino no encontrada: " + monedaDestino);
        }
    }

    /**
     *  Obtiene la tasa de cambio entre dos monedas
     */
    public double obtenerTasa(String monedaOrigen, String monedaDestino) throws IOException, InterruptedException {
        RespuestaApi respuesta = obtenerTasasCambio(monedaOrigen);

        if (respuesta.getConversion_rates().containsKey(monedaDestino)){
            return respuesta.getConversion_rates().get(monedaDestino);
        }else {
            throw new IllegalArgumentException("Moneda destino no encontrada: " + monedaDestino);
        }
    }

}

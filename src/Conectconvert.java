import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conectconvert {
    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "e450cef1f63592cc4bbf2d3a";

    public TrataResposta conectStringtoJson(String  par, String amount)  {

        URI endereco = URI.create(ENDERECO+API_KEY+"/pair/"+par+"/"+amount);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TrataResposta.class);
        } catch (Exception e) {
            throw new RuntimeException("não consegui obter a paridade ");
        }
    }
}

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conectconvert {

    public TrataResposta conectStringtoJson(String  par, String amount)  {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/e450cef1f63592cc4bbf2d3a/pair/"+par+"/"+amount);

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

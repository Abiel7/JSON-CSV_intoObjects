package Json;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Assembly {
    private static final String URL = "https://api.assemblyai.com/v2/transcript";
    private static final String audio_url = "https://bit.ly/3yxKEIY";

    public static void main(String[] args) throws Exception {
    Transcript trnascript = new Transcript();
    trnascript.setAudio_url(audio_url);
    trnascript.setLanguage_code("es");
        Gson gson = new Gson();
        String json = gson.toJson(trnascript);

        HttpRequest request  = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Authorization",CONSTANT.API_KEY)
                .header("language_code",trnascript.getLanguage_code())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        trnascript=  gson.fromJson(response.body(),Transcript.class);
        System.out.println(trnascript.getId());
        HttpResponse<String> getResponse = null;
        while(true) {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL + "/" + trnascript.getId()))
                    .header("Authorization", CONSTANT.API_KEY)

                    .build();
             getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            trnascript = gson.fromJson(getResponse.body(), Transcript.class);
            if (trnascript.getStatus().equals("completed")) {
                break;
            }
            if(trnascript.getStatus().equals("error")) {
                System.out.println("Error");
                break;
            }
            Thread.sleep(1000);
            System.out.println("processing");
        }
        System.out.println(trnascript.getText());


    }



}

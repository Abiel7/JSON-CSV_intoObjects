package Json;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Assembly {
    private static final String URL = "https://api.assemblyai.com/v2/transcript";
    private static final String audio_url = "https://raw.githubusercontent.com/johnmarty3/JavaAPITutorial/main/Thirsty.mp4";
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
    Transcript trnascript = new Transcript();
    trnascript.setAudio_url(audio_url);
        Gson gson = new Gson();
        String json = gson.toJson(trnascript);

        HttpRequest request  = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Authorization",CONSTANT.API_KEY)
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
            if (trnascript.getStatus().equals("completed") || trnascript.getStatus().equals("error")) {
                break;
            }
            Thread.sleep(1000);
            System.out.println("processing");
        }
        System.out.println(trnascript.getText());

    }
}

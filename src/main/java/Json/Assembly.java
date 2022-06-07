package Json;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Assembly {
    private static final String URL = ""
    public static void main(String[] args) {
        HttpRequest rewuest = HttpRequest.newBuilder()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .build();
        HttpClient client = HttpClient.newHttpClient();

    }
}

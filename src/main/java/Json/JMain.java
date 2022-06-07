package Json;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JMain {

    public static void main(String[] args) throws Exception{

        Gson gson = new Gson();
        Path path = Paths.get("Files/Color.json");

        Color [] colors = gson.fromJson(
                Files.newBufferedReader(path, StandardCharsets.UTF_8), Color[].class);
        for(Color c : colors) {
            System.out.println(c);
        }
    }
}

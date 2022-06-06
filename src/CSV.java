import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public final class CSV {

    private CSV() {
        throw new AssertionError("Cannot instantiate class");
    }


    public static List<Student> readStudent(Path path, String delimiter, Charset cr)  throws Exception {
        if(path == null || delimiter == null ) {
            throw new IllegalArgumentException("Path or delimiter is null, cannot read file");
        }
        cr = Objects.requireNonNullElse(cr, StandardCharsets.UTF_8);

        List<Student> content = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path,cr)) {
            String line ;
            while((line = br.readLine()) != null) {
                String []  values = line.split(Pattern.quote(delimiter));
                content.add(new Student(values[7],values[8],values[1]));

            }
        }
        return content;

    }


}

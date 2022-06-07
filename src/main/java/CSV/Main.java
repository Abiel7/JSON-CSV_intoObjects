package CSV;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static  final String COMMA_DELIMITER = ",";

    public static void main(String[] args)  throws Exception {
        String path = "Files/Student_Behaviour.csv";

        Path filePath = Path.of(path);


        Iterable<Student> studentList = CSV.readStudent(filePath, COMMA_DELIMITER, StandardCharsets.UTF_8);
        studentList.forEach(System.out::println);

    }
}

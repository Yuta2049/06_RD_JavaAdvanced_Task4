import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileService {

    private final String inputFileName = "input.txt";
    private final String outputFileName = "output.txt";

    public void parseFile() {

        Path path = Paths.get(inputFileName);

        byte[] bytes = null;

        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода для файла " + inputFileName);
        }

        if (bytes != null) {

            try (FileWriter fileWriter = new FileWriter(new File(outputFileName));
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                String regexp = "\\+\\d\\(\\d\\d\\d\\) \\d\\d\\d \\d\\d \\d\\d";
                Pattern pattern = Pattern.compile(regexp);

                Matcher matcher = pattern.matcher(new String(bytes));

                while (matcher.find()) {
                    String phoneNumber = matcher.group().replaceAll("[+ \\(\\)]", "");
                    bufferedWriter.write(phoneNumber + "\n");
                }

            } catch (IOException e) {
                System.out.println("Ошибка ввода-вывода для файла: " + outputFileName);
            }
        }
    }
}

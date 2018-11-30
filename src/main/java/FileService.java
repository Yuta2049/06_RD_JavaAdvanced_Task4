import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileService {

    private final String inputFileName = "input.txt";
    private final String outputFileName = "output.txt";

//    public void parseFile() {
//
//        //String inputStream = "Notification has been sent 150 times to +4(351) 455 22 44 successfully. +1(431) 542 56 12 is unreachable";
//
//        try (InputStream inputStream = new FileInputStream(inputFileName);
//             OutputStream outputStream = new FileOutputStream(outputFileName);) {
//
//            String regexp = "\\+\\d\\(\\d\\d\\d\\) \\d\\d\\d \\d\\d \\d\\d";
//            Pattern pattern = Pattern.compile(regexp);
//            //Matcher matcher = pattern.matcher(inputStream.toString());
//            Matcher matcher = pattern.matcher(inputStream);
//
//            while (matcher.find()) {
//                String phoneNumber = matcher.group().replaceAll("[+ \\(\\)]", "");
//                System.out.println(phoneNumber.getBytes());
//                outputStream.write(phoneNumber.getBytes());
//            }
//            outputStream.flush();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Не найден файл: " + inputFileName + " или " + outputFileName);
//        } catch (IOException e) {
//            System.out.println("Ошибка ввода-вывода для файла: " + inputFileName + " или " + outputFileName);
//        }
//
//    }

    public void parseFile() {

        //String inputStream = "Notification has been sent 150 times to +4(351) 455 22 44 successfully. +1(431) 542 56 12 is unreachable";

        //try (InputStream inputStream = new FileInputStream(inputFileName);
        //     OutputStream outputStream = new FileOutputStream(outputFileName);) {
        Path path = Paths.get(inputFileName);
        try (Stream<String> lines = Files.lines(path);) {

            String regexp = "\\+\\d\\(\\d\\d\\d\\) \\d\\d\\d \\d\\d \\d\\d";
            Pattern pattern = Pattern.compile(regexp);

            lines.forEach(s -> System.out.println(s));



            //Matcher matcher = pattern.matcher(inputStream.toString());
            Matcher matcher = pattern.matcher(inputStream);


            while (matcher.find()) {
                String phoneNumber = matcher.group().replaceAll("[+ \\(\\)]", "");
                System.out.println(phoneNumber.getBytes());
                outputStream.write(phoneNumber.getBytes());
            }
            outputStream.flush();

        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл: " + inputFileName + " или " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода для файла: " + inputFileName + " или " + outputFileName);
        }

    }


}

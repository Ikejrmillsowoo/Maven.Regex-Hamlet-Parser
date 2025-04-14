import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("hamlet.txt").getFile());


    public HamletParser() {
        this.hamletData = loadFile(file);
    }


    private String loadFile(File file) {
        StringBuilder result = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = findAndChangeNames(line);
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private void writeFileToTxt() throws IOException {
        File file = new File("src/main/resources/results.txt");

        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(this.hamletData);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getHamletData() throws IOException {
        writeFileToTxt();
        return hamletData;
    }


    public String findAndChangeNames(String string) {
        if (string.contains("Hamlet")) {
            Pattern pattern = Pattern.compile("\\b"+ "Hamlet"+"\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(string);
            return matcher.replaceAll("Leon");
        } else if (string.contains("Horatio")) {
            Pattern pattern = Pattern.compile("\\b"+"Horatio"+"\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(string);
            return matcher.replaceAll("Tariq");
        }
        return string;
    }

    public boolean findGivenName(String string) {
        Pattern pattern = Pattern.compile("\\b"+string+"\\b", Pattern.CASE_INSENSITIVE);
        try (Scanner scanner = new Scanner(this.hamletData)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()){
                    return true;
                }
            }
            scanner.close();
        }

        return false;
    }
}

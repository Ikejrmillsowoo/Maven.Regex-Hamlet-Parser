import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    //private String dataFile = "hamlet.txt";
    Pattern patternHamlet = Pattern.compile("\\bHamlet\\b");
    Pattern patternHoratio = Pattern.compile("\\bHoratio\\b");



    public HamletParser(){
        this.hamletData = loadFile();
    }


    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder();

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                   line = changeHamletToLeon(line);

                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    private void writeFileToTxt(String string){

    }

    public String getHamletData(){
        return hamletData;
    }


    public void setDataFile(String string){
        //this.dataFile = string;
        loadFile();
    }

    public String changeHamletToLeon(String string) {
        Matcher matcher = patternHamlet.matcher(string);
        return matcher.replaceAll("Leon");
    }

    public String changeHoratioToTariq(String string) {
        Matcher matcher = patternHoratio.matcher(string);
        return matcher.replaceAll("Tariq");
    }
}

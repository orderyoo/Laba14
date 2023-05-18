import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ReaderKodeFromFile("Kode.txt");
    }
    public static void ReaderKodeFromFile(String nameFile){
        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile)); BufferedWriter writer = new BufferedWriter(new FileWriter("newKode.txt"))){
            String line;
            Pattern pattern = Pattern.compile("//.*|/\\*.*?\\*/|/\\*|\\*/");
            Pattern pattern1 = Pattern.compile("\\w*");
            boolean count = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Matcher matcher = pattern.matcher(line);
                Matcher matcher1 = pattern1.matcher(line);
                if(line.equals("/*")){
                    count = true;
                }
                if(line.equals("*/")){
                    count = false;
                }
                if(count){
                    line = matcher1.replaceAll("");
                }
                if(!count){
                    line = matcher.replaceAll("");
                    writer.write(line );
                    writer.newLine();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

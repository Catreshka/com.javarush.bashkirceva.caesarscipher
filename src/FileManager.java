import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    public List<String> readFile(String inputFile) {

        try {
            List<String> lineFromFile = Files.readAllLines(Paths.get(inputFile));
            return lineFromFile;
        } catch (IOException e) {
            System.out.println("Возникла ошибка при чтении файла");
            throw new RuntimeException(e);
        }
    }

    public void writeFile(String outputFile, List<String> lineFromFile) {

        try {
            Files.write(Paths.get(outputFile), lineFromFile);
        } catch (IOException e) {
            System.out.println("Возникла ошибка при записи в файл");
            throw new RuntimeException(e);
        }
    }

    public String outputFilePath(String inputFile,int key) {
        String inputFileDirectory = Paths.get(inputFile).getParent().toString();
        String outputFile = inputFile.substring(inputFile.lastIndexOf('/'),inputFile.lastIndexOf('.')) + key +".txt";
        return inputFileDirectory+outputFile;
    }
}

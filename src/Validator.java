import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Validator {

    public boolean checkFileExists(String inputFile) {
        return Files.exists(Paths.get(inputFile));
    }

    public boolean checkFileNoEmpty(String inputFile) {
        File file = new File(inputFile);
        if (file.length()==0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkExtensionFile(String inputFile) {
        if (inputFile.substring(inputFile.length()-3).equals("txt")) {
            return true;
        }
        return false;
    }

    public boolean checkKey(Integer key, int maxValue) {
        return (key > 0) && (key < maxValue);
    }
}

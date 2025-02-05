import java.util.Scanner;

public class Main {

    private static final String INPUT_FILE_MESSAGE = "Введите путь к исходному файлу";
    private static final String INPUT_KEY_MESSAGE = "Введите ключ";
    private static final String ERROR_FILE_MESSAGE = "Error: Файла не существует/пустой/имеет неверный формат";
    private static final String ERROR_KEY_MESSAGE = "Error: Ключ за границами допустимого диапазона";
    private static final String ERROR_MENU_MESSAGE = "Error: Такого действия нет";

    public static void main(String[] args) {

        Cipher cipher = new Cipher();

        Scanner console = new Scanner(System.in);
        String inputFile;
        int key;

        while (true) {
            System.out.println("Выберите пункт меню " +
                    "\n 1 - если хотите зашифровать файл " +
                    "\n 2 - если хотите дешифровать файл " +
                    "\n 3 - использовать bruteforce для дешифровки " +
                    "\n 4 - выход");

            try {
                int menu = Integer.parseInt(console.nextLine());

                switch (menu) {
                    case 1:
                        System.out.println(INPUT_FILE_MESSAGE);
                        inputFile = console.nextLine();
                        System.out.println(INPUT_KEY_MESSAGE);
                        key = Integer.parseInt(console.nextLine());
                        if ((fileValidator(inputFile) == null)
                                && (keyValidator(key) == null)) {
                            cipher.encrypt(inputFile, key);
                        }
                        return;
                    case 2:
                        System.out.println(INPUT_FILE_MESSAGE);
                        inputFile = console.nextLine();
                        System.out.println(INPUT_KEY_MESSAGE);
                        key = Integer.parseInt(console.nextLine());
                        if ((fileValidator(inputFile) == null)
                                && (keyValidator(key) == null)) {
                            cipher.decrypt(inputFile, key);
                        }
                        return;
                    case 3:
                        System.out.println(INPUT_FILE_MESSAGE);
                        inputFile = console.nextLine();
                        if (fileValidator(inputFile) == null) {
                            cipher.bruteForce(inputFile);
                        }
                        return;
                    case 4:
                        console.close();
                        return;
                    default:
                        System.out.println(ERROR_MENU_MESSAGE);
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MENU_MESSAGE);
            }
        }
    }

    public static String fileValidator(String inputFile) {
        Validator validator = new Validator();
        if (!validator.checkFileExists(inputFile)
                || !validator.checkFileNoEmpty(inputFile)
                || !validator.checkExtensionFile(inputFile)) {
            System.out.println(ERROR_FILE_MESSAGE);
            return ERROR_FILE_MESSAGE;
        }
        return null;
    }

    public static String keyValidator(int key) {
        Validator validator = new Validator();
        if (!validator.checkKey(key, Cipher.ALPHABET_LENGTH)) {
            System.out.println(ERROR_KEY_MESSAGE);
            return ERROR_KEY_MESSAGE;
        }
        return null;
    }
}

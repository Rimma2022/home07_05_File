import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * ЗАДАНИЕ 2. Напиши программу в которой.:
         * 1. Создайте файл “1.txt” в корне проекта и запишите с помощью потока
         * вывода фразу “Миша ездит на Жигули, а Катя на Мерседес”. (Если пока
         * сложно, можно после создания файла записать фразу руками)
         * 2. Создайте в папке с проектом папку “Результат”.
         * 3. Создайте в папке Результат файл “2.txt”.
         * 4. Откройте два потока для ввода и вывода данных. Поток для ввода
         * читает информацию из файла “1.txt” массив байт.
         * 5. Преобразуйте массив байт в тип String, замените “Жигули” на “BMW”,
         * а “Мерседес” на “Рено”.
         * 6. Запишите результат п.4 в файл “2.txt
         */
        File file1 = new File("1.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        PrintWriter printWriter = null;
//        try {
//            printWriter = new PrintWriter(file1);
//            printWriter.println("Миша ездит на Жигули, а Катя на Мерседесe!");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            printWriter.close();
//        }

        String str0 = "Миша ездит на Жигули, а Катя на Мерседесe!";
        byte [] mass0 = str0.getBytes(StandardCharsets.UTF_8);
        FileOutputStream outputStream0 = null;
        try {
            outputStream0 = new FileOutputStream(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStream0.write(mass0);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String path = System.getProperty("user.dir") + File.separator + "Результат";

        File createFolder = new File(path);
        createFolder.mkdir();
        File file2 = new File(path + File.separator +"2.txt");
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        byte [] mass = new byte[0];
        try {
            inputStream = new FileInputStream(file1);
            mass = new byte[inputStream.available()];
            inputStream.read(mass);
            System.out.println(new String(mass, "UTF-8"));

            outputStream = new FileOutputStream(file2);
            outputStream.write(mass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }

        String str = new String(mass, "UTF-8");
        System.out.println(str);
        if (str.contains("Жигули") && str.contains("Мерседесe") ) {
            str= str.replaceFirst("Жигули", "BMW");
            str =str.replaceFirst("Мерседесe", "Рено");
        }
        System.out.println(str);
        byte [] mass1 = str.getBytes(StandardCharsets.UTF_8);
        FileOutputStream outputStream1 = null;
        try {
            outputStream1 = new FileOutputStream(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStream1.write(mass1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ЗАДАНИЕ 1. Пользователь с клавиатуры вводит путь к файлу. После чего
        //содержимое файла отображается на экране.

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу:");
        String str3 = bufferedReader.readLine();
        File file3 = new File(str3);
        FileInputStream inputStream3 = null;
        byte [] mass3 = new byte[0];
        try {
            inputStream3 = new FileInputStream(file3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            mass3 = new byte[inputStream3.available()];
            inputStream3.read(mass3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str33 = new String(mass3, "UTF-8");
        System.out.println(str33);

    }
}

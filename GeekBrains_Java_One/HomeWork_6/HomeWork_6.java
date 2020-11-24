package GeekBrains_Java_One.HomeWork_6;

import java.io.*;
import java.util.Scanner;

public class HomeWork_6 {

    public static void main(String[] args) {
        String filename = "text_out.txt";
        String word;

        // Задание 1 Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
        try {

            PrintStream ps1 = new PrintStream(new FileOutputStream("text1.txt", true));
            ps1.println("English is spoken practically all over the world. It is spoken as the mother tongue in Great Britain, the United States \n" +
                    "of America, Canada, Australia and New Zealand. A lot of people speak English in China, Japan, India, Africa and other \n" +
                    "countries. It is one of 6 official languages of the United Nations. It is studied as a foreign language \n");
            ps1.flush();
            ps1.close();

            PrintStream ps2 = new PrintStream(new FileOutputStream("text2.txt", true));
            ps2.println("England’s history helps to understand the present condition of English. Many English words were borrowed from \n" +
                    "the language of Angles and Saxons. Hundreds of French words came into English. These French words didn’t crowd out \n" +
                    "corresponding Anglo-Saxon words. There exist “act” and “deed”, “beautiful” and “pretty”, “form” and “shape” \n");
            ps2.flush();
            ps2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Задание 2 Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
        // потом текст из второго.
        try {
            FileOutputStream file_out = new FileOutputStream("text_out.txt");
            appendFile ("text1.txt", file_out);
            appendFile ("text2.txt", file_out);
            file_out.flush();
            file_out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Задание 3 Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле
        // (работаем только с латиницей).
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word for search: ");
        word = scanner.next();
        System.out.print("file=\"" + filename +"\"");
        if (!findWord( word, filename)) System.out.print(" not");
        System.out.println(" contains \"" + word + '\"');

        // Задание 4 Написать метод, проверяющий, есть ли указанное слово в файлах внутри папки.
        File dir = new File(".");
        File file;
        File[] lst1 = dir.listFiles();
        System.out.println("Chek word \"" + word + "\" in files of current folder:");
        for (int i = lst1.length - 1; i >= 0; i--) {
            filename = lst1[i].toString();
            file = new File(dir,filename);
            if (file.isFile()) {
                if (findWord(word,filename)) System.out.println("file \""+filename+"\" contains \""+word+"\"");
            }
        }
    }

    static void appendFile (String filename, FileOutputStream file_out) throws IOException {
        try (FileInputStream file_in = new FileInputStream(filename)) {
            int b;
            while ((b = file_in.read()) != -1) {
                file_out.write(b);
            }
        }
    }

    static boolean findWord (String word, String filename) {
        try {
            Scanner scanner = new Scanner( new FileInputStream(filename));
            while (scanner.hasNext()) {
                if (scanner.next().equals(word)) return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}

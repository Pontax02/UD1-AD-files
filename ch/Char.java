package ch;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Char {


    static void countChar(char entrada) throws IOException {
        Path path = Path.of("ch\\test.txt");
        Scanner sc = new Scanner(path);
        Long counter = 0L;
        while (sc.hasNext()){

            for( Path character : path ){
                String palabra = sc.nextLine();
                counter += palabra.chars().
                        filter(ch -> ch == entrada)
                        .count();

            }
        }
        System.out.println("El texto contiene " + counter +" caracteres " + entrada);
    }


    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Que caracter quieres contar");
        char entrada = scanner.next().charAt(0);

        countChar(entrada);

    }

}



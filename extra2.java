import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra2 {

    static String directorioTrabajo = System.getProperty("user.dir");

    static void main() {
        System.out.println(prompt());
    }

    public static String prompt() {

        Scanner sc = new Scanner(System.in);

        System.out.print("\n" + directorioTrabajo + " > ");

        return sc.next();
    }

    public static void motor(String comando) {
        String[] comandoSeparado = comando.split(" ");

        switch (comando.split(" ")[0]) {

            case "cd" -> {
                if (comandoSeparado.length == 2) {

                } else {
                    System.err.println("Argumentos invalido");
                }
            }
            case "exit" -> {
                System.out.println("[+] Saliendo...");
                System.exit(0);
            }
            default -> System.err.println("Comando invalido");
        }
    }

    public static void cd(String directorio) {
        Path dir = Paths.get(directorio);
        if (Files.isDirectory(dir)) {
            if (dir.isAbsolute()) {
                directorioTrabajo = directorio;
            } else {
                directorioTrabajo = directorioTrabajo + "/" +  directorio;
            }

        } else {
            System.err.println("No es un directorio");
        }
    }
}

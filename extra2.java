import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra2 {

    static String directorioTrabajo = System.getProperty("user.dir");

    static void main() {
        while (true) {
            motor(prompt());
        }
        // System.out.println(prompt());
    }

    public static String prompt() {

        Scanner sc = new Scanner(System.in);

        System.out.print("\n" + directorioTrabajo + " > ");

        return sc.nextLine();
    }

    public static void motor(String comando) {
        String[] comandoSeparado = comando.split(" ", 2);
        String orden = comandoSeparado[0];
        String argumentos = (comandoSeparado.length > 1) ? comandoSeparado[1] : "";

        switch (orden) {
            case "cat" -> {
                if (comandoSeparado.length == 2) {
                    cat(argumentos);
                } else {
                    System.err.println("SINTAXIS: cat <archivo>");
                }
            }

            case "ls" -> {
                if (comandoSeparado.length == 2) {
                    ls(argumentos.replace("\"", ""));
                } else if (comandoSeparado.length == 1) {
                    ls(directorioTrabajo);
                } else {
                    System.err.println("SINTAXIS: ls [directorio]");
                }
            }
            case "cd" -> {
                if (comandoSeparado.length == 2) {
                    cd(argumentos);
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

    private static void cat(String ficheiro) {
        Path f = Paths.get(ficheiro);
        if (!Files.isReadable(f)) {
            System.err.println("Arquivo non lexibel");
        } else {

        }
    }

    public static void cd(String directorio) {
        Path dir = Paths.get(directorio);
        // comprobamos primero q es un directorio
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

    public static void ls (String pathString) {
        Path dir = Path.of(pathString);
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

                for (Path archivo: stream) {

                    String linha = "";
                    Boolean isDir = false;
                    // es un directorio?
                    if (Files.isDirectory(archivo)) {
                        isDir = true;
                        linha += "d";
                    } else {
                        linha += "-";
                    }
                    // permisos d lectura?
                    if (Files.isReadable(archivo)) {
                        linha += "r";
                    } else {
                        linha += "-";
                    }
                    // permisos d escritura?
                    if (Files.isWritable(archivo)) {
                        linha += "w";
                    } else {
                        linha += "-";
                    }
                    // permisos d ejecucion
                    if (Files.isExecutable(archivo)) {
                        linha += "x";
                    } else {
                        linha += "-";
                    }
                    // nombre del archivo
                    linha += " " +  archivo.getFileName();
                    if (isDir) {
                        linha+="/";
                    }

                    System.out.println(linha);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("No es un directorio");
        }
    }
}

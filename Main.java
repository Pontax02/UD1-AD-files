import java.io.IOException;
import java.nio.file.*;


public class Main {
    public static void main(String[] args) {

        Path dir = Path.of("directorio");
        // Usar StringBuilder 100%
        StringBuilder permisos = new StringBuilder();
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir);) {
                for (Path fichero : stream) {
                    System.out.println(fichero.getFileName());
                }
            } catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }
        } else {
            System.err.println(dir.toString()+" no es un directorio");
        }
    }
    }


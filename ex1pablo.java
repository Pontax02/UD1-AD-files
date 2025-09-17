import java.io.IOException;
import java.nio.file.*;


public class ex1pablo {
    public static void main(String[] args) {

        Path dir = Path.of("C:/");
        // Usar StringBuilder 100%
        StringBuilder permisos = new StringBuilder();
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir);) {
                for (Path fichero : stream) {
                    permisos.append(Files.isDirectory(fichero) ? "d" : "-");
                    permisos.append(Files.isReadable(fichero) ? "r" : "-");
                    permisos.append(Files.isWritable(fichero) ? "w" : "-");
                    permisos.append(Files.isExecutable(fichero) ? "x" : "-");
                    permisos.append("  ");
                    permisos.append(fichero.getFileName());
                    permisos.append("\n");

                }
                System.out.println(permisos);

            } catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }



        } else {
            System.err.println(dir.toString()+" no es un directorio");
        }

    }

    }


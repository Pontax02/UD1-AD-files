import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;

public class lsr {

    static Deque<Path> stack = new ArrayDeque<>();

    static void main() {
        ls("C:\\Users\\a22ricardoadc\\Chat-Local\\backend");

        // escaneamos los directorios pendientes
        while (!stack.isEmpty()) {
            ls(stack.peek().toString());
            stack.pop();
            System.out.println(stack);
        }

    }

    public static void ls (String pathString) {
        Path dir = Path.of(pathString);
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                System.out.println("[+] Leyendo archivos de " + pathString +"...");

                for (Path archivo: stream) {

                    String linha = "";

                    // es un directorio?
                    if (Files.isDirectory(archivo)) {
                        // si es un directorio, lo añade a la pila para escanearlo despues
                        stack.addLast(archivo);
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

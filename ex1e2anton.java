import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ex1e2anton {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        // ex1("C:\\Users\\a22ricardoadc\\Downloads\\proba");

        ex2('a', "Z:\\ACCESO A DATOS\\awdakwjd.txt");


    }

    public static void ex1 (String pathString) {
        Path dir = Path.of(pathString);
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                System.out.println("[+] Leyendo archivos...");

                for (Path archivo: stream) {

                    String linha = "";

                    // es un directorio?
                    if (Files.isDirectory(archivo)) {
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


    public static int ex2 (char caracter, String archivo) throws IOException {
        int contador = 0;

        String contenido = Files.readString(Path.of(archivo));
        System.out.println(contenido);

        for (int i = 0; i<contenido.length(); i++) {
            if (contenido.charAt(i) == caracter) {
                contador++;
            }
        }

        System.out.println("Hay " + contador + " " + caracter+ " en este texto");
        return contador;
    }

    public static void ex3 (String ruta) throws IOException {

        Stream<String> linhas = Files.lines(Path.of(ruta))
                .sorted();



    }

}
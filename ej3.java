import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


/*ascendente case-sensitive, ascendente-case-insensitive, descendente case-sensitive, descendente case-insensitive)*/

public static void ex3 (String archivo, int order) throws IOException {
    Path archivoo = Path.of(archivo);

    if(!Files.isReadable(archivoo)){
        System.out.println("No se encontro el archivo");
        System.exit(0);
    }
    else if(!Files.exists(archivoo)){System.out.println("No existe el archivo "+archivo);}
    else{
        Stream<String> lines = Files.lines(archivoo);
        List<String> datos = new ArrayList<String>();
        String tipo = "";
        switch (order) {
            case 1:
               datos = lines.sorted().toList();
               tipo = "ascendente case-sensitive";
                break;
            case 2:
                datos =lines.sorted(String :: compareToIgnoreCase).toList();
                tipo = "ascendente case-insensitive";
                break;
            case 3:
                datos =lines.sorted(Comparator.reverseOrder()).toList();
                tipo = "descendente case-sensitive";
                break;
            case 4:
                datos =lines.sorted(String :: compareToIgnoreCase).sorted(Comparator.reverseOrder()).toList();
                tipo = "descendente case-insensitive";
                break;
                default:
                    System.out.println("Opcion no valida");
                    break;

        }
        String datosFinal = String.join("\n", datos);

            Files.writeString(Paths.get("salida" + tipo),datosFinal);



    }

}

void main() throws IOException {

    System.out.println("pasame el archivo");
    Scanner sc = new Scanner(System.in);
    String archivo = sc.nextLine();
    System.out.println("pasame el tipo de orden");
    int scint = sc.nextInt();



    ex3(archivo,scint);
}
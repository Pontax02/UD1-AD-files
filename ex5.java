import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ex5 {
    public static void main(String[] args) throws IOException {

        ex5("/media/TEIS/a22ricardoadc/Persoal a22ricardoadc/ACCESO A DATOS/no se q hay q hacer/untitled/src/coches");;


    }

    public static void ex5(String ruta) throws IOException {
        Map<String,String> coches = new HashMap<>();

        Path path = Paths.get(ruta);

        if (!Files.exists(path)) {
            System.out.println("No existe el archivo");
            System.exit(1);
        }

        // leemos archivo x lineas
        List<String> lines = Files.lines(path).toList();

        // recorremos la lista
        for (String line : lines) {
            // hacemos esto pa q no haya espacios en blanco
            if (!line.isEmpty()) {

                String marca = line.split(" ")[0];
                String modelo =  line.substring(line.indexOf(" ")+1);
                // System.out.println(modelo);

                // si la marca NO esta registrada en el mapa de coches, la registramos con su modelo
                if (!coches.containsKey(modelo)) {
                    coches.put(modelo,marca);
                } else {
                    // si esta registrada, añadimos el modelo a la lista q es un string
                    // ESTO NO VA HAY Q ARREGLARLO UN CHIN
                    coches.put(modelo,coches.get(modelo) + " " +marca);
                }


            }
        }
        System.out.println("Coches: " + coches);
    }
}

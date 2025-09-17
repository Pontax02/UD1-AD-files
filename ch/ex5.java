package ch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ex5 {
    public static void main(String[] args) throws IOException {


        Map<String,String> coches = new HashMap<>();

        Path path = Paths.get("Z:\\ACCESO A DATOS\\no se q hay q hacer\\untitled\\src\\coches ");

        if (!Files.exists(path)) {
            System.out.println("No existe el archivo");
        }
        else {

            Stream<String> lines = Files.lines(path);


        }

    }




}

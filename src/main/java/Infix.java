import java.awt.*;
import java.io.*;
import java.util.ArrayList;
public class Infix {

    public String data="";
    
    public String Getfile(){

        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setFile("*.txt"); // Solo permite que se seleccionen archivos .txt
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String dir = dialog.getDirectory() + dialog.getFile(); // Obtiene el directorio del archivo seleccionado

        return dir;
    }

    public void NotFound(File file){
        if (!file.exists()) {  // Si por alguna razón el archivo ya no está disponible finaliza la ejecución del programa
            System.out.println("Archivo especificado no está disponible");
            System.exit(0);
        }
    }

    public ArrayList<String> Reader(String dir) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader(dir)); // Lee el archivo
        ArrayList<String> data = new ArrayList<>();
        String line = buffer.readLine();

        while (line != null) { // Cada línea del archivo la agrega al arraylist de datos
            data.add(line);
            line = buffer.readLine();
        }
        System.out.println("Funciona");
        return data;
    }


}

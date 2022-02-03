import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculadora(); // Creación de objeto calculadora
        ArrayList<String> operations = getOperations(); // Obtiene las operaciones contenidas en el archivo

        for (String operation: operations) { // Itera el archivo de operaciones
            if (!operation.trim().isEmpty()) { // Verifica que la línea del txt no venga vacía

                try {
                    Double result = calculator.calculate(operation); // Calcula el resultado de la operación
                    System.out.println("Operación: " + operation + "\t Resultado: " + String.valueOf(result)); // Imprime la operación y su resultado
                } catch (Exception e) {
                    System.out.println("Operación: " + operation + "\t Operación inválida." + "\t ERROR: " + e.getMessage());
                }
            }
        }

        System.exit(0); // Termina la ejecución del programa
    }

    /**
     * Raises a file dialog to choose a txt file and returns it's content into an arraylist
     * @return
     */
    public static ArrayList<String> getOperations() {
        // Creación de file dialog para seleccionar archivo
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setFile("*.txt"); // Solo permite que se seleccionen archivos .txt
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String dir = dialog.getDirectory() + dialog.getFile(); // Obtiene el directorio del archivo seleccionado

        try {
            File file = new File(dir);

            if (!file.exists()) {  // Si por alguna razón el archivo ya no está disponible finaliza la ejecución del programa
                System.out.println("Archivo especificado no está disponible");
                System.exit(0);
            }

            try {
                BufferedReader buffer = new BufferedReader(new FileReader(dir)); // Lee el archivo
                ArrayList<String> data = new ArrayList<>();
                String line = buffer.readLine();

                while (line != null) { // Cada línea del archivo la agrega al arraylist de datos
                    data.add(line);
                    line = buffer.readLine();
                }

                return data;
            } catch (FileNotFoundException fnte) {
                fnte.printStackTrace();
                return null;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

}

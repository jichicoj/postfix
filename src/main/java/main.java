import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculadora();
        ArrayList<String> operations = getOperations();

        for (String operation: operations) {
            if (!operation.isEmpty()) {
                Double result = calculator.calculate(operation);
                if (result == 7777777777777.7777777777777) {
                    System.out.println("Operación: " + operation + "\t INVÁLIDA. División entre 0");
                }  else {
                    System.out.println("Operación: " + operation + "\t Resultado: " + String.valueOf(result));
                }
            }
        }

        System.exit(1);
    }

    /**
     *
     * @return
     */
    public static ArrayList<String> getOperations() {
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String dir = dialog.getDirectory() + dialog.getFile();
        System.out.println(dir);

        try {
            File file = new File(dir);

            if (!file.exists()) {
                file.createNewFile();
            }

            try {
                BufferedReader buffer = new BufferedReader(new FileReader(dir));
                ArrayList<String> data = new ArrayList<>();
                String line = buffer.readLine();

                while (line != null) {
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

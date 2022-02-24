import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static Infix infix = new Infix();

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in); // Variable que obtiene le input
        boolean exit = false; // Variable de control para salir del menú
        int option = 0;
        Calculator calculator = null;

        while (!exit) {
            System.out.println("Ingrese el tipo de stack que desea utilizar. \n1. Vector" +
                    "\n2. ArrayList \n3. List \n4. Salir");
            option = Integer.parseInt(getNumber(keyboard));

            // Menú
            switch (option) {
                case 1:
                    calculator = Calculadora.getInstance("V", "N"); // Creación de objeto calculadora
                    calculate(calculator);
                    break;
                case 2:
                    calculator = Calculadora.getInstance("A", "N"); // Creación de objeto calculadora
                    calculate(calculator);
                    break;
                case 3:
                    System.out.println("Ingrese el tipo de lista que desea utilizar. \n1. Simplemente enlazada" +
                            "\n2. Doblemente enlazada");
                    int op2 = Integer.parseInt(getNumber(keyboard));
                    boolean done = false;

                    while (!done) {
                        switch (op2) {
                            case 1:
                                calculator = Calculadora.getInstance("L", "S"); // Creación de objeto calculadora
                                done = true;
                                break;
                            case 2:
                                calculator = Calculadora.getInstance("L", "D"); // Creación de objeto calculadora
                                done = true;
                                break;
                            default:
                                System.out.println("La opción ingresadad no está definida.");
                        }
                    }

                    calculate(calculator);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("La opción ingresadad no está definida.");
            }
        }
        System.exit(0);
    }

    public static void calculate(Calculator calculator) {
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
    }

    /**
     * @param keyboard
     * @return
     */
    public static String getNumber(Scanner keyboard) {
        String number = keyboard.nextLine(); // Obtiene el input
        boolean isNumber = false;

        while (!isNumber) { // Vuelve a pedir input hasta que este sea un número
            try {
                int nm = Integer.parseInt(number); // Verifica que el input sea un número
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return number;
    }

    /**
     * Raises a file dialog to choose a txt file and returns it's content into an arraylist
     * @return
     */
    public static ArrayList<String> getOperations() {
        // Creación de file dialog para seleccionar archivo

        String dir = infix.Getfile(); // Obtiene el directorio del archivo seleccionado

        try {
            File file = new File(dir);

            infix.NotFound(file);

            try {
                ArrayList<String> data = infix.Reader(dir);
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

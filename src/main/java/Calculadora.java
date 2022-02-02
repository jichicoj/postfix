import java.util.Vector;
import java.util.regex.Pattern;

/**
 * @author Joshua y Cindy
 */
public class Calculadora implements Calculator {
  /**
   * Calculates an entire operation.
   *
   * @param operation String containing the operation to be calculated.
   * @return double with the result of the operation
   */
  @Override
  public double calculate(String operation) {
    Stack<String> stack = new StackVector<String>(); // Creación del stack
    double result = 0 ;

    StringBuilder stringBuilder = new StringBuilder(operation);
    operation = stringBuilder.reverse().toString(); // Invertir la operación para tener hasta arriba del stack los operandos

    for (char op: operation.toCharArray()) { // Separar la cadena por espacio y los caracteres agregarlos al stack
      switch (op) {
        case ' ':
          break;
        default:
          stack.add(String.valueOf(op));
      }
    }

    while (stack.size() > 1) { // Hacer operaciones mientras la stack tenga más de un espacio lleno
      Vector<Double> operands = new Vector<Double>(); // Vector que almacenará operandos
      boolean operatorYet = false; // Se utiliza para dejar de buscar operandos al encontrar un operador
      String operator = "";

      while(!operatorYet) { // Se repetie mientras no encuentre un operador
        String element = stack.remove(); // Obtiene el último elemento de la pila

        try {
          operands.add(Double.parseDouble(element)); // Si es un número se agrega al stack
        } catch (Exception e) {
          operator = element; // Si no es un número se denomina operador y se detiene el ciclo
          operatorYet = true;
        }
      }

      double op1 = operands.remove(operands.size() - 1); // Toma el primer operando
      double op2 = operands.remove(operands.size() - 1); // Toma el segundo operando
      result = execOperation(op1, op2, operator); // Ejecuta la operación

      if (result == 7777777777777.7777777777777) {
        break;
      }

      stack.add(String.valueOf(result)); // Agrega el resultado de la operación al stack

      for (int i = (operands.size() - 1); i >= 0; i--) { // Si había más operandos antes de la operación ejecutada antes, los va devolviendo al stack
        stack.add(String.valueOf(operands.remove(i)));
      }
    }
    
    return result;
  }

  /**
   * Executes the operation depending on which operator was sent
   * @param op1
   * @param op2
   * @param operator
   * @return
   */
  public Double execOperation(Double op1, Double op2, String operator) {
    switch (operator) { // Realiza la operación dependiendo del operador enviado
      case "+":
        return op1 + op2;
      case "-":
        return op2 - op1;
      case "*":
        return op1 * op2;
      case "/":
        if (op1 != 0) {
          return op2 / op1;
        } else {
          return 7777777777777.7777777777777;
        }
      default:
        return null;
    }
  }
}
 
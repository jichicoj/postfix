import Stack.Stack;
import Stack.StackFactory;
import java.util.Vector;

public class Calculadora implements Calculator {
  private static Calculadora calculadora = null;
  private static String sType = "";
  private static String lType = "";
  /**
   * Constructor
   */
  private Calculadora() {}

  public static Calculadora getInstance(String sType, String lType) {
    if (calculadora == null) {
      calculadora = new Calculadora();
      Calculadora.sType = sType;
      Calculadora.lType = lType;
    }

    return calculadora;
  }

  /**
   * Calculates an entire operation.
   *
   * @param operation String containing the operation to be calculated.
   * @return double with the result of the operation
   */
  @Override
  public double calculate(String operation) throws Exception {
    StackFactory<String> stackFactory = new StackFactory<String>();
    Stack<String> stack;
    stack = stackFactory.getStack(sType, lType); // Creación del stack

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

      switch (operator) { // Realiza la operación dependiendo del operador enviado
        case "+":
          result = op1 + op2;
          break;
        case "-":
          result = op2 - op1;
          break;
        case "*":
          result = op1 * op2;
          break;
        case "/":
          if (op1 == 0) throw new ArithmeticException("Division by 0"); // Si se intenta la división entre 0 arroja una excepción

          result = op2 / op1;
          break;
      }

      stack.add(String.valueOf(result)); // Agrega el resultado de la operación al stack

      for (int i = (operands.size() - 1); i >= 0; i--) { // Si había más operandos antes de la operación ejecutada antes, los va devolviendo al stack
        stack.add(String.valueOf(operands.remove(i)));
      }
    }
    
    return result;
  }
}
 
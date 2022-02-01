import java.util.Vector;

/**
 * @author cindy
 * probado con el main
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
    Stack<String> stack = new StackVector<String>();
    double result = 0 ;

    StringBuilder stringBuilder = new StringBuilder(operation);
    operation = stringBuilder.reverse().toString();

    for (char op: operation.toCharArray()) {
      switch (op) {
        case ' ':
          break;
        default:
          stack.add(String.valueOf(op));
      }
    }

    while (stack.size() > 1) {
      Vector<Double> operands = new Vector<Double>();
      boolean operatorYet = false;
      String operator = "";

      while(!operatorYet) {
        String element = stack.remove();

        try {
          operands.add(Double.parseDouble(element));
        } catch (Exception e) {
          operator = element;
          operatorYet = true;
        }
      }

      double op1 = operands.remove(operands.size() - 1);
      double op2 = operands.remove(operands.size() - 1);
      result = execOperation(op1, op2, operator);
      stack.add(String.valueOf(result));

      for (int i = (operands.size() - 1); i >= 0; i--) {
        stack.add(String.valueOf(operands.remove(i)));
      }
    }
    
    return result;
  }

  public Double execOperation(Double op1, Double op2, String operator) {
    switch (operator) {
      case "+":
        return op1 + op2;
      case "-":
        return op2 - op1;
      case "*":
        return op1 * op2;
      case "/":
        return op2 / op1;
      default:
        return null;
    }
  }
}
 
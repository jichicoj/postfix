
/**
 *
 * @author cindy
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calculadora {
    String operation;
    
    public double calculate (String operation){
        Scanner in= new Scanner(System.in);
 
        String infija=JOptionPane.showInputDialog(null,"Introduzca operacion infija");//Se le pide al usuario que introduzca una operacion
        String postfija= Convertidor.convertirApostfija(infija);//Aqui el programa convierte la operacion a posfija

        JOptionPane.showMessageDialog(null,"La operación infija es: "+infija+
         "\nExpresion en notación postfija: "+postfija);//Aqui se imprime la operacion en posfija
        
        
        return 0;
        
    }
    
           
    
}
 
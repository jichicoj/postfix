import java.util.Vector;

public class Pila implements Stack{

    private Vector v1= new Vector<>();


    public void add(Object item){

        v1.add(item);
        for (int i=0;i<v1.size();i++){
            System.out.println(v1.get(i)+"Vector");
        }

    };

    /**
     * If the Stack is not empty, the most recent item will be removed and returned.
     * @return Item
     */
    public Object remove(){
        Object x=v1.get(v1.size()-1);
        v1.remove(v1.size()-1);
        return x;

    };

    /**
     * Get the current Item on the Stack (without popping it).
     * @return Item
     */
    public Object peek(){


        return v1.get(v1.size()-1);

    };

    /**
     * Check if the Stack is empty.
     * @return Boolean indicating if the Stack is empty
     */
    public boolean empty(){
        boolean vacio=false;
        if(v1.size()==0){
            vacio=true;
        }
        return vacio;
    };

    /**
     * Get the size of the Stack.
     * @return Integer indicating the size of the Stack
     */
    public int size(){
        
        return v1.size();
    };

    public Double parseD(Object X){
        Double y=Double.parseDouble(X.toString());
        return y;
    }

    
}

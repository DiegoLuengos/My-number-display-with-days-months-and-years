
/**
 * Write a description of class NumberDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    // El valor almacenado.
    private int value;
    // El límite al que puede no llegar el valor.
    private int limit;
    /**
     * Constructor for objects of class NumberDisplay
     */
    public NumberDisplay(int newLimit)
    {
        value = 0;
        limit = newLimit;
    }
    
    /**
     * Fija el valor del atributo valor a uno dado.
     */
    public void setValue(int newValue)
    {
        if ((newValue < limit) && (newValue >=0)) {
            value = newValue;
        }
    }
    
    /**
     * Devuelve una cadena de 2 caracteres con el
     * valor de un atributo value.
     */
    public String getDisplayValue()
    {
        String returnedValue = "";
        
        if (value < 10) {
            returnedValue = "0" + value;
        }
        else {
            returnedValue = "" + value;
        }
        
        return returnedValue;
    }
    
    /**
     * Devuelve el valor actual del atributo value.
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Incrementa en 1 el valor de value y lo hace volver a 0
     * si alcanza el límite.
     */
    public void increment()
    {
        value = value + 1;
        if (value == limit) {
            value = 0;
        }
    }
}

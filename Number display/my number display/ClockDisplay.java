
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // Un objeto NumberDisplay que guarda la hora.
    private NumberDisplay hours;
    // Un objeto NumberDisplay que nos guarda los minutos.
    private NumberDisplay minutes;
    // Un String de 5 caracteres: la hora, dos puntos y los minutos.
    private String displayString;

    /**
     * Constructor for objects of class ClockDisplay
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }
    /**
     * Constructor que crea un reloj con las horas y los minutos dados.
     */
    public ClockDisplay(int newHours, int newMinutes)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        hours.setValue(newHours);
        minutes.setValue(newMinutes);
        updateDisplay();
    }
    /**
     * Fija una nueva hora a partir de las horas y minutos dados.
     */
    public void setTime(int actualHours, int actualMinutes)
    {
        hours.setValue(actualHours);
        minutes.setValue(actualMinutes);
        updateDisplay();
    }
    /**
     * Devuelve una cadena de 5 caracteres con la hora y los minutos
     * separados por dos puntos.
     */
    public String getTime()
    { 
        return displayString;
    }
    
    /**
     * Método que hace avanzar la hora un minuto.
     */
    public void timeTick()
    {
        minutes.increment();
        if (minutes.getValue() == 0){
            hours.increment();
        }
        updateDisplay();
    }
    /**
     * Actualiza el atributo displayString.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
        if (hours.getValue() < 12){
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "am";
            if (hours.getValue() == 0){
                displayString = 12 + ":" + minutes.getDisplayValue() + "am";
            }
        }
        else if (hours.getValue() == 12){
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "pm";
            }
        
        else{
            int otherHours = hours.getValue() -12;
            displayString = otherHours + ":" + minutes.getDisplayValue() + "pm";
            }  
    }

}

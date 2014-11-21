
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
    // Un objeto NumberDisplay que nos guarda el dia.
    private NumberDisplay days;
    //Un objeto NumberDisplay que nos guarda los meses.
    private NumberDisplay months;
    //Un objeto NumberDisplay que nos guarda los años.
    private NumberDisplay years;
    // Un String de 16 caracteres: la hora, dos puntos, los minutos y los días, barra, los meses, barra, los años.
    private String displayString;

    /**
     * Constructor for objects of class ClockDisplay
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        days = new NumberDisplay(30);
        months = new NumberDisplay(12);
        years = new NumberDisplay(99);
        updateDisplay();
    }
    /**
     * Constructor que crea un reloj con las horas, los minutos, los días, los meses y los años dados.
     */
    public ClockDisplay(int newHours, int newMinutes, int newDays, int newMonths, int newYears)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        days = new NumberDisplay(31);
        months = new NumberDisplay(13);
        years = new NumberDisplay(100);
        hours.setValue(newHours);
        minutes.setValue(newMinutes);
        days.setValue(newDays);
        months.setValue(newMonths);
        years.setValue(newYears);
        updateDisplay();
    }
    /**
     * Fija una nueva hora y fecha a partir de las horas, minutos, días, meses y años dados.
     */
    public void setTime(int actualHours, int actualMinutes, int actualDays, int actualMonths, int actualYears)
    {
        hours.setValue(actualHours);
        minutes.setValue(actualMinutes);
        days.setValue(actualDays);
        months.setValue(actualMonths);
        years.setValue(actualYears);
        updateDisplay();
    }
    /**
     * Devuelve una cadena de 16 caracteres con la hora y los minutos separados por dos puntos
     * y los días, los meses y los años separados por barras.
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
            if (hours.getValue() == 0){
                days.increment();
                if (days.getValue() ==0 ){
                    days.increment();
                    months.increment();
                    if (months.getValue() == 0){
                        months.increment();
                        years.increment();
                    }
            }
        }
        updateDisplay();
    }
    }
    /**
     * Actualiza el atributo displayString.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " " + days.getDisplayValue() + "/" + months.getDisplayValue() + "/" + years.getDisplayValue();
        if (hours.getValue() < 12){
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " "  + "am"  + " " + days.getDisplayValue() + "/" + months.getDisplayValue() + "/" + years.getDisplayValue();
            if (hours.getValue() == 0){
                displayString = 12 + ":" + minutes.getDisplayValue() + "am" + " " + days.getDisplayValue() + "/" + months.getDisplayValue() + "/" + years.getDisplayValue();;
            }
        }
        else if (hours.getValue() == 12){
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "pm" + " " + days.getDisplayValue() + "/" + months.getDisplayValue() + "/" + years.getDisplayValue();
            }
        
        else{
            int otherHours = hours.getValue() -12;
            displayString = otherHours + ":" + minutes.getDisplayValue() + "pm" + " "  + days.getDisplayValue() + "/" + months.getDisplayValue() + "/" + years.getDisplayValue();
            }  
    }

}

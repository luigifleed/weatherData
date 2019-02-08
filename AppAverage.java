/**
 * Jesus Antonio Gonzalez Quevedo   a00399890
 * Juan Manuel Gonzalez Calleros    Design and Software Architecture
 */
import java.util.Calendar;

public class AppAverage implements Observer {
    // Definition of constants
    private final float DEFAULT_TEMPERATURE = 30f;

    // Definition of variables
    private WeatherData weatherdata;
    private float maxTemperature;
    private float minTemperature;
    private int timesUpdated;
    private Calendar dateOfUpdate;

    /**
     * Class creation method. Initializes the values to their default value.
     * The Calendar is initialized to be the current Calendar value.
     */
    public AppAverage(){
        this.weatherdata = new WeatherData();
        this.maxTemperature = DEFAULT_TEMPERATURE;
        this.minTemperature = DEFAULT_TEMPERATURE;
        this.timesUpdated = 0;
        this.dateOfUpdate = Calendar.getInstance();
    }

    /**
     * Required by Interface Observer.
     * Uses the temperature obtained from WeatherData to calculate the
     *  average temperature per month basis.
     */
    public void update(){
        // Every time the month changes, the current values are reset.
        resetIfNewMonth();

        // Updates the values if the temperature is higher or lower than the
        //  previous values.
        float currentTemperature = weatherdata.getTemperature();
        if (currentTemperature > maxTemperature)
            maxTemperature = currentTemperature;
        else if (currentTemperature < minTemperature)
            minTemperature = currentTemperature;
        
        // Prints the values used.
        timesUpdated ++;
        display();
    }

    /**
     * Verifies if a new Month is ocurring based on the date of updating.
     * If a new Month is present, all values are reset.
     */
    private boolean resetIfNewMonth(){
        // Definition of variables
        Calendar currentDate;

        // Initialization of variables
        currentDate = Calendar.getInstance();

        // Resets the values for the averages if a new Month is present.
        if (dateOfUpdate.get(Calendar.MONTH) != currentDate.get(Calendar.MONTH)){
            this.maxTemperature = DEFAULT_TEMPERATURE;
            this.minTemperature = DEFAULT_TEMPERATURE;
            this.timesUpdated = 0;
            this.dateOfUpdate = currentDate;
            return true;
        } else
            return false;
    }

    /**
     * Basic printing to the terminal of the values and the average.
     */
    private void display(){
        System.out.printf("Average: %f\n", (maxTemperature + minTemperature)/2 );
        System.out.printf("Maximum: %f\n", maxTemperature);
        System.out.printf("Minimum: %f\n", minTemperature);
        System.out.printf("Data updated %d times.\n", timesUpdated);
    }
}
public class AppAverage implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherdata;

    public AppAverage(WeatherData weatherdata){
        this.weatherdata = weatherdata;
        weatherdata.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure){
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp)
            maxTemp = temp;

        if (temp < minTemp)
            minTemp = temp;

        display();
    }

    public void display(){
        System.out.println("Avg/Max/Min Temperature = " + (tempSum/numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}

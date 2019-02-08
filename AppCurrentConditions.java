public class AppCurrentConditions implements Observer, DisplayElement {
    
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public AppCurrentConditions(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver (this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + 
                            "F degrees, " + humidity + "% humidity, and " + 
                            pressure + "pressure");
    }
}
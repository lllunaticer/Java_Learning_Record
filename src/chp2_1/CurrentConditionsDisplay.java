package chp2_1;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData w){
        weatherData = w;
        weatherData.registerObserver(this);
    }

    public void update(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("temperature: " + temperature + "degree, humidity: " + humidity + "%");
    }
}

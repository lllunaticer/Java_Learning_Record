package chp2_2;
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer{
    private float temperature;
    private float humidity;
    private Observable observable;

    public CurrentConditionDisplay(WeatherData o){
        observable = o;
        observable.addObserver(this);

    }

    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display(){
        System.out.println("Temperature: "+temperature+" degrees, Humidity:"+humidity+" %");
    }
}

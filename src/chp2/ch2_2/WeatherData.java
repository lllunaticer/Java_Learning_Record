package chp2.ch2_2;

import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable{
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){}
    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getTemperature() {
        return temperature;
    }
}

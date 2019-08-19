package chp2_1;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObserver() {
        for(Observer o:observers)
            o.update(temperature, humidity, pressure);
    }

    public void messureChanged(){
        notifyObserver();
    }

    public void setChange(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        messureChanged();
    }
}

package chp2.ch2_1;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList observers;
    private float temparature;
    private float humiduty;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>0) observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(temparature, humiduty, pressure);
        }
    }

    public void messurementChanged(){
        notifyObserver();
    }

    public void setMessurements(float temparature, float humiduty, float pressure){
        this.temparature= temparature;
        this.humiduty = humiduty;
        this.pressure = pressure;
        messurementChanged();
    }
}

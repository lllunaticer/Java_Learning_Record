package chp2.ch2_1;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private Subject WeatherDate;

    public CurrentConditionsDisplay(Subject weatherDate){
        this.WeatherDate = weatherDate;
        weatherDate.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("Current conditions:"+temperature
        +"F degree and " + humidity + "% humidity");
    }
}

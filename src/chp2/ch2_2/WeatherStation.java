package chp2.ch2_2;


public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(82,70 ,29.2f);
        weatherData.setMeasurements(82,70 ,29.2f );
        weatherData.setMeasurements(78, 90,29.2f );
    }

}

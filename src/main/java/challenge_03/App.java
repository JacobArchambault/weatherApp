package challenge_03;

import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static double toFarenheit(double celsius) {
        return (celsius * 9.0/5) + 32.0; // convert celsius to farenheit
    };
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("weather_report", "UTF-8");
        Weather todaysWeather = new Weather();
        writer.printf("The wind is blowing " + todaysWeather.windDirection + " at " + todaysWeather.windSpeed + " meters per second. \n");
        writer.printf("Today's temperature is " + toFarenheit(todaysWeather.temperature) + " degrees Fahrenheit. You can expect " + todaysWeather.visibilityDistance + " visibility. Humidity is " +todaysWeather.humidity + ". Precipitation is " + todaysWeather.precipitationRate);
        writer.close();

    }
}

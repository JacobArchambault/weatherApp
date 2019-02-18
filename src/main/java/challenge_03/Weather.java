package challenge_03;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Weather {

    public double latitude;
    public double longitude;
    public String sunrise;
    public String sunset;
    public double windSpeed;            // the wind speed in meters/second
    public String windDirection;        // the wind direction in cardinal directions
    public double apparentTemperature;  // the feels like temperature in celsius
    public double temperature;          // temperature in celsius
    public int humidity;             // in %
    public int visibilityDistance;   // in km
    public double precipitationRate;    // precipitation rate in mm/hour
    public double snowfallRate;         // snowfall rate in mm/hour



    public Weather() {
        WeatherClient client = new WeatherClient();
        String json = client.getWeather();

        JSONParser parser = new JSONParser();

        Object obj = new Object();

        try {
             obj = parser.parse(json);
        } catch (ParseException e) {
            System.out.println("Could not parse the json");
            e.printStackTrace();
        }
        JSONObject jsonObj = (JSONObject)obj;
        JSONArray arr = (JSONArray)jsonObj.get("data");
        JSONObject weatherdata = (JSONObject) arr.get(0);

        this.latitude = (Double) weatherdata.get("lat");
        this.longitude = (Double) weatherdata.get("lon");
        this.sunrise = (String) weatherdata.get("sunrise");
        this.sunset = (String) weatherdata.get("sunset");
        this.windSpeed = (Double) weatherdata.get("wind_spd");
        this.windDirection = (String) weatherdata.get("wind_cdir_full");
        this.apparentTemperature = (Double) weatherdata.get("app_temp");
        this.temperature = (Double) weatherdata.get("temp");
        this.humidity = (int) ((Long)weatherdata.get("rh")).intValue();
        this.visibilityDistance = (int) ((Long)weatherdata.get("vis")).intValue();

        if((Double)weatherdata.get("precip") != null) {
            this.precipitationRate = (Double) weatherdata.get("precip");
        } else {
            this.precipitationRate = 0;
        }

        if((Double)weatherdata.get("snow") != null) {
            this.snowfallRate = (Double) weatherdata.get("snow");
        } else {
            this.snowfallRate = 0;
        }
    }
}

package challenge_03;
import java.io.*;
import java.net.*;

import java.net.URI;

public class WeatherClient {

        public static String API_KEY = "11e2cc0b44754f488c16f678bc3075fe";
        public static String LOCATION = "Sellersburg,IN";

        public static String getWeather() {
            try {
                StringBuilder result = new StringBuilder();
                URL url = new URL(getURL());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                rd.close();
                return result.toString();
            } catch (IOException e) {
                System.out.println("error connecting");
                e.printStackTrace();
            }
            return null;
        }

    private static String getURL() {
        return new String("https://api.weatherbit.io/v2.0/current?city="+ LOCATION +"&key=" + API_KEY);
    }
}
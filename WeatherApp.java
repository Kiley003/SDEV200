//*all three weather classes to be used in java project*//

import java.net.HttpURLConnection;
import java.net.URL;
import weather
import JavaFX

public class WeatherApp {
    private static final String appName = "WeatherApp";
    private static final String version = "1.0";

    public static void main(String[] args) {
        System.out.println(appName + " - Version " + version);

        Location location = new Location("Indianapolis", "USA");

        String weatherJson = getWeatherData(location.getCity(), apiKey);

        Weather weather = new Weather(32, "Snow");

        System.out.println("Location: " + location);
        System.out.println("Weather: " + weather);
    }

    public static String getWeatherData(String city, String apiKey) {
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            return content.toString(); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;

      //*Location can vary depending on where the user is or inputs location*//
public class Location {
    private String city;
    private String country;

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() { return city; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}
    //*Weather will be given, rain, snow, icy conditions, sun, and more*//
public class Weather {
    private double temperature;
    private String condition;

    public Weather(double temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    public double getTemperature() { return temperature; }
    public String getCondition() { return condition; }

    @Override
    public String toString() {
        return condition + " at " + temperature + "°C";
    }
}

            //*test class for overall conditions*//
            public class WeatherAppTest {

    public void testLocation() {
        Location location = new Location("Salem", "USA");
        assertEquals("Salem", location.getCity());
        assertEquals("USA", location.getCountry());
        assertEquals("Salem, USA", location.toString());
    }

        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

public class CryptoWatch {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java CryptoWatch [coin_id...]");
            System.out.println("Example: java CryptoWatch bitcoin ethereum");
            return;
        }

        for (String coin : args) {
            fetchPrice(coin.toLowerCase());
        }
    }

    public static void fetchPrice(String coinId) {
        String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=" + coinId + "&vs_currencies=usd";

        try {
            URI uri = URI.create(apiUrl);
            URL url = uri.toURL();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int status = conn.getResponseCode();
            if (status != 200) {
                System.out.println("Error fetching price for " + coinId + ": HTTP " + status);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            reader.close();
            conn.disconnect();

            String json = responseBuilder.toString();
            String price = parsePriceFromJson(json, coinId);
            if (price != null) {
                System.out.println(coinId + " → $" + price + " USD");
            } else {
                System.out.println("Could not parse price for: " + coinId);
            }

        } catch (Exception e) {
            System.out.println("Failed to fetch price for " + coinId + ": " + e.getMessage());
        }
    }

    private static String parsePriceFromJson(String json, String coinId) {
        String search = "\"" + coinId + "\":{\"usd\":";
        int index = json.indexOf(search);
        if (index == -1) return null;

        int start = index + search.length();
        int end = json.indexOf("}", start);
        if (end == -1) return null;

        return json.substring(start, end);
    }
}
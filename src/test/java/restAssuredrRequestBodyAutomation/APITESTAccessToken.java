package restAssuredrRequestBodyAutomation;

import java.net.HttpURLConnection;
import java.net.URL;

public class APITESTAccessToken {
    public static void main(String[] args) throws Exception {
        // Make the API request
        try {
            // Create URL object
            String apiUrl = "https://stageapp.tekioncloud.xyz/api/wms/parts/u/inventory/withPart/search";
            URL url = new URL(apiUrl);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();

            // Check if the request was successful (status code 200)
            if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                // Extract the value of the 'Authorization' header
                String apiToken = connection.getHeaderField("Authorization");
                System.out.println("API Token: " + apiToken);
            } else {
                System.out.println("Failed to fetch API token. Status code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


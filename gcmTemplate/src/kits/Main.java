package kits;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    // This is your Google API key unique to whatever you are building.
    public static final String API_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    public static final String TOPIC = "/topics/Foo";
    public static final String DEVICE_TOKEN = "xxxxxxxx:xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    public static void main(String[] args) {
        try {
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jMessage = new JSONObject();
            JSONObject jNotification = new JSONObject();

            // Add the the actual message here
            jMessage.put("message", "Put your message here");

            // Uncomment one of these depending on if you want to use topic or device messages.
            //jGcmData.put("to", TOPIC);
            jGcmData.put("to", DEVICE_TOKEN);

            // Setup notification
            jNotification.put("title", "Notification title");
            jNotification.put("body", "Notification body");

            // Put the notification and message in the object that will be sent to gcm.
            jGcmData.put("data", jMessage);
            jGcmData.put("notification", jNotification);

            // Create connection to send GCM Message request.
            URL url = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "key=" + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Send GCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

            // Read GCM response, you need to get the input stream but don't have to use it.
            InputStream inputStream = conn.getInputStream();
            System.out.println("Check your device/emulator for notification or logcat for " + "confirmation of the receipt of the GCM message.");
        } catch (IOException e) {
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server " + "API key, and that the device's registration token is correct (if specified).");
            e.printStackTrace();
        }
    }
}

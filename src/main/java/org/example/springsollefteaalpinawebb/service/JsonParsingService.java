package org.example.springsollefteaalpinawebb.service;

import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonParsingService {

    public List<String> parseJsonString(String jsonString) {
        // Parse the JSON string into a JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // Access the 'data' array
        JSONArray dataArray = jsonObject.getJSONArray("data");

        // Create a list to store the messages
        List<String> messages = new ArrayList<>();

        // Iterate over the 'data' array
        for (int i = 0; i < dataArray.length(); i++) {
            // Get each item in the 'data' array
            JSONObject dataItem = dataArray.getJSONObject(i);

            // Check if the 'message' field exists in the item
            if (dataItem.has("message")) {
                // Access the 'message' field of the item
                String message = dataItem.getString("message");

                // Add the message to the list
                messages.add(message);
            }
        }

        // Return the list of messages
        return messages;
    }
}

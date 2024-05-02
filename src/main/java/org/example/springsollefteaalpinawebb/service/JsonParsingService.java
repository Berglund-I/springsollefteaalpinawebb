package org.example.springsollefteaalpinawebb.service;
import org.example.springsollefteaalpinawebb.model.Facebook;
import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonParsingService {

    public List<Facebook> parseJsonString(String jsonString) {
        // Parse the JSON string into a JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // Access the 'data' array
        JSONArray dataArray = jsonObject.getJSONArray("data");

        // Create a list to store the Facebook objects
        List<Facebook> facebookPosts = new ArrayList<>();

        // Iterate over the 'data' array
        for (int i = 0; i < dataArray.length(); i++) {
            // Get each item in the 'data' array
            JSONObject dataItem = dataArray.getJSONObject(i);

            // Check if the 'message', 'created_time' and 'id' fields exist in the item
            if (dataItem.has("message") && dataItem.has("created_time") && dataItem.has("id")) {
                // Access the 'message', 'created_time' and 'id' fields of the item
                String message = dataItem.getString("message");
                String createdTime = dataItem.getString("created_time");
                String idFacebook = dataItem.getString("id");

                // Create a new Facebook object
                Facebook facebookPost = new Facebook(createdTime, message, idFacebook);

                // Add the Facebook object to the list
                facebookPosts.add(facebookPost);
            }
        }

        // Return the list of Facebook objects
        return facebookPosts;
    }
}

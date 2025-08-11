package com.example.Academic.Apicontroller;

import com.example.Academic.dto.Job;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
@RestController
public class JobController {

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        String apiUrl = "https://www.arbeitnow.com/api/job-board-api";
        RestTemplate restTemplate = new RestTemplate();

        // Fetch the JSON response from the API
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        // Parse the JSON response into a Map
        Gson gson = new Gson();
        Map<String, Object> responseMap = gson.fromJson(jsonResponse, new TypeToken<Map<String, Object>>(){}.getType());

        // Check if the "data" key exists and is an array
        if (responseMap.containsKey("data") && responseMap.get("data") instanceof List) {
            List<Job> jobs = gson.fromJson(gson.toJson(responseMap.get("data")), new TypeToken<List<Job>>(){}.getType());
            return jobs;
        } else {
            throw new IllegalStateException("Unexpected JSON structure: " + jsonResponse);
        }
    }
}

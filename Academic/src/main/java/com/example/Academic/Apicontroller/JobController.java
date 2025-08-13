package com.example.Academic.Apicontroller;

import com.example.Academic.dto.Job;
import com.example.Academic.dto.JobicyResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.Map;

// importing classes as suggested bty perplexity
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import com.google.gson.JsonSyntaxException;




@RestController
public class JobController {

    @GetMapping("/jobs")
    public ResponseEntity<?> getJobs() {
        String apiUrl = "https://www.arbeitnow.com/api/job-board-api";
        RestTemplate restTemplate = new RestTemplate();

        try {
            // 1. Fetch JSON
            String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

            if (jsonResponse == null || jsonResponse.trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("API returned empty response.");
            }

            // 2. Parse into a Map
            Gson gson = new Gson();
            Map<String, Object> responseMap = gson.fromJson(
                    jsonResponse,
                    new TypeToken<Map<String, Object>>() {}.getType()
            );

            if (responseMap == null) {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                        .body("Invalid JSON structure from API.");
            }

            // 3. Validate "data"
            Object dataObj = responseMap.get("data");
            if (dataObj == null || !(dataObj instanceof List<?>)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("API JSON does not contain 'data' as a list.");
            }

            // 4. Convert to List<Job>
            List<Job> jobs = gson.fromJson(
                    gson.toJsonTree(dataObj),
                    new TypeToken<List<Job>>() {}.getType()
            );

            return ResponseEntity.ok(jobs);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching jobs: " + e.getMessage());
        }
    }


    @GetMapping("/jobs/freeJobsAPI")
    public ResponseEntity<?> getFreeJobs() {
        String apiUrl = "https://jobicy.com/api/v2/remote-jobs";
        RestTemplate restTemplate = new RestTemplate();

        try {
            String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

            if (jsonResponse == null || jsonResponse.trim().isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("API returned empty response.");
            }

            Gson gson = new Gson();
            JobicyResponse response = gson.fromJson(jsonResponse, JobicyResponse.class);

            return ResponseEntity.ok(response.getJobs());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching jobs: " + e.getMessage());
        }
    }


}

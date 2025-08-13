package com.example.Academic.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobicyResponse {
    private int jobCount;
    private List<freeJobsAPI> jobs;
}

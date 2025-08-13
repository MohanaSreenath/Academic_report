package com.example.Academic.dto;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class freeJobsAPI {

   private int id;
   private String url;

   @SerializedName("jobTitle")
   private String jobTitle;

   @SerializedName("companyName")
   private String companyName;

   @SerializedName("companyLogo")
   private String companyLogo;

   @SerializedName("jobCategory")
   private String jobCategory;

   @SerializedName("jobType")
   private List<String> jobType;

   @SerializedName("jobGeo")
   private String jobGeo;

   @SerializedName("jobLevel")
   private String jobLevel;

   @SerializedName("jobExcerpt")
   private String jobExcerpt;

   @SerializedName("jobDescription")
   private String jobDescription;

   @SerializedName("pubDate")
   private String pubDate;
}

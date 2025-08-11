package com.example.Academic.dto;


public class Job {
    String slug;
    String company_name;
    String title;
    String description;
    boolean remote;
    String url;
    String[] job_types;
    String location;

    // Getters and Setters
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getCompanyName() { return company_name; }
    public void setCompanyName(String company_name) { this.company_name = company_name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isRemote() { return remote; }
    public void setRemote(boolean remote) { this.remote = remote; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String[] getJobTypes() { return job_types; }
    public void setJobTypes(String[] job_types) { this.job_types = job_types; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}


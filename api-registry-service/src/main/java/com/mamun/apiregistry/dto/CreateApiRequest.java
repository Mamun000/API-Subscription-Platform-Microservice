package com.mamun.apiregistry.dto;


import lombok.Data;

@Data
public class CreateApiRequest {
    private String name;
    private String description;
    private String baseUrl;
    private String category;
    private Long ownerId;
}
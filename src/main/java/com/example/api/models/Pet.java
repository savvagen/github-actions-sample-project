package com.example.api.models;

import lombok.Data;

import java.util.List;

@Data
public class Pet {

    public int id;
    public String name;
    public Category category;
    public List<String> protoUrls;
    public List<Tag> tags;
    public String status;
}

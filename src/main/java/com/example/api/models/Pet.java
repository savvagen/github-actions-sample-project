package com.example.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(builderMethodName = "buildPet")
public class Pet {

    public long id;
    public String name;
    public Category category;
    public List<String> protoUrls;
    public List<Tag> tags;
    public String status;
}

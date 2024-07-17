package com.bilalberek.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRecord(
        @JsonProperty("n")
         String name,
        @JsonProperty("a")
         int age,
        @JsonProperty("e")
         String email
) {
}

package com.example.groupwork7640.api_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class VendorsDto {
    private Integer id;
    private String name;
    private Integer feedbackScore;
    private String location;
}

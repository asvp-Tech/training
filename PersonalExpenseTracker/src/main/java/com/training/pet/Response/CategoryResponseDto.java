package com.training.pet.Response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponseDto {
    private Long id;
    private String name;
    private boolean isDefault;
}


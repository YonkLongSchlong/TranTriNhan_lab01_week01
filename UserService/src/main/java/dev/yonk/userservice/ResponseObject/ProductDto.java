package dev.yonk.userservice.ResponseObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private double price;
}

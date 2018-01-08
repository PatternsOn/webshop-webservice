package com.patternson.webshopwebservice.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ArticleCommand {
    private Long id;

    @Size(min = 3, max = 100)
    private String name;

    @Min(20)
    @Max(1000)
    private String description;

    @Min(0)
    @Max(9999999)
    private BigDecimal price;

    @Min(1)
    @Max(30)
    private String company;

    @Min(0)
    @Max(99999)
    private Integer stock;
}

package com.patternson.webshopwebservice.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 *
 * Created by Tobias Pettersson 20180108
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private Long id;

    @Size(min = 2, max = 50)
    private String name;

    @Size(min = 2, max = 200)
    private String description;

    @Min(0)
    @Max(9999999)
    private BigDecimal price;

    @Size(min = 2, max = 50)
    private String company;

    @Min(0)
    @Max(9999)
    private Integer stock;

    @JsonProperty("article_url")
    private String articleUrl;
}

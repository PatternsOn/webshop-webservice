package com.patternson.webshopwebservice.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 *
 * Created by Tobias Pettersson 20180108
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private String company;
    private Integer stock;

    @JsonProperty("article_url")
    private String articleUrl;
}

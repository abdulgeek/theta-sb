package com.geekseat.theta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_shop", nullable = false)
    @JsonIgnoreProperties("additionalProductList")
    private Shop shop;

    @NotNull
    @NotEmpty
    private String slug;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @Min(0)
    @Size(max = 11)
    private Integer quantity;
}

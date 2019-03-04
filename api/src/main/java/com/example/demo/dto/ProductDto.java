package com.example.demo.dto;

import java.io.Serializable;
import java.util.Objects;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double value;

    public ProductDto() {
    }

    public ProductDto setName(String name, Double value) {
        this.name = name;
        this.value = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductDto setValue(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
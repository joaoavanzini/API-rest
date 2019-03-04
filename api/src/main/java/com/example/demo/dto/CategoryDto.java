package com.example.demo.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public CategoryDto() {
    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CategoryDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
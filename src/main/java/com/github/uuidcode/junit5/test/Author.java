package com.github.uuidcode.junit5.test;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Author {
    private String name;

    public String getName() {
        return this.name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }
}

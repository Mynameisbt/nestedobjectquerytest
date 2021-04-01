package com.mynameisbt.nestedobjectquerytest.model;

import org.springframework.data.elasticsearch.annotations.Field;

public class Author {
    @Field("FirstName")
    private String firstName;
    @Field("LastName")
    private String lastName;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

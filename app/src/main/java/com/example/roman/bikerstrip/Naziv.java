package com.example.roman.bikerstrip;

/**
 * Created by Roman on 4. 05. 2016.
 */
public class Naziv {
    private String email, name, id;

    public Naziv(String email, String name, String id) {
        this.email = email;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return email + ';' + name + ';' + id + ';';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

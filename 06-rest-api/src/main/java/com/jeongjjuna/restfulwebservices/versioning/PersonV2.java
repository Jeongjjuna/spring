package com.jeongjjuna.restfulwebservices.versioning;

public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}

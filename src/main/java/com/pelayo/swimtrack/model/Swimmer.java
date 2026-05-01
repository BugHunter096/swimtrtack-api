package com.pelayo.swimtrack.model;

public class Swimmer {
    private Long id;
    private String name;
    private String category;
    private String sex;

    public Swimmer() {
    }

    public Swimmer(Long id, String name, String category, String sex) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSex() {
        return sex;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

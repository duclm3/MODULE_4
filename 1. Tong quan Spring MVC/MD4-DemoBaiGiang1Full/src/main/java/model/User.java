package model;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
    private String name;
    private int age;
    @Autowired
    private Language language;
    public User(String name, int age, Language language) {
        this.name = name;
        this.age = age;
        this.language = language;
    }

    public User() {
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

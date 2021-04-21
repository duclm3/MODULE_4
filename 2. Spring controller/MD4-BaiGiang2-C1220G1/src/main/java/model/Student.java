package model;
public class Student {
    private int id;
    private String name;
    private String address;
    private Language language;
    public Student() {
    }

    public Student(int id,String name, String address, Language language) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.language = language;
    }
public Student (int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
}
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

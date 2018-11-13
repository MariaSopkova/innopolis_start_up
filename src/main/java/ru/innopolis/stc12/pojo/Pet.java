package ru.innopolis.stc12.pojo;

/**
 * Класс для описания полей питомца.
 */

public class Pet {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String breed;
    private String dateOfBirth;
    private String exhibition_id;
    private Integer mother_id;
    private Integer father_id;

    public Pet(int id,
               String name,
               int age,
               String gender,
               String breed,
               String dateOfBirth,
               String exibition,
               Integer mother,
               Integer father) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.exhibition_id = exibition;
        this.mother_id = mother;
        this.father_id = father;
    }

    public Pet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExhibition_id() {
        return exhibition_id;
    }

    public void setExhibition_id(String exhibition_id) {
        this.exhibition_id = exhibition_id;
    }

    public Integer getMother_id() {
        return mother_id;
    }

    public void setMother_id(Integer mother_id) {
        this.mother_id = mother_id;
    }

    public Integer getFather_id() {
        return father_id;
    }

    public void setFather_id(Integer father_id) {
        this.father_id = father_id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", exhibition_id='" + exhibition_id + '\'' +
                ", mother_id='" + mother_id + '\'' +
                ", father_id='" + father_id + '\'' +
                '}';
    }
}

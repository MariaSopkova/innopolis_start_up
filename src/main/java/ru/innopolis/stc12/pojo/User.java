package ru.innopolis.stc12.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Class models for {@link User}
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String familyName;
    private int age;
    private boolean isEnabled;
    private String gender;
    private String role;
    private String language;
    private String password;
    private String login;
    private String city;
    private int petId;
    private Date startDate;
    private Date lastEnter;
    private String email;
    private String phone;

    public User(String name,
                String familyName,
                int age,
                boolean isEnabled,
                String gender,
                String role,
                String language,
                String password,
                String login,
                String email,
                String phone,
                String city,
                int petId) {
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.isEnabled = isEnabled;
        this.gender = gender;
        this.role = role;
        this.language = language;
        this.password = password;
        this.login = login;
        this.city = city;
        this.petId = petId;
    }

    public User() {
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", isEnabled=" + isEnabled +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", language='" + language + '\'' +
                ", password=***" +
                ", login='" + login + '\'' +
                ", city='" + city + '\'' +
                ", petId=" + petId + '\'' +
                ", email=" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}

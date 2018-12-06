package ru.innopolis.stc12.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class models for {@link User}
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    private int id;
    private String name;
    private String familyName;
    private int age;
    private boolean isEnabled;
    private boolean isDeleted;
    private String gender;
    private String role;
    private String language;
    private String password;
    private String login;
    private String city;
    private int petId;
    private String avaLink;
    private String email;
    private String phone;
    private List<RoleAction> roleActions = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

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
                int petId,
                String avaLink,
                boolean isDeleted) {

        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.isEnabled = isEnabled;
        this.gender = gender;
        this.role = role;
        this.language = language;
        this.password = password;
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.petId = petId;
        this.avaLink = avaLink;
        this.isDeleted = isDeleted;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "family_name")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "is_enabled")
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "pet_id")
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ava_link")
    public String getAvaLink() {
        return avaLink;
    }

    public void setAvaLink(String avaLink) {
        this.avaLink = avaLink;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "role", updatable = false, insertable = false)
    public List<RoleAction> getRoleActions() {
        if (roleActions == null) {
            return new ArrayList<>();
        }
        return Collections.unmodifiableList(roleActions);
    }

    public void setRoleActions(List<RoleAction> roleActions) {
        this.roleActions = roleActions;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", isEnabled=" + isEnabled +
                ", isDeleted=" + isDeleted +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", language='" + language + '\'' +
                ", login='" + login + '\'' +
                ", city='" + city + '\'' +
                ", petId=" + petId + '\'' +
                ", email=" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}

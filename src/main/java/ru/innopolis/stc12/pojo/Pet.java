package ru.innopolis.stc12.pojo;

import ru.innopolis.stc12.utils.Dates;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_pets")
public class Pet implements Serializable {
    private int id;
    private String name;
    private String gender;
    private String breed;
    private String description;
    private Date dateOfBirth;
    private int motherId;
    private int fatherId;
    private User user;
    private String avaLink;

    public Pet() {
    }

    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    public int getId() {
        return id;
    }

    public Pet setId(int id) {
        this.id = id;
        return this;
    }

    @Column(name = "name", length = 30)
    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    @Transient
    public int getAge() {
        return Dates.yearsBetween(new Date(), dateOfBirth);
    }

    @Column(name = "gender", length = 10)
    public String getGender() {
        return gender;
    }

    public Pet setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Column(name = "breed", length = 30)
    public String getBreed() {
        return breed;
    }

    public Pet setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    @Column(name = "description", length = 4048)
    public String getDescription() {
        return description;
    }

    public Pet setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Pet setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Column(name = "mother_id")
    public int getMotherId() {
        return motherId;
    }

    public Pet setMotherId(int motherId) {
        this.motherId = motherId;
        return this;
    }

    @Column(name = "father_id")
    public int getFatherId() {
        return fatherId;
    }

    public Pet setFatherId(int fatherId) {
        this.fatherId = fatherId;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public Pet setUser(User user) {
        this.user = user;
        return this;
    }

    @Column(name = "ava_link")
    public String getAvaLink() {
        return avaLink;
    }

    public Pet setAvaLink(String avaLink) {
        this.avaLink = avaLink;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (id != pet.id) return false;
        if (motherId != pet.motherId) return false;
        if (fatherId != pet.fatherId) return false;
        if (name != null ? !name.equals(pet.name) : pet.name != null) return false;
        if (gender != null ? !gender.equals(pet.gender) : pet.gender != null) return false;
        if (breed != null ? !breed.equals(pet.breed) : pet.breed != null) return false;
        if (description != null ? !description.equals(pet.description) : pet.description != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(pet.dateOfBirth) : pet.dateOfBirth != null) return false;
        return user != null ? user.equals(pet.user) : pet.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + motherId;
        result = 31 * result + fatherId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }


}

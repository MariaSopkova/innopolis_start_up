package ru.innopolis.stc12.pojo;

import java.util.Date;

public class DogHandler extends User {
    public DogHandler() {
    }

    public DogHandler(String name,
                      String familyName,
                      int age,
                      boolean isEnabled,
                      String gender,
                      String role,
                      String language,
                      String password,
                      String login,
                      String city,
                      int petId,
                      Date startDate,
                      Date lastEnter) {
        super(name,
                familyName,
                age,
                isEnabled,
                gender,
                role,
                language,
                password,
                login,
                city,
                petId,
                startDate,
                lastEnter);
    }
}

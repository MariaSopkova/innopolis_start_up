package ru.innopolis.stc12.dao;

import ru.innopolis.stc12.pojo.Pet;

public interface PetDao {
    boolean persistUserPet(Pet pet, int userId);

    Pet getPet(int petId);

    void removePet(int petId);
}

package ru.innopolis.stc12.service.pet;

import ru.innopolis.stc12.pojo.Pet;

public interface PetService {
    boolean persistUserPet(Pet pet, int userId);

    Pet getPet(int petId);

    void removePet(int petId);

    void updatePet(Pet pet);
}

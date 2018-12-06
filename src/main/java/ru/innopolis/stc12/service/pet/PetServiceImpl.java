package ru.innopolis.stc12.service.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ru.innopolis.stc12.dao.PetDao;
import ru.innopolis.stc12.pojo.Pet;
import ru.innopolis.stc12.security.Actions;

@Service
public class PetServiceImpl implements PetService {
    private PetDao petDao;

    @Autowired
    public void setPetDao(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    @Secured(Actions.USER_PET_EDIT)
    public boolean persistUserPet(Pet pet, int userId) {
        return petDao.persistUserPet(pet, userId);
    }

    @Override
    @Secured(Actions.USER_PET_VIEW)
    public Pet getPet(int petId) {
        return petDao.getPet(petId);
    }

    @Override
    @Secured(Actions.USER_PET_EDIT)
    public void removePet(int petId) {
        petDao.removePet(petId);
    }
}

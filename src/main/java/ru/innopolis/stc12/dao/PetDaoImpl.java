package ru.innopolis.stc12.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc12.pojo.Pet;
import ru.innopolis.stc12.pojo.User;

@Repository
@Transactional
public class PetDaoImpl implements PetDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean persistUserPet(Pet pet, int userId) {
        Session session = sessionFactory.getCurrentSession();
        if (pet.getId() > 0) {
            pet.setUser(new User().setId(userId));
            session.merge(pet);
        } else {
            pet.setUser(session.get(User.class, userId));
            session.save(pet);
        }
        return true;
    }

    @Override
    public Pet getPet(int petId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Pet.class, petId);
    }

    @Override
    public void removePet(int petId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(new Pet().setId(petId));
    }
}

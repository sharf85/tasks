package de.telran.contacts_db.repo;

import de.telran.contacts_db.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface IContactRepo extends CrudRepository<Contact, Integer> {
    Collection<Contact> findAllByName(String name);
}

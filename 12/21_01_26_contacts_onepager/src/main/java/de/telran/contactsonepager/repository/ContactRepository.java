package de.telran.contactsonepager.repository;

import de.telran.contactsonepager.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}

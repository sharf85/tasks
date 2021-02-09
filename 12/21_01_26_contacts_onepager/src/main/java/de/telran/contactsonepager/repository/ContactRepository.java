package de.telran.contactsonepager.repository;

import de.telran.contactsonepager.model.Contact;
import de.telran.contactsonepager.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    List<Contact> findByNameIgnoreCase(String name);

    List<Contact> findAllByUser(User user);

    @Query("select c from Contact c join c.user u where u.email=?1")
    List<Contact> findAllByUserEmailManually(String userEmail);

}

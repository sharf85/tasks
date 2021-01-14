package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;

import java.util.List;

public interface IContactRepo {

    /**
     * The method save a new entity in the repository when contact.id == 0 or changes
     * the entity in case if the entity is already present in the repo (contact.id > 0)
     * Also the method is responsible to allocate an id to the persistent entity.
     *
     * @param contact
     */
    void save(Contact contact);

    /**
     * @param id the uniq id of a contact
     * @return found contact or null otherwise
     */
    Contact find(int id);

    /**
     *
     * @param id
     * @return removed contact or null if not found
     */
    Contact remove(int id);

    /**
     *
     * @return a list with all present contacts
     */
    List<Contact> findAll();
}

package de.telran.contacts.repository;

import de.telran.contacts.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryContactRepoTest {

    MemoryContactRepo contactRepo;

    @BeforeEach
    public void init() {
        contactRepo = new MemoryContactRepo();
    }

    @Test
    public void testGetAll_noElements_emptyList() {
        assertEquals(0, contactRepo.getAll().size());
    }

    @Test
    public void testAddAndGet_oneElement_listWithOneContact() {
        Contact vasya = new Contact("Vasya", "123");
        contactRepo.add(vasya);

        List<Contact> contacts = contactRepo.getAll();
        assertEquals(1, contacts.size());

        Contact fromRepo = contacts.get(0);
        assertEquals(vasya.name, fromRepo.name);
        assertEquals(vasya.number, fromRepo.number);

    }

    @Test
    public void testAddAndGet_threeContacts_threeContacts() {
        Contact vasya = new Contact("Vasya", "123");
        Contact petya = new Contact("Petya", "1234");
        Contact masha = new Contact("Masha", "321");
        contactRepo.add(vasya);
        contactRepo.add(masha);
        contactRepo.add(petya);

        List<Contact> contacts = contactRepo.getAll();
        assertEquals(3, contacts.size());

        Contact vasyaFromRepo = contacts.stream().filter(contact -> contact.id == vasya.id).findFirst().get();
        Contact petyaFromRepo = contacts.stream().filter(contact -> contact.id == petya.id).findFirst().get();
        Contact mashaFromRepo = contacts.stream().filter(contact -> contact.id == masha.id).findFirst().get();

        assertEquals(vasya.name, vasyaFromRepo.name);
        assertEquals(vasya.number, vasyaFromRepo.number);
        assertEquals(petya.name, petyaFromRepo.name);
        assertEquals(petya.number, petyaFromRepo.number);
        assertEquals(masha.name, mashaFromRepo.name);
        assertEquals(masha.number, mashaFromRepo.number);
    }

    @Test
    public void testGet_threeElements_exists() {
        Contact vasya = new Contact("Vasya", "123");
        Contact petya = new Contact("Petya", "1234");
        Contact masha = new Contact("Masha", "321");
        contactRepo.add(vasya);
        contactRepo.add(masha);
        contactRepo.add(petya);

        Contact mashaFromRepo = contactRepo.getById(masha.id);
        assertEquals(masha.name, mashaFromRepo.name);
        assertEquals(masha.number, mashaFromRepo.number);

    }

    @Test
    public void testGet_threeElements_notExist() {
        Contact vasya = new Contact("Vasya", "123");
        Contact petya = new Contact("Petya", "1234");
        Contact masha = new Contact("Masha", "321");
        contactRepo.add(vasya);
        contactRepo.add(masha);
        contactRepo.add(petya);

        Contact fromRepo = contactRepo.getById(-1000);
        assertNull(fromRepo);
    }

    @Test
    //TODO test remove non-existing
    public void testRemove_threeElements_exist() {
        Contact vasya = new Contact("Vasya", "123");
        Contact petya = new Contact("Petya", "1234");
        Contact masha = new Contact("Masha", "321");
        contactRepo.add(vasya);
        contactRepo.add(masha);
        contactRepo.add(petya);

        contactRepo.remove(vasya.id);
        assertEquals(2, contactRepo.getAll().size());

        Contact petyaFromRepo = contactRepo.getById(petya.id);
        Contact mashaFromRepo = contactRepo.getById(masha.id);
        Contact vasyaFromRepo = contactRepo.getById(vasya.id);

        assertNull(vasyaFromRepo);

        assertEquals(petya.name, petyaFromRepo.name);
        assertEquals(petya.number, petyaFromRepo.number);
        assertEquals(masha.name, mashaFromRepo.name);
        assertEquals(masha.number, mashaFromRepo.number);
    }

    @Test
    //TODO test edit non-existing
    public void testEdit_threeElements_exist() {
        Contact vasya = new Contact("Vasya", "123");
        Contact petya = new Contact("Petya", "1234");
        Contact masha = new Contact("Masha", "321");
        contactRepo.add(vasya);
        contactRepo.add(masha);
        contactRepo.add(petya);

        Contact petyaToChange = new Contact("pet", "5542");
        petyaToChange.id = petya.id;

        contactRepo.edit(petyaToChange);
        Contact petyaFromRepo = contactRepo.getById(petya.id);
        assertEquals(petyaToChange.name, petyaFromRepo.name);
        assertEquals(petyaToChange.number, petyaFromRepo.number);
    }

}

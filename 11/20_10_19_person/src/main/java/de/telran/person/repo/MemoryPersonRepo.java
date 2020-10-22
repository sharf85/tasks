//package de.telran.person.repo;
//
//import de.telran.person.model.Person;
//import org.springframework.stereotype.Repository;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Repository
//public class MemoryPersonRepo implements IPersonRepo {
//
//    Map<Integer, Person> personById = new HashMap<>();
//    AtomicInteger currentId = new AtomicInteger();
//
//    @Override
//    public void save(Person person) {
//        int id = person.getId();
//
//        if (id == 0) {
//            id = currentId.incrementAndGet();
//
//            try {
//                Field idField = Person.class.getDeclaredField("id");
//                idField.setAccessible(true);
//                idField.setInt(person, id);
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
//            person.setId(id);
//        }
//
//        personById.put(id, person);
//    }
//
//    @Override
//    public Person find(int id) {
//        return personById.get(id);
//    }
//
//    @Override
//    public Person remove(int id) {
//        return personById.remove(id);
//    }
//
//    @Override
//    public List<Person> findAll() {
//        return new ArrayList<>(personById.values());
//    }
//}

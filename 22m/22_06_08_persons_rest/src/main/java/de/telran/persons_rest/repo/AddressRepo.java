package de.telran.persons_rest.repo;

import de.telran.persons_rest.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Integer> {
//    List<Address> findAllByPersonId(Integer integer);

    //JPQL
    @Query("select a from Address a where a.person.id=?1")
    List<Address> returnAllByPersonId(Integer integer);
}

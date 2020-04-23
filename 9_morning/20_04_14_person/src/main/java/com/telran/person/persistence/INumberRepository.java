package com.telran.person.persistence;

import com.telran.person.model.PhoneNumber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INumberRepository extends CrudRepository<PhoneNumber, Integer> {

//    public List<PhoneNumber> findByPersonId(int id);

//    @Query("select num from PhoneNumber num join num.person person where person.id=?1")
//    @Query("select num from PhoneNumber num join num.person person where person.id=:id")
    @Query("select num from PhoneNumber num where num.person.id=?1")
    public List<PhoneNumber> findByPersonId(@Param("id") int id);
}

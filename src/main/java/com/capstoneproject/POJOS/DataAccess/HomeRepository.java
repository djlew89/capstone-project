package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository <Home, Integer> {

    Iterable<Home> getAllByUserId(Integer id);
}

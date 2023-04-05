package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.POJOS.Home;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository <Home, Integer> {

    //No queries needed beyond what Spring will generate

}

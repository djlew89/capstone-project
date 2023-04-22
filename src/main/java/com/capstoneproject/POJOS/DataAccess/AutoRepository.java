package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Vehicle, Integer>
{
    Iterable<Vehicle> getAllByUserId(Integer id);
}

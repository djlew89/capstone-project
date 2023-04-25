package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.AutoPolicy;
import com.capstoneproject.HomePolicy;
import com.capstoneproject.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutoRepository extends CrudRepository<Vehicle, Integer>
{
    Iterable<Vehicle> getAllByUserId(Integer id);
}

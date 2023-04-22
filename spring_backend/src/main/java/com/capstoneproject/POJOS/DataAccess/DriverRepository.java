package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.Driver;
import com.capstoneproject.Home;
import com.capstoneproject.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DriverRepository extends CrudRepository<Driver, Integer>
{
    Optional<Driver> findByUserId(Integer id);
}

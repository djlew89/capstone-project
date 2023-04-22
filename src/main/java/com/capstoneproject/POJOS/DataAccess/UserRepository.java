package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.User;
import com.capstoneproject.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * UserRepository for linking User object to the database.
 * This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * CRUD refers Create, Read, Update, Delete
 */
public interface UserRepository extends CrudRepository<User, Integer>
{

    Optional<User> getAllByEmail(String email);

}

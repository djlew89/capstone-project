package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.HomePolicy;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HomePolicyRepository extends CrudRepository<HomePolicy, Integer>
{

    Optional<HomePolicy> getByHomeId(Integer id);
}

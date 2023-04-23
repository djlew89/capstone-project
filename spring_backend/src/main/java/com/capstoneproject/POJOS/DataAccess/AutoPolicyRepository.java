package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.AutoPolicy;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutoPolicyRepository extends CrudRepository<AutoPolicy, Integer>{

    Optional<AutoPolicy> getByVehicleId(Integer id);
}

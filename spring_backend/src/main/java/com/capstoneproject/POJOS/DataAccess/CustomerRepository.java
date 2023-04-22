package com.capstoneproject.POJOS.DataAccess;

import com.capstoneproject.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
}

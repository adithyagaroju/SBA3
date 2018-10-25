package sba;

import org.springframework.data.repository.CrudRepository;
import sba.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>  {

}

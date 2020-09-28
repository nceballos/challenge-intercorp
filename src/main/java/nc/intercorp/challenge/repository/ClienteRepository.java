package nc.intercorp.challenge.repository;

import nc.intercorp.challenge.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}

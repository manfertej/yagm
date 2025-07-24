package dev.manfertej.yagm.repository;

import dev.manfertej.yagm.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public boolean existsByDni(String dni);

}

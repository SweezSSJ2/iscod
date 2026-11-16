package fr.iscod.coworkia.interfaces.repositories;

import fr.iscod.coworkia.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerRepository extends JpaRepository<Computer, UUID> {
}

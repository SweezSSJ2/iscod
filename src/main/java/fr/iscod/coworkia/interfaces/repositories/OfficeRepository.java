package fr.iscod.coworkia.interfaces.repositories;

import fr.iscod.coworkia.entities.Office;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OfficeRepository extends CrudRepository<Office, UUID> {
}

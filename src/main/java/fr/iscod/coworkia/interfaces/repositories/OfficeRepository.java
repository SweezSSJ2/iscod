package fr.iscod.coworkia.interfaces.repositories;

import fr.iscod.coworkia.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {
}

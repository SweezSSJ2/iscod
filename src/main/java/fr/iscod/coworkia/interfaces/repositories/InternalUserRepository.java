package fr.iscod.coworkia.interfaces.repositories;

import fr.iscod.coworkia.entities.InternalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InternalUserRepository extends JpaRepository<InternalUser, UUID> {

    Optional<InternalUser> findByUsername(String username);
}

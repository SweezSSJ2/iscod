package fr.iscod.coworkia.interfaces.repositories;

import fr.iscod.coworkia.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
    List<Workspace> findAllByOfficeId(UUID officeId);
}

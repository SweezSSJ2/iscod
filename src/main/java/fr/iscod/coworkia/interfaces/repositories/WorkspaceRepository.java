package fr.iscod.coworkia.interfaces.repositories;

import fr.iscod.coworkia.entities.Workspace;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface WorkspaceRepository extends CrudRepository<Workspace, UUID> {
}

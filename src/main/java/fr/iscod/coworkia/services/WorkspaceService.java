package fr.iscod.coworkia.services;

import fr.iscod.coworkia.entities.Workspace;
import fr.iscod.coworkia.interfaces.repositories.OfficeRepository;
import fr.iscod.coworkia.interfaces.repositories.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private OfficeRepository officeRepository;

    public List<Workspace> findAll() {
        return (List<Workspace>) workspaceRepository.findAll();
    }

    public Set<Workspace> findAllByOffice(UUID officeId) {
        return officeRepository.findById(officeId).get().getWorkspaces();
    }

}

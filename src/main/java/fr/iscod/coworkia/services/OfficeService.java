package fr.iscod.coworkia.services;

import fr.iscod.coworkia.entities.Office;
import fr.iscod.coworkia.exceptions.ResourceNotFoundException;
import fr.iscod.coworkia.interfaces.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    public Office findById(UUID id) {
        return officeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Office> findAll() {
        return (List<Office>) officeRepository.findAll();
    }

    public UUID create(Office office) {
        return officeRepository.save(office).getId();
    }

    public void update(UUID id, Office office) {
        office.setId(id);
        officeRepository.save(office);
    }

    public void partialUpdate(UUID id, Map<String, Object> updates) {

        Office update = officeRepository.findById(id).get();

        for (String key : updates.keySet()) {
            switch (key) {
                case "name":
                    update.setName((String)updates.get(key));
                    break;
                case "address":
                    update.setAddress((String)updates.get(key));
                    break;
            }
        }

        officeRepository.save(update);
    }

    public void delete(UUID id) {
        officeRepository.deleteById(id);
    }
}

package fr.iscod.coworkia.entities;

import jakarta.persistence.*;

import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private Set<Workspace> workspaces = new HashSet<Workspace>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(Set<Workspace> workspaces) {
        this.workspaces = workspaces;
    }
}

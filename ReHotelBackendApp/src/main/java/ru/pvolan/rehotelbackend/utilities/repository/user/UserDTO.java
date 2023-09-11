package ru.pvolan.rehotelbackend.utilities.repository.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public final class UserDTO {
    @Id
    private String id;
    private String name;

    public UserDTO() {
    }

    public UserDTO(
            String id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDTO[" +
                "id=" + id + ", " +
                "name=" + name + ']';
    }
}

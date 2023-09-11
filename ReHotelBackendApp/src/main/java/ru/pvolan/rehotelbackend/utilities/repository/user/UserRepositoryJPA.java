package ru.pvolan.rehotelbackend.utilities.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends CrudRepository<UserDTO, String> {
}

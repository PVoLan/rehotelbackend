package ru.pvolan.rehotelbackend.utilities.repository.user;

import ru.pvolan.rehotelbackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {

    @Autowired
    private UserRepositoryJPA jpa;

    public List<User> getAllUsers(){
        List<User> res = new ArrayList<>();
        jpa.findAll().forEach(dto -> res.add(dtoToEntity(dto)));
        return res;
    }

    private User dtoToEntity(UserDTO dto) {
        return new User(
                dto.getId(),
                dto.getName()
        );
    }

}

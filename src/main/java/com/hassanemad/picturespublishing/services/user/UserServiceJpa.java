package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.User;
import com.hassanemad.picturespublishing.repos.user.UserRepoJpa;
import com.hassanemad.picturespublishing.utilities.UserFactory;
import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hassanemad.picturespublishing.utilities.UserFactory.toUserDto;
import static com.hassanemad.picturespublishing.utilities.UserFactory.toUserEntity;

@Service
@Primary
@Slf4j
public class UserServiceJpa implements UserServiceInterface{

    UserRepoJpa userRepoJpa;

    public UserServiceJpa(UserRepoJpa userRepoJpa) {
        log.info("UserServiceJpa constructor");
        this.userRepoJpa = userRepoJpa;
        log.info("userRepoJpa injected in UserServiceJpa");
    }

    @Override
    public void registerUser(UserDto userDto, String password) {
        userRepoJpa.save(toUserEntity(userDto,password));
    }

    @Override
    public User findUserByEmail(String email){
        return userRepoJpa.findByUserEmail(email);
    }

    @Override
    @PreDestroy
    @Transactional
    public void loggOutUsersSession() {
        userRepoJpa.findAll().forEach(user -> {
                    user.setLoggedIn(false);
                    userRepoJpa.save(user);
                }
        );

        log.info("All users logged out");
    }

    @Override
    public boolean logIn(String email, String password) {
        User userFound = findUserByEmail(email);
        if (userFound != null && userFound.getPassword().equals(password)){
            userFound.setLoggedIn(true);
            userRepoJpa.save(userFound);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDto> listLoggedInUsers() {
        return userRepoJpa.findAll().stream().filter(User::isLoggedIn).map(
                UserFactory::toUserDto).toList();
    }

    //public User isLoggedIn(String email){
      //  return userRepoJpa.findByUserEmailAndLoggedInEquals(email,true);
    //}

}

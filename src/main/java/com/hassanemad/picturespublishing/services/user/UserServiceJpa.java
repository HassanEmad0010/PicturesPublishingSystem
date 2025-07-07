package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.User;
import com.hassanemad.picturespublishing.errors.HappyResponse;
import com.hassanemad.picturespublishing.errors.user.InvalidCredentialsException;
import com.hassanemad.picturespublishing.errors.user.NoUserException;
import com.hassanemad.picturespublishing.errors.user.UserAlreadyFoundExcepion;
import com.hassanemad.picturespublishing.repos.user.UserRepoJpa;
import com.hassanemad.picturespublishing.utilities.UserFactory;
import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public HappyResponse registerUser(UserDto userDto, String password) {
       User userFound= findUserByEmail(userDto.userEmail());
       if (userFound == null){
           userRepoJpa.save(toUserEntity(userDto,password));
           return new HappyResponse("User registered successfully ", "000");
       }
       throw new UserAlreadyFoundExcepion("User email already exists. Please try another email.");

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
    public HappyResponse logIn(String email, String password) {
        User userFound = findUserByEmail(email);
        if (userFound != null){
            if( userFound.getPassword().equals(password)) {
                userFound.setLoggedIn(true);
                userRepoJpa.save(userFound);
                return new HappyResponse("User logged in successfully", "000");
            }
                throw new InvalidCredentialsException("Invalid credentials. Please check your password");

        }
        throw new InvalidCredentialsException("Invalid credentials. Please check your email");
    }

    @Override
    public List<UserDto> listLoggedInUsers() {
        List<UserDto> usersLoggedFound = userRepoJpa.
                findAll().
                stream().
                filter(User::isLoggedIn).
                map(
                UserFactory::toUserDto).toList();

        if (usersLoggedFound.isEmpty()){
            throw new NoUserException("No Logged in Users");
        }
        return usersLoggedFound;

    }

    //public User isLoggedIn(String email){
      //  return userRepoJpa.findByUserEmailAndLoggedInEquals(email,true);
    //}

}

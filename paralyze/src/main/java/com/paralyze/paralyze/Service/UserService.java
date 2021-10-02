package com.paralyze.paralyze.Service;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDtoConverter;
import com.paralyze.paralyze.Model.User;
import com.paralyze.paralyze.Repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserDtoConverter userDtoConverter;


    public UserService(UserRepository userRepository,UserDtoConverter userDtoConverter){
        this.userRepository=userRepository;
        this.userDtoConverter=userDtoConverter;
    }
    //User Creator
    //Gelen bilgilerden herhangi bir tanesi boş ise BadRequest döndür.
    //Değilse OK döndür.
    public Object createUser(CreateUserRequest createUserRequest){
        if (createUserRequest.getUserName().isEmpty()
                || createUserRequest.getUserName().trim()==""
                || createUserRequest.getPassword().isEmpty()
                || createUserRequest.getPassword().trim()==""
                || createUserRequest.getDisplayName().isEmpty()
                || createUserRequest.getDisplayName().trim()==""){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Validation Error","Tüm Alanlar Doldurulmalıdır.");
            return ResponseEntity.badRequest().headers(headers).body("Doldur");
        }
        else{
        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        User user = new User(createUserRequest.getUserId(),
                    createUserRequest.getUserName(),
                    createUserRequest.getDisplayName(),
                    passwordEncoder.encode(createUserRequest.getPassword()));
            return ResponseEntity.ok(userDtoConverter.converter(this.userRepository.save(user)));}
    }
    //Tüm kullanıcıları Listeler.
    public List<Object> findAllUsers(){
        return userRepository.findAll().
                stream().map(x -> userDtoConverter.converter(x)).collect(Collectors.toList());
    }
}

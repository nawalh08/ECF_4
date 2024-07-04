package com.example.ECF_4.services;

import com.example.ECF_4.dao.UserRepository;
import com.example.ECF_4.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private final UserRepository userRepository;
    private HttpSession _httpSession;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user.getPassword().equals(password)) {
            _httpSession.setAttribute("user", user);
            _httpSession.setAttribute("login", "ok");
            return true;

        }
        return false;
    }

    public boolean isLogged(){
        try{
            String attrIsLogged = _httpSession.getAttribute("login").toString();
            return attrIsLogged.equals("ok");
        }
        catch(Exception e){
            return false;
        }
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public void logout() {
        _httpSession.invalidate();

    }
}

package com.example.case_module4.service.user;

import com.example.case_module4.model.User;
import com.example.case_module4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);

    Page<User> findAll(Pageable pageable);

    Page<User> findAllByNameOrPhoneOrEmail(String keyword, Pageable pageable);
}

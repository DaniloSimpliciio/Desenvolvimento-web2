package br.edu.ifspcjo.ads.web2.ifitness.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web2.ifitness.domain.model.Permission;
import br.edu.ifspcjo.ads.web2.ifitness.domain.model.User;
import br.edu.ifspcjo.ads.web2.ifitness.repository.PermissionRepository;
import br.edu.ifspcjo.ads.web2.ifitness.repository.UserRepository;
import br.edu.ifspcjo.ads.web2.ifitness.service.exception.EmailAlreadyRegisteredException;
import br.edu.ifspcjo.ads.web2.ifitness.service.exception.UnderageUserException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        int idade = Period.between(user.getBirthDate(), LocalDate.now()).getYears();

        if (idade < 12) {
            throw new UnderageUserException();
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyRegisteredException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPermissions(getCommonUserPermissions());

        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        User userSaved = userRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return userSaved;
    }

    public User update(Long id, User user) {
        User userSaved = findUserById(id);

        user.setId(userSaved.getId());

        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(userSaved.getPassword());
        }

        // preserva as permissoes ja concedidas caso o cliente nao envie nenhuma
        if (user.getPermissions() == null || user.getPermissions().isEmpty()) {
            user.setPermissions(userSaved.getPermissions());
        }

        return userRepository.save(user);
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    // permissão de quem se cadastra: ROLE_SEARCH_USER (1)
    private List<Permission> getCommonUserPermissions() {
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permissionRepository.findById(1L).get());
        return permissions;
    }
}

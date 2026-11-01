
package br.edu.ifspcjo.ads.web2.ifitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web2.ifitness.domain.model.User;
import br.edu.ifspcjo.ads.web2.ifitness.repository.UserRepository;
import br.edu.ifspcjo.ads.web2.ifitness.service.exception.EmailAlreadyRegisteredException;
import java.time.LocalDate;
import java.time.Period;

import br.edu.ifspcjo.ads.web2.ifitness.service.exception.UnderageUserException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

public User save(User user) {

    int idade = Period.between(user.getBirthDate(), LocalDate.now()).getYears();

    if (idade < 12) {
        throw new UnderageUserException();
    }

    if (userRepository.existsByEmail(user.getEmail())) {
        throw new EmailAlreadyRegisteredException();
    }

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

        return userRepository.save(user);
    }

	public List<User> findByName(String name) {
    return userRepository.findByNameContainingIgnoreCase(name);
}
}

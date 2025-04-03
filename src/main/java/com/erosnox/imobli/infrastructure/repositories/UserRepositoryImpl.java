package com.erosnox.imobli.infrastructure.repositories;

import com.erosnox.imobli.core.auth.application.contracts.repositories.UserRepository;
import com.erosnox.imobli.core.auth.domain.entities.User;
import com.erosnox.imobli.core.shared.exceptions.ConflictException;
import com.erosnox.imobli.core.shared.exceptions.NotFoundException;
import com.erosnox.imobli.infrastructure.mappers.UserJpaMapper;
import com.erosnox.imobli.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserJpaRepository repository;

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void activateUser(UUID userId) {
        var user = repository.findById(userId).orElseThrow(
                () -> new NotFoundException("User not found"));
        if (user.isEnabled()) {
            throw new ConflictException("User already activated");
        }
        user.setEnabled(true);
        repository.save(user);
    }

    @Override
    public User save(User entity) {
        var user = UserJpaMapper.toJpa(entity);
        var savedUser = repository.save(user);

        return UserJpaMapper.fromJpa(savedUser);
    }

    @Override
    public User update(User entity) {
        var user = UserJpaMapper.toJpa(entity);
        user.setId(entity.getId());
        var savedUser = repository.save(user);

        return UserJpaMapper.fromJpa(savedUser);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }
}

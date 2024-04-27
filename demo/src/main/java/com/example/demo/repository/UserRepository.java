// JPA Repository interface for User entity
// CrudRepository is a Spring Data interface for generic CRUD operations on a repository for a specific type.

package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

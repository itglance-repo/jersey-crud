package com.jerseycrud.demo.jerseycrud.repository;

import com.jerseycrud.demo.jerseycrud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

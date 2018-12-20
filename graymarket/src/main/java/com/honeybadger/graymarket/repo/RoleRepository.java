package com.honeybadger.graymarket.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeybadger.graymarket.model.Role;
import com.honeybadger.graymarket.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(RoleName roleName);
}

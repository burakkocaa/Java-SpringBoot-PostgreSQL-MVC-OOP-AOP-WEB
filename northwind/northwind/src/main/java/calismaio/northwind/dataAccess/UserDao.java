package calismaio.northwind.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import calismaio.northwind.core.utilities.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	
}

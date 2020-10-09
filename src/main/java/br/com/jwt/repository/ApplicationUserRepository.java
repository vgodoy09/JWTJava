package br.com.jwt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jwt.model.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
	
	@Query(value="select * from dbo.application_user where username = ?1", nativeQuery=true)
    ApplicationUser findByUsername(String username);
}

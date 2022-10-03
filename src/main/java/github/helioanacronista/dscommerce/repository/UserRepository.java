package github.helioanacronista.dscommerce.repository;

import github.helioanacronista.dscommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRepository, Long> {

   User findByEmail(String email);
}

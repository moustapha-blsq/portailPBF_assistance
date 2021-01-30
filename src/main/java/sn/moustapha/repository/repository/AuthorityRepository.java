package sn.moustapha.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.moustapha.repository.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}

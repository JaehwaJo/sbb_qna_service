package com.exam.sbb.user;

import com.exam.sbb.base.RepositoryUtil;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long>, RepositoryUtil {
  boolean existsByUsername(String username);

  Optional<SiteUser> findByUsername(String username);

  @Modifying
  @Transactional
  @Query(value = "ALTER TABLE site_user AUTO_INCREMENT = 1", nativeQuery = true)
  void truncate();
}
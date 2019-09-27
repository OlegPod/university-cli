package com.olehpodolin.universitycli.repositories;

import com.olehpodolin.universitycli.domain.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {
}

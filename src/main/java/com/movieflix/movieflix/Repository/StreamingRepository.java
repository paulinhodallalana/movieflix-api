package com.movieflix.movieflix.Repository;

import com.movieflix.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming,Long> {
}

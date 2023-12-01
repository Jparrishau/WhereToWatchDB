package com.parrish.inc.where.to.watch.model.repository;

import com.parrish.inc.where.to.watch.model.entity.MovieDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDataRepository extends JpaRepository<MovieDataEntity, Long> {
}
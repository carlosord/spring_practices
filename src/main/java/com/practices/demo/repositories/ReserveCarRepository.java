package com.practices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.demo.model.ReserveCarDate;

/**
 * The Interface ReserveCarRepository.
 */
@Repository
public interface ReserveCarRepository extends JpaRepository<ReserveCarDate, Long> {

}

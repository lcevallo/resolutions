package com.lcevallo.springsecurity.resolutions.repository;

import com.lcevallo.springsecurity.resolutions.models.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ResolutionRepository extends JpaRepository<Resolution, Integer> {

    @Modifying
    @Query("UPDATE Resolution SET text = :text WHERE id = :id")
    void revise(Integer id, String text);

    @Modifying
    @Query("UPDATE Resolution SET completed = 1 WHERE id = :id")
    void complete(Integer id);

    Optional<Resolution> findById(Integer Id);
}

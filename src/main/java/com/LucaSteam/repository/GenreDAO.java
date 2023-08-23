package com.LucaSteam.repository;

import com.LucaSteam.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDAO extends JpaRepository<Genre, Long> {
    @Query("FROM Genre WHERE genre_name =?1")
    Genre findByName(String name);
}

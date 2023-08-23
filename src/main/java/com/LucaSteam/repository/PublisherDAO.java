package com.LucaSteam.repository;

import com.LucaSteam.model.Platform;
import com.LucaSteam.model.Publisher;
import com.LucaSteam.service.PublisherServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherDAO extends JpaRepository<Publisher, Long> {
    @Query("FROM Publisher WHERE publisher_name =?1")
    Publisher findByName(String name);
}

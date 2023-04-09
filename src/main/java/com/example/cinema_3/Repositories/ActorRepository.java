package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query(value = "Select actor.id from tbl_actors actor where actor.actor_name = :name", nativeQuery = true)
    public Long findIdByName(@Param("name") String name);

    public Actor findActorsByActorName(String name);
}

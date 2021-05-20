package io.javabrains.apldashboard.repository;

import io.javabrains.apldashboard.module.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);


}

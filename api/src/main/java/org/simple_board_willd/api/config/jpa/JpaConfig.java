package org.simple_board_willd.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.simple_board_willd.db")
@EnableJpaRepositories(basePackages = "org.simple_board_willd.db")
public class JpaConfig {}

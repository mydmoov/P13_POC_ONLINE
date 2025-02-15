package com.yourcaryourway.P13_chat_backend.configuration.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfig {
}

// A chaques Save ou Update , Spring va lui même mettre à jour auto les created-at , updated-at , etc
// Contrainte : il faut qu'il y est le bon type de données dans la base de données
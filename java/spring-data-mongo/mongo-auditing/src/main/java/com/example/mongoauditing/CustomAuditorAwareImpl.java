package com.example.mongoauditing;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.ofNullable("fixedAuditor");
  }
}

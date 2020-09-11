package com.example.mongoauditing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class MongoAuditingApplication implements CommandLineRunner {

  private final UserDocumentRepository userDocumentRepository;

  public static void main(String[] args) {
    SpringApplication.run(MongoAuditingApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    userDocumentRepository.deleteAll();

    log.info("create two user.");
    userDocumentRepository.save(UserDocument.builder().firstName("Mike").lastName("Moore").build());
    userDocumentRepository.save(UserDocument.builder().firstName("Maria").lastName("Moore").build());

    log.info("check users...");
    userDocumentRepository.findAll().forEach(userDocument -> log.info(userDocument.toString()));
  }
}

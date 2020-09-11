package com.example.mongoevent;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Slf4j
@SpringBootApplication
@EnableMongoAuditing
@RequiredArgsConstructor
public class MongoEventApplication implements CommandLineRunner {

  private final UserDocumentRepository userDocumentRepository;
  private final UserHistoryDocumentRepository userHistoryDocumentRepository;

  public static void main(String[] args) {
    SpringApplication.run(MongoEventApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    userDocumentRepository.deleteAll();

    log.info("create two user.");
    userDocumentRepository.save(UserDocument.builder().firstName("Mike").lastName("Moore").build());
    userDocumentRepository.save(UserDocument.builder().firstName("Maria").lastName("Moore").build());

    log.info("check users...");
    List<UserDocument> userDocumentList = userDocumentRepository.findAll();
    userDocumentList.forEach(userDocument -> log.info(userDocument.toString()));

    log.info("update user...");
    UserDocument userDocument = userDocumentList.get(0);
    userDocument.setEnabled(true);
    userDocumentRepository.save(userDocument);

    log.info("check history...");
    userHistoryDocumentRepository.findAll().forEach(userHistoryDocument-> log.info(userHistoryDocument.toString()));
  }
}

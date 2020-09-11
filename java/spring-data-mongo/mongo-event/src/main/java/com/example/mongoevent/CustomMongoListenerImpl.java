package com.example.mongoevent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomMongoListenerImpl extends AbstractMongoEventListener<UserDocument> {

  private final UserHistoryDocumentRepository userHistoryDocumentRepository;

  @Override
  public void onAfterSave(AfterSaveEvent<UserDocument> event) {
    log.info("eventSource: {}, eventDocument: {}", event.getSource(), event.getDocument());
    userHistoryDocumentRepository.save(UserHistoryDocument.builder()
        .userDocumentId(event.getSource().getId())
        .userDocument(event.getSource())
        .build());
  }
}

package com.example.mongoevent;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class UserHistoryDocument {
  @Id
  private ObjectId id;

  private ObjectId userDocumentId;

  private UserDocument userDocument;

  @CreatedDate
  private Date createdDate;
}

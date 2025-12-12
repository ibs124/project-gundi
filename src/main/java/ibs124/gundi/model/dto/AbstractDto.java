package ibs124.gundi.model.dto;

import java.time.Instant;

public interface AbstractDto {

    long id();

    Instant createdAt();

    Instant updatedAt();
}
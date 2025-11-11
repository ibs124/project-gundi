package ibs124.gundi.model.dto;

import java.time.Instant;

public interface AbstractAuditableDto extends AbstractDto {

    Instant createdAt();

    Instant updatedAt();
}

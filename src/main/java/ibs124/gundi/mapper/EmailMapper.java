package ibs124.gundi.mapper;

import ibs124.gundi.model.domain.Email;
import ibs124.gundi.model.dto.EmailCreateDTO;
import ibs124.gundi.model.dto.EmailDTO;

public interface EmailMapper {

    Email toDomainModel(EmailCreateDTO src);

    EmailDTO toServiceModel(Email src);
}

package ibs124.gundi.mapper;

import ibs124.gundi.model.domain.Email;
import ibs124.gundi.model.service.EmailCreateDTO;
import ibs124.gundi.model.service.EmailDTO;

public interface EmailMapper {

    Email toDomainModel(EmailCreateDTO src);

    EmailDTO toServiceModel(Email src);
}

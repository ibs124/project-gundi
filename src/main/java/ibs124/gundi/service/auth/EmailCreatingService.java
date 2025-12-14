package ibs124.gundi.service.auth;

import ibs124.gundi.model.dto.EmailCreateDTO;
import ibs124.gundi.model.dto.EmailDTO;

public interface EmailCreatingService {

    EmailDTO create(EmailCreateDTO dto);

}

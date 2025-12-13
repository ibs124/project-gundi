package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.EmailCreateDTO;
import ibs124.gundi.model.service.EmailDTO;

public interface EmailCreatingService {

    EmailDTO create(EmailCreateDTO dto);

}

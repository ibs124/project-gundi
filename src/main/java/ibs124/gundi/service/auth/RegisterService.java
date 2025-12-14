package ibs124.gundi.service.auth;

import ibs124.gundi.model.dto.RegisterDTO;
import ibs124.gundi.model.dto.RegisterResponseDTO;

public interface RegisterService {

   RegisterResponseDTO register(RegisterDTO dto, String appUrl);
   
}

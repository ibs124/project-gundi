package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.RegisterDTO;
import ibs124.gundi.model.service.RegisterResponseDTO;

public interface RegisterService {

   RegisterResponseDTO register(RegisterDTO request);
   
}

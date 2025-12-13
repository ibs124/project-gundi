package ibs124.gundi.service.auth;

import ibs124.gundi.model.service.RegisterDto;
import ibs124.gundi.model.service.RegisterResponseDto;

public interface RegisterService {

   RegisterResponseDto register(RegisterDto request);
   
}

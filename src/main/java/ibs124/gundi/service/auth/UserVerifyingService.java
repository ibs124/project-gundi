package ibs124.gundi.service.auth;

public interface UserVerifyingService {

    boolean verifyByToken(String token);
}

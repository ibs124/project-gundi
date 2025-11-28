package ibs124.gundi.service.user;

public interface UserReadingService {

    boolean existsByUsername(String username);

    boolean existsByEmail(String value);

}

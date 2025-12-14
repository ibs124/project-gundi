package ibs124.gundi.service.auth;

import ibs124.gundi.model.domain.User;

interface UserFactory {

    User createUser(User user, String email);

}
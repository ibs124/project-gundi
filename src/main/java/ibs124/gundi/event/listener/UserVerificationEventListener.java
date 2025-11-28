package ibs124.gundi.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import ibs124.gundi.event.UserVerificationEvent;

@Component
class UserVerificationEventListener
        implements ApplicationListener<UserVerificationEvent> {

    @Override
    public void onApplicationEvent(@NonNull UserVerificationEvent event) {
        // TODO Auto-generated method stub

    }

}

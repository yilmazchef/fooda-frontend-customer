package be.fooda.frontend.mapper;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public be.fooda.frontend.model.basket.User map(be.fooda.frontend.model.user.User source, String session) {
        be.fooda.frontend.model.basket.User target = new be.fooda.frontend.model.basket.User();
        target.seteUserId(source.getId().toString());
        target.setUsername(source.getLogin());
        target.setSession(session);
        return target;
    }

}

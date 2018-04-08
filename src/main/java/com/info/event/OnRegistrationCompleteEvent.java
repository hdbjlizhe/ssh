package com.info.event;

import org.springframework.context.ApplicationEvent;

import com.info.domain.entity.User;


public class OnRegistrationCompleteEvent extends ApplicationEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2442496201839857392L;

	private final String appUrl;

    private final User user;


    public OnRegistrationCompleteEvent(final User user, final String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }


    public User getUser() {
        return user;
    }

}

package com.info.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleUtil {
	
	@Autowired
	private static MessageSource messageSource;
		
	public static MessageSource getMessageSource() {
		return messageSource;
	}

	public static void setMessageSource(MessageSource messageSource) {
		LocaleUtil.messageSource = messageSource;
	}

	public static String getAttribute(String message) throws NoSuchMessageException {
		String resultStr;
		Locale locale = LocaleContextHolder.getLocale();
	    resultStr= messageSource.getMessage(message, null, locale);
	    return resultStr;
    }
}

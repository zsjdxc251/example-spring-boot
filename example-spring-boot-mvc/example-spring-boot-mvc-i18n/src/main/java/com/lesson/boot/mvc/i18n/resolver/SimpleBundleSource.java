package com.lesson.boot.mvc.i18n.resolver;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author zhengshijun
 * @version created on 2019/9/2.
 */
public class SimpleBundleSource extends ResourceBundleMessageSource {

    @Override
    protected MessageFormat createMessageFormat(String msg, Locale locale) {



        return new ExtendedMessageFormat(msg,locale);
    }
}

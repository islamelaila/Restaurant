package com.spring.boot.service.bundle;
import com.spring.boot.helper.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundelMessageService {

    @Autowired
    private ResourceBundleMessageSource messageSource ;


    public  String getMessage_Ar(String key){

        return messageSource.getMessage(key, null, new Locale("ar"));
    }


    public  String getMessage_En( String key ){

        return messageSource.getMessage(key, null, new Locale("en"));

    }


    public  String getMessage_Fr( String key ){

        return messageSource.getMessage(key, null, new Locale("fr"));
    }

    public MessageResponse getMessage(String key){
        return new MessageResponse(getMessage_Ar(key),getMessage_En(key),getMessage_Fr(key));
    }



}

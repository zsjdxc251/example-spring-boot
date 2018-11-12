package com.lesson.boot.mvc.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@JsonComponent
public class CustomJsonSerializer extends JsonSerializer<String> {
    private static final Logger log = LoggerFactory.getLogger(CustomJsonSerializer.class);

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(s);
    }
}

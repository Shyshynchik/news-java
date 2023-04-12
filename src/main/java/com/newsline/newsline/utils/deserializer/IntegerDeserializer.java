package com.newsline.newsline.utils.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;

public class IntegerDeserializer extends JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getValueAsString();
        if (NumberUtils.isCreatable(value)) {
            return Integer.parseInt(value);
        }
        return 0;
    }
}

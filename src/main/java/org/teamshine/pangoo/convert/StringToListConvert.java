package org.teamshine.pangoo.convert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;


public class StringToListConvert implements Converter<String,List<Object>> {
    public List<Object> convert(String source) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(source,new TypeReference<List<Object>>(){});
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("[%s]转换List格式失败",source));
        }
    }
}
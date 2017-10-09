package org.teamshine.pangoo.convert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;


public class StringToMapConvert implements Converter<String,Map<String,Object>> {
    public Map<String,Object> convert(String source) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(source, new TypeReference<Map<String,Object>>() {
            });
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("[%s]转换Map格式失败", source));
        }
    }
}

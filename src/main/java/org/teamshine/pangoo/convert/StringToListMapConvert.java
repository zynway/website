package org.teamshine.pangoo.convert;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Map;


public class StringToListMapConvert implements Converter<String,List<Map<String,Object>>> {
    public List<Map<String,Object>> convert(String source) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(source,new TypeReference<List<Map<String,Object>>>(){});
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("[%s]转换ListMap格式失败",source));
        }
    }
}

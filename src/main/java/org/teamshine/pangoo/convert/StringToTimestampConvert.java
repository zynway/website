package org.teamshine.pangoo.convert;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class StringToTimestampConvert implements Converter<String, Timestamp> {
    public Timestamp convert(String source) {
        try {
            Long time = Long.parseLong(source);
            return new Timestamp(time);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("[%s]转换Timestamp格式失败", source));
        }
    }
}

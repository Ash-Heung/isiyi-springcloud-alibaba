package com.isiyi.common.config;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

@Data
public class ChineseDateFormat extends SimpleDateFormat {

    private static final long serialVersionUID = 6276491293753307748L;

    public ChineseDateFormat() throws Exception{
        super("y-MM-dd HH:mm:ss", Locale.CHINESE);
        setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

}

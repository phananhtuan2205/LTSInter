package com.example.intern_BE.Utity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertStringtodate {
    public LocalDateTime convertoDate(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(str,formatter);

        return dateTime;
    }
}

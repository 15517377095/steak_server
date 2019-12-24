package com.steak.entity;

import lombok.Data;

@Data
public class Game {
    private Integer id;
    private String name;
    private int typeId;
    private Type type;
    private Float money;
    private String releasedate;
    private String developers;
    private String publisher;
    private String language;
    private String introduction;
    private String imgs;
    private String mdfile;
}

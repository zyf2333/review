package com.example.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author zyf
 * @Description
 * @ClassName StreamTester
 * @Date 2020/9/11 13:50
 **/
public class StreamTester {
    public static void main(String[] args) {
        Aoo a = new Aoo(11, "a1", null,"123");
        Aoo a2 = new Aoo(22, "a2", null,"12345");
        Aoo a3 = new Aoo(23, "a2222",null, "1234522");
        Aoo a4 = new Aoo(24, "a2", null,"12345");
        Aoo a5 = new Aoo(25, "a2", null,"12345");

        Boo b = new Boo(1, 11, "b1", "demo");
        Boo b2 = new Boo(2, 22, "b2", "demo2");
        Boo b3 = new Boo(3, 23, "b3", "demo3");
        List<Aoo> aooList = Arrays.asList(a, a2, a3, a4, a5);
        List<Boo> booList = Arrays.asList(b, b2, b3);

        Map<Integer, Boo> maps = booList.stream().collect(Collectors.toMap(Boo::getAooId, Function.identity(), (key1, key2) -> key2));
        System.out.println(maps);
        aooList.stream().forEach(o ->{
            Boo boo = maps.get(o.getId());
            if(boo!=null){
                o.setbName(boo.getName());
            }

        });
        System.out.println(aooList);

    }


}

class Aoo {
    private Integer id;
    private String name;
    private String bName;
    private String value;
    private String type;

    public Aoo(Integer id, String name, String bName, String value) {
        this.id = id;
        this.name = name;
        this.bName = bName;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AooVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bName='" + bName + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class Boo {
    private Integer id;
    private Integer aooId;
    private String name;
    private String type;

    public Boo(Integer id, Integer aooId, String name, String type) {
        this.id = id;
        this.aooId = aooId;
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAooId() {
        return aooId;
    }

    public void setAooId(Integer aooId) {
        this.aooId = aooId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Boo{" +
                "id=" + id +
                ", aooId=" + aooId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

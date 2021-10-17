package com.json.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.json.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws JsonProcessingException, ParseException {

        // Пример 1
        // Конвертируем Map в Json
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "val1");
        map1.put("key2", "val2");

        String resultJson1 = new ObjectMapper().writeValueAsString(map1);
        System.out.println(resultJson1); // {"key1":"val1","key2":"val2"

        System.out.println("1 =========================");

        // Пример 2
        // Конвертируем объект в Json
        MyObject1 myObject1 = new MyObject1();
        myObject1.setName("My object");

        String resultJson2 = new ObjectMapper().writeValueAsString(myObject1);
        System.out.println(resultJson2); // {"name":"My object"}

        System.out.println("2 =========================");

        // Пример 3
        // Конвертация объекта с добавлением properties Map в Json
        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "val1");
        map2.put("key2", "val2");

        MyObject2 myObject2 = new MyObject2();
        myObject2.setName("My object");
        myObject2.setProperties(map2);

        String resultJson3 = new ObjectMapper().writeValueAsString(myObject2);
        System.out.println(resultJson3); // {"name":"My object","properties":{"key1":"val1","key2":"val2"}}

        System.out.println("3 =========================");

        // Пример 4
        // Конвертация объекта и Map в Json без properties Map
        Map<String, String> map3 = new HashMap<>();
        map3.put("key1", "val1");
        map3.put("key2", "val2");

        MyObject3 myObject3 = new MyObject3();
        myObject3.setName("My object");
        myObject3.setProperties(map3);

        String resultJson4 = new ObjectMapper().writeValueAsString(myObject3);
        System.out.println(resultJson4); // {"name":"My object","key1":"val1","key2":"val2"}

        System.out.println("4 =========================");

        // Пример 5
        // С расстановкой очерёдности параметров @JsonPropertyOrder
        MyObject4 myObject4 = new MyObject4();
        myObject4.setId(1);
        myObject4.setName("My object");

        String resultJson5 = new ObjectMapper().writeValueAsString(myObject4);
        System.out.println(resultJson5); // {"id":1,"name":"My object"}

        System.out.println("5 =========================");

        // Пример 6.
        // Возвращает объект как в примере 3, с properties.
        MyObject5 myObject5 = new MyObject5();
        myObject5.setName("My object");
        myObject5.setJson("{\"attr\"false}");

        String resultJson6 = new ObjectMapper().writeValueAsString(myObject5);
        System.out.println(resultJson6); // {"name":"My object","json":{"attr"false}}

        System.out.println("6 =========================");

        // Пример 7.
        // Использование Enum
        String resultJson7 = new ObjectMapper().writeValueAsString(MyEnum1.TYPE1.getName());
        System.out.println(resultJson7); // "Type A"

        System.out.println("7 =========================");

        // Пример 8.
        // С аннотацией @JsonRootName
        MyObject6 myObject6 = new MyObject6(1, "John");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String resultJson8 = mapper.writeValueAsString(myObject6);
        System.out.println(resultJson8); // {"user":{"id":1,"name":"John"}}

        System.out.println("8 =========================");

        // Пример 9.
        // Конвертация в xml
        MyObject7 user2 = new MyObject7(1, "John");

        XmlMapper xmlMapper1 = new XmlMapper();
        xmlMapper1.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String resultJson9 = xmlMapper1.writeValueAsString(user2);
        System.out.println(resultJson9);

        System.out.println("9 =========================");

        // Пример 10.
        // Простой пример сериализация даты при помощи аннотации JsonSerialize
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);

        MyObject8 event = new MyObject8("party", date);
        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);

        System.out.println("10 =========================");

        // Пример 10.
        // Нативное создание Json при помощи аннотации JsonCreator. И пример получение данных из полей
        //             {"id":1,"theName":"My bean"}
        String json1 = "{\"id\":1,\"theName\":\"John\"}";

        MyObject9 beanObject = new ObjectMapper().readerFor(MyObject9.class).readValue(json1);
        System.out.println(beanObject.name);
        System.out.println(beanObject.id);

        System.out.println("11 =========================");

        // Пример 11.
        // Тоже-самое что и пример 10, только немного по другому реализовано
        String json2 = "{\"name\":\"John\"}";

        InjectableValues inject1 = new InjectableValues.Std().addValue(int.class, 1);
        MyObject10 myObject10 = new ObjectMapper().reader(inject1).forType(MyObject10.class).readValue(json2);
        System.out.println(myObject10.name);
        System.out.println(myObject10.id);

        System.out.println("12 =========================");

        // Пример 12.
        // Тоже-самое что и пример 10, 11, только немного по другому реализовано с аннотацией JsonSetter
        String myJson = "{\"id\":1,\"name\":\"John\"}";
        MyObject11 myObject11 = new ObjectMapper().readerFor(MyObject11.class).readValue(myJson);
        System.out.println(myObject11.getName());
        System.out.println(myObject11.getId());


    }

}

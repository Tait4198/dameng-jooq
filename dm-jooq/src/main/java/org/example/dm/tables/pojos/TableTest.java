/*
 * This file is generated by jOOQ.
 */
package org.example.dm.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TableTest implements Serializable {

    private static final long serialVersionUID = 1587746311;

    private Integer id;
    private String  name;
    private Object  content;

    public TableTest() {}

    public TableTest(TableTest value) {
        this.id = value.id;
        this.name = value.name;
        this.content = value.content;
    }

    public TableTest(
        Integer id,
        String  name,
        Object  content
    ) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public Object getContent() {
        return this.content;
    }


    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using {@literal <deprecationOnUnknownTypes/>} in your code generator configuration.
     */
    @java.lang.Deprecated
    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TableTest (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(content);

        sb.append(")");
        return sb.toString();
    }
}
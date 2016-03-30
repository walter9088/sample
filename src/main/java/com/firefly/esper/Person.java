package com.firefly.esper;

import java.util.List;
import java.util.Map;

/**
 * 类Person.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年3月29日 上午1:24:08
 */
public class Person {

    private String       name;
    private int          age;
    List<Child>          children;
    Map<String, Integer> phones;
    Address              address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Child getChildren(int index) {
        return children.get(index);
    }

    public int getPhones(String name) {
        return phones.get(name);
    }

    public Address getAddress() {
        return address;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Map<String, Integer> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, Integer> phones) {
        this.phones = phones;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

class Child {

    String name;
    int    gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}

class Address {

    String road;
    String street;
    int    houseNo;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

}

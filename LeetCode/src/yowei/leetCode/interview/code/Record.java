package yowei.leetCode.interview.code;

import java.io.Serializable;

public class Record implements Serializable {
    int id;
    byte gender;
    short depart;
    int age;

    public Record(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public short getDepart() {
        return depart;
    }

    public void setDepart(short depart) {
        this.depart = depart;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", gender=" + gender +
                ", depart=" + depart +
                ", age=" + age +
                '}';
    }
}

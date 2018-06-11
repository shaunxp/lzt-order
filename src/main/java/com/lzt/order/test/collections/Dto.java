package com.lzt.order.test.collections;

public class Dto implements Comparable<Dto> {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;

    private Integer age;

    public Dto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dto dto = (Dto) o;

        if (!name.equals(dto.name)) return false;
        return age.equals(dto.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Dto o) {

        if (this.age > o.age) {
            return 1;
        }
        if (this.age < o.age) {
            return -1;
        }


        return this.name.compareTo(o.name);
    }
}

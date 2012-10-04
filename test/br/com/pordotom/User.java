package br.com.pordotom;

public class User {

    private String name;

    private String email;

    private Integer age;

    private Long daysAlive;

    private Boolean alive;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    private Double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDaysAlive() {
        return daysAlive;
    }

    public void setDaysAlive(Long daysAlive) {
        this.daysAlive = daysAlive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
}

package cn.tanli.test.vo;/**
 * cn.tanli.test.vo
 *
 * @author Tan.li
 * @date 2021/6/29
 */

import java.math.BigDecimal;

/**
 *@ClassName BaseTest
 *@Description TODO
 *@Author Tan.li
 *@Date 2021/6/29
 *@Since 1.0
 */
public class BaseTest {

    private int id;
    private String code;
    private String name;
    private Integer age;


    private BigDecimal cost;

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    @Override
    public String toString() {
        return "BaseTest{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cost=" + cost +
                '}';
    }
}

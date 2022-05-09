package cn.tanli.test.vo;


/**
 * @ClassName Uto
 * @Description TODO
 * @Author tanli
 * @Date 2022/4/20
 * @Since 1.0
 */
public class Uto {
    
    private String id;
    private  String name;

    /**
     * uto
     *
     * @param id   id
     * @param name 名字
     */
    public Uto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 得到id
     *
     * @return {@link String}
     */
    public String getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

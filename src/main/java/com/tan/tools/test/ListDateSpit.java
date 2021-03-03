package com.tan.tools.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ListDateSpit
 * @Description TODO
 * @Author Tan.li
 * @Date 2020-12-02
 * @Since 1.0
 */

public class ListDateSpit {

    private List<String> listData = new ArrayList<>();


    @Before
    public void testInitData() {
        for (int i = 0; i < 1000; i++) {
            listData.add(String.format("数据ID-%s", i + 1));
        }
    }


    @Test
    public void testForeach() {
        for (String str : listData) {
            System.out.println("输出数据:" + str);
        }
    }

    @Test
    public void testSpitList() {

        List<List<String>> lisize = spitList(listData, 201);

        for (List<String> listList : lisize) {

            System.out.println(String.format("listlist：%s", listList.size()));
            for(String stt:listList){
                System.out.println(String.format("拆解后数据：%s", stt));
            }
            System.err.println("==============================================");

        }
    }

    /**
     * @Description TODO  拆分list 与分页逻辑相符
     * @Author Tan.li
     * @Date 2020-12-02
     */
    public static List<List<String>> spitList(List<String> list, int pageSize) {

        List<List<String>> lists = new ArrayList<>();

        int countSize = list.size();

        int subSize = (countSize % pageSize > 0) ? (countSize / pageSize) + 1 : (countSize / pageSize);

        int currentSize = 0;
        for (int i = 0; i < subSize; i++) {
            System.out.println(String.format("subSize%s,i:%s", subSize, i));
            if (subSize == (i + 1)) {
                System.out.println(String.format("currentSize:%s,countSize:%s", currentSize, countSize));
                List<String> newList = list.subList(currentSize, countSize);
                lists.add(newList);
            } else {
                System.out.println(String.format("currentSize:%s,countSize:%s", currentSize, pageSize));
                List<String> newList = list.subList(currentSize, currentSize + pageSize);
                lists.add(newList);
            }
            currentSize += pageSize;
        }
        return lists;
    }

    @Test
    public void testDistinctList(){
        System.out.println(String.format("增加重复数据前listData size:%s",listData.size()));
        listData.addAll(createData());
        System.out.println(String.format("增加重复数据之后listData size:%s",listData.size()));

        List<String> testData=distinctList(listData);

        for (String tts:testData) {
            System.out.println(String.format("去重复后Data:"+tts));
        }
    }

    /**
     * @Description TODO 新建数据
     * @Author Tan.li
     * @Date 2020-12-02
     */
    public List<String> createData(){
        List<String> newList=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            newList.add(String.format("数据ID-%s", i + 1));
        }
        return newList;
    }

    /**
     * @Description TODO 去重
     * @Author Tan.li
     * @Date 2020-12-02
     */
    public static List<String> distinctList(List<String> list){
        return list.stream().distinct().collect(Collectors.toList());
    }


    @Test
    public void testItemVOdistinct(){
        List<ItemVO> list=createItemData();

        for (ItemVO it:list){
            System.out.println(String.format("编号:%s,货品名称:%s",it.itemCode,it.itemName));
        }
    }


    public static List<ItemVO> createItemData(){
        List<ItemVO> itemList=new ArrayList<>();
        for(int i=0;i<1000;i++){
            itemList.add(new ItemVO(i,String.format("货品名称%s编号",i)));
        }
        return itemList;
    }

}

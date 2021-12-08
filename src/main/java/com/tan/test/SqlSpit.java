package com.tan.test;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SqlSpit
 * @Description TODO
 * @Author tanli
 * @Date 2021/11/23
 * @Since 1.0
 */
public class SqlSpit {


        public static void main(String[] args) throws SQLException {
            //注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //获取与数据库的链接
            Connection conn = DriverManager.getConnection("jdbc:mysql://10.250.20.120:8066", "tan.li", "tan.liwriwriu24fjsw");
            //创建代表SQL语句的对象
            Statement stmt = conn.createStatement();

//            stmt.setFetchSize(10000);
            stmt.setFetchSize(Integer.MIN_VALUE);

            //执行SQL语句
            ResultSet rs = stmt.executeQuery("SELECT * FROM bill_shop_balance_diff  WHERE company_no IN('D0007','D0001') AND zone_no='D' AND status='0' AND diff_date BETWEEN '2015-01-01' AND '2019-01-01' ");
//            ResultSet rs = stmt.executeQuery("SELECT * FROM bill_buy_balance limit 100000");


            //如果是查询语句，需要遍历结果集
            List<Map<String, String>> lis=new ArrayList<>();
            int i=0;
            while (rs.next()) {
                System.out.print("行号："+i+"-------------------------");
                System.out.println(rs.getObject("id")+"------"+rs.getObject("balance_no"));
                Map<String, String> m=new LinkedHashMap<>();
//                m.put("id",(String) rs.getObject("id"));
//                lis.add(m);

                i++;
            }
            //释放占用的资源
            rs.close();
            stmt.close();
            conn.close();


            try {
//                String[] titles = {"id"};
//                String[] propertys = {"id"};
//                exportCsv(titles, propertys, lis);
//                List exportData, LinkedHashMap map, String outPutPath,
//                        String fileName
//                LinkedHashMap map=new LinkedHashMap<>();
//                map.put("id","id");
//                CSVUtils.createCSVFile(lis,map,"/Users/tanli/testtemp/","test");
            }catch (Exception e){
                System.out.println("输出csv异常");
            }
        }


    /**
     *
     * 导出生成csv格式的文件
     * @author   ccg
     * @param   titles csv格式头文
     * @param   propertys 需要导出的数据实体的属性，注意与title一一对应
     * @param   list 需要导出的对象集合
     * @return
     * @throws   IOException
     * Created   2017年1月5日 上午10:51:44
     * @throws   IllegalAccessException
     * @throws   IllegalArgumentException
     */
    public static <T> String exportCsv(String[] titles, String[] propertys, List<T> list) throws IOException, IllegalArgumentException, IllegalAccessException{
        File file = new File("/Users/tanli/testtemp/test.csv");
        //构建输出流，同时指定编码
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

        //csv文件是逗号分隔，除第一个外，每次写入一个单元格数据后需要输入逗号
        for(String title : titles){
            ow.write(title);
            ow.write(",");
        }
        //写完文件头后换行
        ow.write("\r\n");
        //写内容
        for(Object obj : list){
            //利用反射获取所有字段
            Field[] fields = obj.getClass().getDeclaredFields();
            for(String property : propertys){
                for(Field field : fields){
                    //设置字段可见性
                    field.setAccessible(true);
                    if(property.equals(field.getName())){
                        ow.write(field.get(obj).toString());
                        ow.write(",");
                        continue;
                    }
                }
            }
            //写完一行换行
            ow.write("\r\n");
        }
        ow.flush();
        ow.close();
        return "0";
    }




    }



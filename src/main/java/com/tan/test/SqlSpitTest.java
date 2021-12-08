package com.tan.test;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @ClassName SqlSpit
 * @Description TODO
 * @Author tanli
 * @Date 2021/11/23
 * @Since 1.0
 */
public class SqlSpitTest {


    public static void main(String[] args) throws SQLException {
        String ssmp="id,balance_no,bill_type,biz_type,buyer_no,buyer_name,saler_no,saler_name";
        String sql="SELECT * FROM bill_buy_balance limit 1000000";
        export(sql,ssmp);
    }


    public static void export(String sql,String ssmp) throws SQLException{
        //注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //获取与数据库的链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://10.234.6.51:8066", "retail_fas", "retail_fas");
        //创建代表SQL语句的对象
        Statement stmt = conn.createStatement();

        stmt.setFetchSize(100000);

        //执行SQL语句
//       ResultSet rs = stmt.executeQuery("SELECT * FROM bill_shop_balance_diff  WHERE company_no IN('D0007','D0001') AND zone_no='D' AND status='0' AND diff_date BETWEEN '2015-01-01' AND '2019-01-01' ");
        ResultSet rs = stmt.executeQuery(sql);
        //如果是查询语句，需要遍历结果集
        List<Map<String, String>> list = new ArrayList<>();
        LinkedHashMap keyMap =getStrMap(ssmp);
        int i = 0;
        while (rs.next()) {
            System.out.print("行号：" + i + "-------------------------");
            Map<String, String> map = new LinkedHashMap<>();
            keyMap.forEach((key,val)->{
                try {
                    map.put((String) val, (String) rs.getString((String) val));
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            list.add(map);
            i++;
        }
        //释放占用的资源
        rs.close();
        stmt.close();
        conn.close();


        try {
            createCSVFile(list, keyMap, "/Users/tanli/testtemp/", "test");
        } catch (Exception e) {
            System.out.println("输出csv异常");
        }
    }

    /**
     * 生成CVS文件
     *
     * @param exportData 源数据List
     * @param map        csv文件的列表头map
     * @param outPutPath 文件路径
     * @param fileName   文件名称
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath,
                                     String fileName) {
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            //定义文件名格式并创建
            csvFile = new File(outPutPath + fileName + ".csv");
            file.createNewFile();
            // UTF-8使正确读取分隔符","
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            //写入前段字节流，防止乱码
            csvFileOutputStream.write(getBOM());
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext(); ) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext(); ) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext(); ) {
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                    String str = row != null ? ((String) ((Map) row).get(propertyEntry.getKey())) : "";
                    if (StringUtils.isEmpty(str)) {
                        str = "";
                    } else {
                        str = str.replaceAll("\"", "\"\"");
                        if (str.indexOf(",") >= 0) {
                            str = "\"" + str + "\"";
                        }
                    }
                    csvFileOutputStream.write(str);
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }


    /**
     * 功能说明：获取UTF-8编码文本文件开头的BOM签名。
     * BOM(Byte Order Mark)，是UTF编码方案里用于标识编码的标准标记。例：接收者收到以EF BB BF开头的字节流，就知道是UTF-8编码。
     *
     * @return UTF-8编码文本文件开头的BOM签名
     */
    public static String getBOM() {
        byte b[] = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        return new String(b);
    }

    /**
     * @MethodName getStringMap
     * @param    str
     * @return java.util.LinkedHashMap
     * @Author tanli
     * @Date 2021/11/25 3:25 下午
     * @throws
     * @Description TODO  String --->String[] ---> LinkedHashMap
     */
    public static LinkedHashMap getStrMap(String str){
        LinkedHashMap map = new LinkedHashMap<>();
        String[] list=str.split(",");
        for (int i = 0; i < list.length; i++) {
            map.put(list[i],list[i]);
        }
        return map;
    }


}



package com.tan.javatools.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FreemarkerDemo
 * @Description TODO
 * @Author Tan.li
 * @Date 2021-02-05
 * @Since 1.0
 */
public class FreemarkerDemo {

    private static final String TEMPLATE_PATH = "src/main/java/com/tan/com/tan/javatools/freemarker/templates";
    private static final String CLASS_PATH = "src/main/java/com/tan/com/tan/javatools/freemarker/outfile";


    public static void main(String[] args) {
        // step1 创建freeMarker配置实例  盛世
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String,Object>();
            dataMap.put("classPath", "com.tan.javatools.freemarker.outfile");
            dataMap.put("className", "AutoCodeDemo12");
            dataMap.put("helloWorld", "的HelloWorld！");
            // step4 加载模版文件
            Template template = configuration.getTemplate("java.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH + "//" + "AutoCodeDemo12.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("AutoCodeDemo.java 文件创建成功 !");
        } catch (
                Exception e) {
        }finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        }
    }


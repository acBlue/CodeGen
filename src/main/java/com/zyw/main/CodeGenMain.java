package com.zyw.main;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author zhangyaowen
 * @date 2022/9/29 11:08 AM
 */
public class CodeGenMain {

    public static void main(String[] args) {


        System.out.println(System.getProperty("user.dir"));

        String outPath = System.getProperty("user.dir")+"/out";

        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/ppp?serverTimezone=Asia/Shanghai", "root", "9689")
                .globalConfig(builder -> {
                    builder.author("zhangyaowen") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .dateType(DateType.ONLY_DATE)
                            .outputDir(outPath); // 指定输出目录

                })
                .packageConfig(builder -> {
                    builder.parent("com.samples.generator"); // 设置父包名

                         //   .moduleName("system") // 设置父包模块名
                        //    .pathInfo(Collections.singletonMap(OutputFile.entity, outPath)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_dept");// 设置需要生成的表名
                })
                .templateConfig(template ->{

                    template.disable(TemplateType.XML,TemplateType.CONTROLLER,TemplateType.MAPPER,TemplateType.SERVICE,TemplateType.SERVICE_IMPL);
                })
                .injectionConfig(inj ->{
                   //inj.customFile(new CustomFile());
                   // inj.customFile()
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();


    }
}

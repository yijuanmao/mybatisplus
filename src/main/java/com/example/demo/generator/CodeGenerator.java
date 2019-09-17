package com.example.demo.generator;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhener
 * @date 11:01 2019/8/22
 */
@Slf4j
public class CodeGenerator {

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入"+ tip + ":");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
//				.concat("/rayvision-commom");

		System.out.println( "项目路径地址 projectPath="+projectPath );

		System.out.println("----------------");
		gc.setOutputDir(projectPath + "/src/main/java");

		System.out.println(projectPath + "/src/main/java");
		gc.setAuthor("zengyi");	//作者
		gc.setOpen(false);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://61.144.203.38:13309/cbs?characterEncoding=utf-8&useSSL=false");
//        dsc.setSchemaName(public);
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("jeffery2016168!");
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(scanner("模块名"));
		pc.setParent("com.example.demo");
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};

		// 如果模板引擎是 freemarker
		String templatePath = "/templates/mapper.xml.ftl";

		// 如果模板引擎是 velocity
		// String templatePath = /templates/mapper.xml.vm;

		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名
				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
						+"/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});

		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();
		// 配置自定义输出模板
	/*	 templateConfig.setEntity("com.example.entity");
		 templateConfig.setService("");
		 templateConfig.setController("");*/

		templateConfig.setXml(null);
		mpg.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);			// 数据库表映射到实体的命名策略
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);	// 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
		strategy.setSuperEntityClass("com.example.demo.commom.entity.BaseEntity");	//自定义继承的Entity类全称，带包名
		strategy.setEntityLombokModel(true);	// 是否为lombok模型
		strategy.setRestControllerStyle(true);	// 生成 @RestController 控制器
		strategy.setEntityBooleanColumnRemoveIsPrefix(true); // Boolean类型字段是否移除is前缀
		//strategy.setSuperControllerClass("com.example.demo.base.BaseController");
		strategy.setInclude(scanner("表名"));
//		strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);		// 驼峰转连字符 如 umps_user 变为 upmsUser
//		strategy.setTablePrefix(pc.getModuleName() + "_");	// 表前缀
		strategy.setTablePrefix("t" + "_");	// 表前缀
		strategy.setLogicDeleteFieldName("d_flag");
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}

}

package com.example.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableMongoRepositories(basePackages = {"com.example.mongo.repository"})
@SpringBootApplication
public class DtaToStringJson1Application {

	public static Logger LOGGER = LoggerFactory.getLogger(DtaToStringJson1Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DtaToStringJson1Application.class, args);
		LOGGER.debug("Average finder v0.1");
		double avg = findAverage(new String[]{"1", "2", "3", "4","5"});
		LOGGER.info("Average is {}.", avg);

		/*long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		StringBuilder hello = new StringBuilder("Hello");
		hello.append(" ");
		hello.append("World!");
		//String hello = "Hello World!";
		LOGGER.info(hello.toString());
		List<String> list = DtaToStringJson1Application.getString();
		LOGGER.info(list.toString());
		hello = null;
		list = null;
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long actualMemUsed=afterUsedMem-beforeUsedMem;

		StringBuffer memoryInfo = new StringBuffer("Memory before: ");
		memoryInfo.append(beforeUsedMem);
		memoryInfo.append("|| Memory After: ");
		memoryInfo.append(afterUsedMem);
		memoryInfo.append("|| Memory Actual: ");
		memoryInfo.append(actualMemUsed);
		
		
		LOGGER.info(memoryInfo.toString());
		memoryInfo = null;
*/
	}
	
	private static double findAverage(String[] input){
		double result = 0;
		for(String num: input){
			result += Integer.parseInt(num);
		}
		return result/ input.length;
	}


	private static List<String> getString(){
		List<String> list = new ArrayList<String>();
		for(int i = 1; i < 10000; i++) {
			list.add(new StringBuffer(".").toString());
		}
		
		return list;
	}
	
}

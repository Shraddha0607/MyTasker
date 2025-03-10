package com.shraddha.ToDoApplication;

//import com.shraddha.ToDoApplication.controller.TaskController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Slf4j
public class ToDoApplication {

	// this we can mention or give above annotation
//	private static final Logger log = LoggerFactory.getLogger(ToDoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ToDoApplication.class, args);

//		log.info("to do application started");
//		log.trace("it is the trace");
//		log.info("it is info");
//		log.warn("it is warning");
//		log.error("it is error");
	}

}

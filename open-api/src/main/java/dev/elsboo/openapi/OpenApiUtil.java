package dev.elsboo.openapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
public class OpenApiUtil {

	public static void main() {
		log.info("OpenApi called");
	}

	public static void fail() {
		log.info("OpenApi failed");
	}
}

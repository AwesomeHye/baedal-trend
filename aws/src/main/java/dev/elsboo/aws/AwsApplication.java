package dev.elsboo.aws;

import dev.elsboo.openapi.OpenApiUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsApplication {

	public static void main(String[] args) {
		System.out.println(OpenApiUtil.main(10));
	}

}

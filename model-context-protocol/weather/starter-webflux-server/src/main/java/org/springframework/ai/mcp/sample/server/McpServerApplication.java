package org.springframework.ai.mcp.sample.server;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class McpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpServerApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider weatherTools(WeatherService weatherService) {
		return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
	}

	public record TextInput(String input) {
	}

	@Bean
	public ToolCallback toLowerCase() {
		return FunctionToolCallback.builder("toLowerCase", (TextInput input) -> input.input().toLowerCase())
			.inputType(TextInput.class)
			.description("Put the text to lower case")
			.build();
	}

}


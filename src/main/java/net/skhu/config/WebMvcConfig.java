package net.skhu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.skhu.Interceptor.AuthInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor())
				.addPathPatterns("/sugang/**")		// 해당 경로에 접근하기 전에 인터셉터가 가로챈다.
				.excludePathPatterns("/student/login"); // 해당 경로는 인터셉터가 가로채지 않는다.

	}
}

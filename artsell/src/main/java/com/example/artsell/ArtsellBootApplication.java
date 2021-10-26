package com.example.artsell;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.example.artsell.service.ArtSellFacade;

@SpringBootApplication
public class ArtsellBootApplication implements CommandLineRunner{

	@Autowired
	ArtSellFacade artSell;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ArtsellBootApplication.class, args);
	}

	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		artSell.initScheduler();
	}

	/*
	 * @Bean public Filter characterEncodingFilter() { CharacterEncodingFilter
	 * characterEncodingFilter = new CharacterEncodingFilter();
	 * characterEncodingFilter.setEncoding("UTF-8");
	 * characterEncodingFilter.setForceEncoding(true); return
	 * characterEncodingFilter; }
	 */
}

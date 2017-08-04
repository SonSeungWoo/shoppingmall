package com.ssw.shoppingmall;

import com.ssw.shoppingmall.domain.Account;
import com.ssw.shoppingmall.domain.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ShoppingmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingmallApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
		return args -> Stream.of("seungwoo", "wonwoo")
                .map(Account::new)
                .forEach(accountRepository::save);
	}*/
}

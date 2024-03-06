package com.elizier.testeMVN;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.elizier.testeMVN.application.adaptadores.controllers.FreteController;

@SpringBootTest
class TesteMvnApplicationTests {

	static FreteController freteController;

	@BeforeAll
	public static void start()
	{
	}


	@Test
	void contextLoads() {
//		freteController.buscarFrete();
		System.out.println("aqui dentro");
	}

}

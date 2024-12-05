package Teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabela {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hospital");
		factory.close();
	}

}

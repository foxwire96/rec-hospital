package action;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Paciente;

public class InserirPaciente extends Paciente{

	public InserirPaciente(String nome, int idade, String cpf, String email, String nascimento, String diagnostico,
			String endereco, String naturalidade) {
		super(nome, idade, cpf, email, nascimento, diagnostico, endereco, naturalidade);
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bem vindo!");
		System.out.println("Qual nome do paciente?");
		String nome = scanner.nextLine();
		
		System.out.print("Digite a data de nascimento do paciente: ");
        String nascimento  = scanner.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Digite o email do paciente: ");
        String email = scanner.nextLine();
        
        System.out.print("Digite a naturalidade do paciente: ");
        String naturalidade = scanner.nextLine();
        
        System.out.print("Digite o diagnostico do paciente: ");
        String diagnostico = scanner.nextLine();
        
        System.out.print("Digite o endereço do paciente: ");
        String endereco = scanner.nextLine();
        
		System.out.println("Paciente salvo com sucesso");
        
		 Paciente paciente = new Paciente(nome, 0, endereco, nascimento, cpf, diagnostico, naturalidade, email);
	        paciente.setNome(nome);
	        paciente.setEndereco(endereco);
	        paciente.setNascimento(nascimento);
	        paciente.setCpf(cpf);
	        paciente.setDiagnostico(diagnostico);
	        paciente.setNaturalidade(naturalidade);
	        paciente.setEmail(email);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("paciente");
		EntityManager manager = factory.createEntityManager();
		try {
            manager.getTransaction().begin();
            manager.persist(paciente);
            manager.getTransaction().commit();

            System.out.println("Paciente inserido com sucesso, ID: " + paciente.getId());
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.err.println("Erro ao inserir o paciente: " + e.getMessage());
        } finally {
            manager.close();
            factory.close();
            scanner.close();
        }
    }
}
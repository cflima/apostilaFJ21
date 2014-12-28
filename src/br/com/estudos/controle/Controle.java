package br.com.estudos.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.estudos.DAO.ContatoDAO;
import br.com.estudos.modelo.Contato;

public class Controle {

	public static void inserir() {

		Scanner sc = new Scanner(System.in);
		Contato contato = new Contato();

		System.out.println("Nome: ");
		contato.setNome(sc.nextLine());
		System.out.println("Data de Nascimento: ");
		contato.setDtNascimento(sc.nextLine());
		System.out.println("Email: ");
		contato.setEmail(sc.nextLine());
		System.out.println("Endereço: ");
		contato.setEndereco(sc.nextLine());

		ContatoDAO dao = new ContatoDAO();
		dao.inserir(contato);

	}

	public static void alterar() {

		Scanner sc = new Scanner(System.in);
		Contato contato = new Contato();

		System.out.println("Nome: ");
		contato.setNome(sc.nextLine());
		System.out.println("Email: ");
		contato.setEmail(sc.nextLine());
		System.out.println("Endereço: ");
		contato.setEndereco(sc.nextLine());
		System.out.println("Digite id do contato a ser alterado:");
		contato.setId(sc.nextInt());

		ContatoDAO dao = new ContatoDAO();
		dao.alterarContato(contato);

	}

	public static List<Contato> listarContatos() {

		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = dao.lista();

		for (Contato con : contatos) {
			System.out.println("ID: " + con.getId() + " Nome: " + con.getNome()
					+ " Email: " + con.getEmail() + " Endereço: "
					+ con.getEndereco());
		}

		return contatos;
	}

	public static void deletarContato() {

		Scanner sc = new Scanner(System.in);
		ContatoDAO dao = new ContatoDAO();
		int id;

		System.out.println("Digite o ID do contato a ser excluído");
		id = sc.nextInt();
		dao.excluirContato(id);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 5) {

			System.out.println("Escolha a opção a ser executada!");
			System.out.println("1-INSERIR 2-ALTERAR 3-LISTAR 4-DELETAR 5-SAIR");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:

				inserir();
				System.out.println("Usuário inserido com sucesso!");
				break;
			case 2:
				alterar();
				System.out.println("Usuário alterado com sucesso!");
				break;
			case 3:
				listarContatos();
				break;
			case 4:
				deletarContato();
				System.out.println("Usuário deletado com Sucesso!");
				break;
			case 5:
				System.out.println("Volte sempre");
				break;
			default:
				System.out
						.println("Opção excolhida não existe, tente novamente!");
				break;
			}

		}
	}
}

package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.ItemOrdem;
import entidade.Ordem;
import entidade.Produto;
import entidade.enums.StatusOrdem;

public class Programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com registro do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data de nascimento (DD/MM/YYYY): ");
		Date dataNascimento = sdf.parse(sc.next());
		System.out.println("Entre com registro de ordem:");
		System.out.print("Status: ");
		String status = sc.next();
		Ordem ordem = new Ordem(new Date(), StatusOrdem.valueOf(status), new Cliente(nome, email, dataNascimento));
		System.out.print("Quantos items a registrar nessa ordem? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Entre com o registro #" + i + ": ");
			System.out.print("Nome do produto: ");
			String produto = sc.next();
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidadeProduto = sc.nextInt();
			ItemOrdem item = new ItemOrdem(quantidadeProduto, precoProduto, new Produto(produto, precoProduto));
			ordem.adcItem(item);	
		}
		
		System.out.println(ordem);
		
		sc.close();

	}

}

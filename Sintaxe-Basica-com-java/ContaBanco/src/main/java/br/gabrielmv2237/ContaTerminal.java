package main.java.br.gabrielmv2237;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
	/*	Por motivos de Desafio meu, estou fazendo mais complexo, ja projetei coisas mais complexa, porem nao quero sair muito do escopo do desafio	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String nomeCliente;
		int agencia = 0;
		int numero = 0;
		int tentativa = 0;
		Double saldo;

		System.out.println("Por favor, fale seu nome!");
		nomeCliente = scanner.next();
		
		do {
			try {
				
				System.out.print("Por favor, digite o número da Agência !");
				agencia = scanner.nextInt();
				break;
				
			} catch (InputMismatchException e) {
					
				if (tentativa++ != 2) {
					System.out.println("Entrada inválida! Digite apenas números.");
					scanner.next();
				}else {
					System.out.println("Por motivas de tentativas falhas, você ira ser removido do sistema, tente novamente mais tarde!");
					System.exit(0);
				}
					
				}
			} while (true);
		
		tentativa = 0;
		do {
			try {
				
				System.out.print("Digite o numero da conta ");
				numero = scanner.nextInt();
				break;
				
			} catch (InputMismatchException e) {
					
				if (tentativa++ != 2) {
					System.out.println("Entrada inválida! Digite apenas números.");
					scanner.next();
				}else {
					System.out.println("Por motivas de tentativas falhas, você ira ser removido do sistema, tente novamente mais tarde!");
					System.exit(0);
				}
					
				}
			} while (true);
		
		tentativa = 0;
		do {
			try {
				
				
				System.out.println("Por favor, informe seu saldo!");
				saldo = scanner.nextDouble();
				break;

			} catch (InputMismatchException e) {
				
				if (tentativa++ != 2) {
					System.out.println("Entrada inválida! Digite apenas números.");
					scanner.next();
				}else {
					System.out.println("Por motivas de tentativas falhas, você ira ser removido do sistema, tente novamente mais tarde!");
					System.exit(0);
				}
				
			}

		} while (true);

		System.out.printf(
				"Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque",
				nomeCliente, agencia, numero, saldo);

	}

}

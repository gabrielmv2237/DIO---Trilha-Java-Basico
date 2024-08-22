package controle_de_Fluxo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int parametroUm = 0;
		int parametroDois = 0;

		try {
			try {
				parametroUm = 0;
				parametroDois = 0;
				System.out.println("Digite o primeiro parâmetro");
				parametroUm = sc.nextInt();
				System.out.println("Digite o segundo parâmetro");
				parametroDois = sc.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println(ex + " = Caracter inserido não é um inteiro.");
				System.exit(0);
			}

			// chamando o método contendo a lógica de contagem

			contar(parametroUm, parametroDois, sc);

		} catch (ParametrosInvalidosException ex) {
			// imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
			System.out.println("O segundo parâmetro deve ser maior que o primeiro");
		}

	}

	static void contar(int parametroUm, int parametroDois, Scanner sc) throws ParametrosInvalidosException {
		if (parametroUm >= parametroDois) {
			throw new ParametrosInvalidosException();
		} else {
			// realizar o for para imprimir os números com base na variável contagem
			int contagem = parametroDois - parametroUm;

			System.out.println(
					"Duas opções para contagem, minha interpretação é o numero 1, fazendo a risca do codigo dado numero 2.");
			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				for (int i = parametroUm; i <= parametroDois; i++) {
					System.out.println("Imprimindo o número " + i);
				}
				break;
			case 2:
				for (int i = 1; i <= contagem; i++) {
					System.out.println("Imprimindo o número " + i);

				}
			}
		}

	}
}

package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;
import model.excecao.DominioException;

public class Programa {

	public static void main(String[] args) {

		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do quarto: ");
			int num = tec.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date entrada = sdf.parse(tec.next());
			System.out.print("Data da saída (dd/MM/yyyy): ");
			Date saida = sdf.parse(tec.next());

			Reserva reserva = new Reserva(num, entrada, saida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Atualizar dados de uma nova reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(tec.next());
			System.out.print("Data da saída (dd/MM/yyyy): ");
			saida = sdf.parse(tec.next());

			reserva.dataAtualizada(entrada, saida);
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Formato da data inválido");
		} catch (DominioException e) {
			System.out.println("Erro ao fazer a reserva: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		

		tec.close();

	}

}

import java.util.Scanner;
public class Programa
{
	public static void main(String[] args)
	{
		try
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Digite o caminho do arquivo:");
			String nomeArq = scan.nextLine();

			TratadorDeArquivo tratador = new TratadorDeArquivo();
			Matriz matriz = tratador.ler(nomeArq);
			EscalonamentoMatriz sistema = new EscalonamentoMatriz(matriz);

			sistema.verificarExistencia();
			sistema.retirarZerosDiagonalPrincipal();
			for(int i = 0; i < sistema.getMatriz().getNumeroDeLinhas();i++)
			{
				sistema.dividirLinhaPorElemDiagonalPrincipal(i);
				sistema.deixarNumsComValor0(i);
			}
			Matriz resultado = sistema.minhaCloneDeMatriz();
			double[] resul = new double[resultado.getNumeroDeLinhas()];
			resul = resultado.getColuna(resultado.getNumeroDeColunas());
			System.out.println("Resultados: \n");
			for(int i = 0; i < resul.length; i++)
				System.out.println(i+"- "+resul[i]);
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
	}
}
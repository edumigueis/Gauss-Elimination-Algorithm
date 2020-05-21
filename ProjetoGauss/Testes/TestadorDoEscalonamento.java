public class TestadorDoEscalonamento
{
	public static void main(String[] args)
	{
		try
		{
			//teste funcional
			//---------------------------------------------------------
			TratadorDeArquivo tratador = new TratadorDeArquivo();
			Matriz matriz = tratador.ler("input2.txt");
			EscalonamentoMatriz sistema = new EscalonamentoMatriz(matriz);

			sistema.verificarExistencia();
			System.out.println(sistema.getMatriz().toString());
			sistema.retirarZerosDiagonalPrincipal();
			System.out.println(sistema.getMatriz().toString());
			for(int i = 0; i < sistema.getMatriz().getNumeroDeLinhas();i++)
			{
				sistema.dividirLinhaPorElemDiagonalPrincipal(i);
				System.out.println(sistema.getMatriz().toString());
				sistema.deixarNumsComValor0(i);
				System.out.println(sistema.getMatriz().toString());
			}
			//teste das exceções
			//-----------------------------------------------------------
			TratadorDeArquivo tratadorErr = new TratadorDeArquivo(); // obs: o TratadorDeArquivo foi testado no arquivo TestadorDeMatriz.java
			Matriz matrizErr = tratadorErr.ler("inputErr.txt");
			EscalonamentoMatriz sistemaErr = new EscalonamentoMatriz(matrizErr);

			//leitura correta
			Matriz matriz2 = tratadorErr.ler("gauss.txt");
			EscalonamentoMatriz sistema2 = new EscalonamentoMatriz(matriz2);

			// todos os métodos chamados por sistemas inválidos lançam exceção
			sistemaErr.verificarExistencia(); //lançará exceção pois o arquivo lido é inválido em sua formatação

			System.out.println(sistema.getMatriz().toString());
			sistema2.retirarZerosDiagonalPrincipal();
			System.out.println(sistema.getMatriz().toString());
			sistema2.dividirLinhaPorElemDiagonalPrincipal(-1);// lança exceção, pois coluna < 0 é inválido
			sistema2.deixarNumsComValor0(-1);//// lança exceção, pois coluna < 0 é inválido
			for(int i = 0; i < sistema.getMatriz().getNumeroDeLinhas();i++)
			{
				sistema2.dividirLinhaPorElemDiagonalPrincipal(i);
				System.out.println(sistema.getMatriz().toString());
				sistema2.deixarNumsComValor0(i);
				System.out.println(sistema.getMatriz().toString());
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
	}
}
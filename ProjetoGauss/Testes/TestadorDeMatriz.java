public class TestadorDeMatriz
{
	public static void main(String[] args)
	{
		try
		{
			//---------------------------------------------------------------------------------
			//testa o TratadorDeArquivo
			String nomeArq = "teste.txt";
			TratadorDeArquivo leitor = new TratadorDeArquivo();
			Matriz mat2 = new Matriz(3);
			mat2 = leitor.ler(nomeArq);
			System.out.print("Matriz lida do arquivo:\n"+mat2.toString());
			System.out.print("Quantidade de equações:"+leitor.getQtdEquacoes()+"\n");

			TratadorDeArquivo leitorErr = new TratadorDeArquivo();
			mat2 = leitorErr.ler("inexistente.txt"); // lança exceção

			//---------------------------------------------------------------------------------
			//testa a Matriz

				//testa o construtor e o getElem
				Matriz mat = new Matriz(3);
				double tst2 = mat2.getElem(0,2);
				System.out.println("Teste 2:"+tst2);

				/*
				Matriz matErrada = new Matriz(-1); // lança exceção
				Matriz matErrada2 = new Matriz(0); // lança exceção
				Matriz matErrada3 = new Matriz(1); // lança exceção
				*/

				//testa o método setLinha
				double[] vetLinha = new double[4];
				vetLinha[0] = 8.0;
				vetLinha[1] = 7.1;
				vetLinha[2] = 1.2;
				vetLinha[3] = 4.0;
				mat.setLinha(1,vetLinha);
				System.out.println(mat.toString());

				double[] vetErrado = new double[3];
				vetErrado[0] = 8.0;
				vetErrado[1] = 7.1;
				vetErrado[2] = 1.2;
				mat.setLinha(1,vetErrado); // joga exceção

				//testa o método inserirElem, getElem e setColuna
				mat.inserirElem(1,1, mat.getElem(2,3));
				//mat.inserirElem(10,10,3); // lança exceção
				//mat.inserirElem(-2,-1,7); // lança exceção
				double[] vet = new double[3];
				vet[0] = 8.0;
				vet[1] = 7.7;
				vet[2] = 4.2;
				mat.setColuna(1,vet);
				System.out.print(mat.toString());

				double[] vetErrado1 = new double[2];
				vetErrado1[0] = 8.0;
				vetErrado1[1] = 7.1;
				mat.setColuna(1,vetErrado1); // lança exceção

				//testa o método setDiagonalPrincipal e getDiagonalPrincipal
				mat.setDiagonalPrincipal(vet);
				double[] vetDiag  = new double[2];
				vetDiag = mat.getDiagonalPrincipal();

				for(int i = 0; i < vetDiag.length; i++)
				System.out.println(vetDiag[i]);

				// testa o método getNumeroDeLinhas e getNumeroDeColunas
				System.out.println("número de linhas: "+ mat.getNumeroDeLinhas());
				System.out.println("número de colunas: "+ mat.getNumeroDeColunas());

				//testa o clone
				System.out.println(mat.clone().toString());
				//---------------------------------------------------------------------

		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
	}
}
public class Testador
{
	public static void main(String[] args)
	{
		try
		{
			String nomeArq = "gauss.txt";
			TratadorDeArquivo leitor = new TratadorDeArquivo();
			Matriz mat2 = new Matriz(3);
			mat2 = leitor.ler(nomeArq);
			Matriz mat = new Matriz(3);
			double tst2 = mat2.getElem(0,2);
			System.out.println("Teste 2:"+tst2);
			double[] vetLinha = new double[4];
			vetLinha[0] = 8.0;
			vetLinha[1] = 7.1;
			vetLinha[2] = 1.2;
			vetLinha[3] = 4.0;
			mat.setLinha(1,vetLinha);
			System.out.println(mat.toString());
			mat.inserirElem(1,1, 9.0);
			double[] vet = new double[3];
			vet[0] = 8.0;
			vet[1] = 7.7;
			vet[2] = 4.2;
			System.out.print(mat.toString());
			mat.setColuna(1,vet);
			double tst = mat.getElem(1,1);
			System.out.print(tst);

		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
	}
}
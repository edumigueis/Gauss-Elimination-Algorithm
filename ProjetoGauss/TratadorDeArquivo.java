import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
A classe Tratador de Arquivo representa um leitor arquivos de texto implemementado
tendo como base um int que respresenta quantas equações serão lidas e um vetor que armazena as linhas da equação.
Instâncias desta classe permitem a relização da leitura de um arquivo com formatação de matriz.
Nela encontramos, por exemplo, métodos para ler arquivos com formatação de sistemas de primeiro grau.

@author Eduardo Migueis e Enzo Spinella
@since 2019
*/
public class TratadorDeArquivo implements Cloneable
{
	// Leitor do arquivo
	protected BufferedReader arquivo;
    //int que representa a quantidade de equações do sistema lido.
    protected int qtdEquacoes;

    /**
     * Constroi uma nova instância da classe TratadorDeArquivo.
     * Para tanto, não será fornecida a fonte do arquivo, que será passada posteriormente, deixando-nos adotar a quantidade de equações como 0 e resetando o vetor de equações.
     */
    public TratadorDeArquivo()
    {
        qtdEquacoes = 0;
    }


    /**
     * Lê um arquivo texto, dada a sua fonte.
     * Coloca nas variáveis qtdEquacoes e vetorEquacoes as informações lidas do arquivo texto.
     * @param nomeArq a fonte do arquivo a ser lido.
     * @return mat objeto da clase matriz no qual os valores lidos do arquivo são inseridos.
     * @throws Exception se não for fornecida uma fonte ou se o arquivo estiver formatado de forma errada.
     */
    public Matriz ler(String nomeArq) throws Exception
    {
        if(nomeArq == null || nomeArq.equals(""))
            throw new Exception("A fonte do arquivo é inválida");

        try
        {
            arquivo = new BufferedReader(new FileReader(nomeArq)); //Cria um leitor de arquivo

            this.qtdEquacoes = Integer.parseInt(arquivo.readLine()); //Coloca na variável de quantidade a primeira linha convertida para int do arquivo
            if(this.qtdEquacoes < 2)
                throw new Exception("Número insuficiente de equações");
        String line;
		StringTokenizer st;

		Matriz mat = new Matriz(qtdEquacoes);

            for (int i = 0; i < this.qtdEquacoes; i++) {
						line = arquivo.readLine();
						st = new StringTokenizer(line); // pega as variaveis separadas por um espaço
						for (int j = 0; j < qtdEquacoes+1; j++) {
							mat.inserirElem(i,j,Double.parseDouble(st.nextToken())); //insiro todos os elementos do arquivo em uma instância da classe matriz
						}
			}
			arquivo.close();
			return mat;

        }
        catch(Exception ex) //Caso dê algúm erro
        {
            throw new Exception(ex);
        }
    }
    /**
     * Coleta a quantidade de equações.
     * Retorna a quantidade de equações lidas do arquivo texto.
     * @return a quantidade de equações, que é um inteiro.
     */
    public int getQtdEquacoes()
    {
        return qtdEquacoes;
    }

    /**
     * Gera uma representação textual de todo conteúdo do leitor de arquivos de sistemas de equação.
     * Produz e resulta um String com todas as equações e a quantidade delas contidas do leitor.
     * @return um String contendo todo conteúdo do leitor de arquivos de sistemas de equação.
     */
    public String toString()
    {
        String ret = "Quantidade: " + this.qtdEquacoes + "\n\n";
        return ret;
    }

    /**
     * Calcula o código de espalhamento (ou código de hash) de um leitor de arquivos de sistemas de equação.
     * Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
     * hashcode) do leitor de arquivos de sistemas de equação representado pela instância chamante do método.
     * @return o código de espalhamento do leitor de arquivos de sistemas de equação chamante do método.
     */
    public int hashCode()
    {
        int ret = 13;

        ret = ret * 13 + new Integer(this.qtdEquacoes).hashCode();
        ret = ret * 13 + arquivo.hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }
     /**
	     * Constroi uma cópia da instância da classe TratadorDeArquivo dada.
	     * Para tanto, deve ser fornecida uma instancia da classe TratadorDeArquivo para ser
	     * utilizada como modelo para a construção da nova instância criada.
	     * @param modelo a instância da classe TratadorDeArquivo a ser usada como modelo.
	     * @throws Exception se o modelo for null.
	     */
	    public TratadorDeArquivo(TratadorDeArquivo modelo) throws Exception
	    {
	        if(modelo == null)
	            throw new Exception("O modelo era null");

	        this.qtdEquacoes = modelo.qtdEquacoes;
	        this.arquivo = modelo.arquivo;
    }

    /**
     * Constroi uma cópia deste TratadorDeArquivo.
     * Utiliza o construtor de cópia para gerar uma cópia de this.
     * @return a cópia deste TratadorDeArquivo como Object.
     */
    public Object clone()
    {
        TratadorDeArquivo ret = null;
        try
        {
            ret = new TratadorDeArquivo(this);
        }
        catch(Exception ex)
        {}

        return ret;
    }

    /**
     * Verifica a igualdade entre dois TratadorDeArquivo.
     * Verifica se o Object fornecido como parâmetro representa um
     * TratadorDeArquivo igual àquele representado pela instância chamante, resultando true em caso afirmativo,
     * ou false, caso contrário.
     * @param  obj o objeto a ser comparado com a instância à qual esse método
     * for aplicado.
     * @return true, caso o Object fornecido ao método e a instância chamante do
     * método representarem TratadorDeArquivo iguais, ou false, caso contrário.
     */
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;

        if(obj.getClass() != this.getClass())
            return false;

        if(this == obj)
            return true;

        TratadorDeArquivo tratador = (TratadorDeArquivo)obj;

        if(this.qtdEquacoes != tratador.qtdEquacoes)
            return false;
        if(!this.arquivo.equals(tratador.arquivo))
        	return false;

        return true; //Último caso
    }
}
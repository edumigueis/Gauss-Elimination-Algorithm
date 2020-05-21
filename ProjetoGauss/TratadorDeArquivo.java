import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
A classe Tratador de Arquivo representa um leitor arquivos de texto implemementado
tendo como base um int que respresenta quantas equa��es ser�o lidas e um vetor que armazena as linhas da equa��o.
Inst�ncias desta classe permitem a reliza��o da leitura de um arquivo com formata��o de matriz.
Nela encontramos, por exemplo, m�todos para ler arquivos com formata��o de sistemas de primeiro grau.

@author Eduardo Migueis e Enzo Spinella
@since 2019
*/
public class TratadorDeArquivo implements Cloneable
{
	// Leitor do arquivo
	protected BufferedReader arquivo;
    //int que representa a quantidade de equa��es do sistema lido.
    protected int qtdEquacoes;

    /**
     * Constroi uma nova inst�ncia da classe TratadorDeArquivo.
     * Para tanto, n�o ser� fornecida a fonte do arquivo, que ser� passada posteriormente, deixando-nos adotar a quantidade de equa��es como 0 e resetando o vetor de equa��es.
     */
    public TratadorDeArquivo()
    {
        qtdEquacoes = 0;
    }


    /**
     * L� um arquivo texto, dada a sua fonte.
     * Coloca nas vari�veis qtdEquacoes e vetorEquacoes as informa��es lidas do arquivo texto.
     * @param nomeArq a fonte do arquivo a ser lido.
     * @return mat objeto da clase matriz no qual os valores lidos do arquivo s�o inseridos.
     * @throws Exception se n�o for fornecida uma fonte ou se o arquivo estiver formatado de forma errada.
     */
    public Matriz ler(String nomeArq) throws Exception
    {
        if(nomeArq == null || nomeArq.equals(""))
            throw new Exception("A fonte do arquivo � inv�lida");

        try
        {
            arquivo = new BufferedReader(new FileReader(nomeArq)); //Cria um leitor de arquivo

            this.qtdEquacoes = Integer.parseInt(arquivo.readLine()); //Coloca na vari�vel de quantidade a primeira linha convertida para int do arquivo
            if(this.qtdEquacoes < 2)
                throw new Exception("N�mero insuficiente de equa��es");
        String line;
		StringTokenizer st;

		Matriz mat = new Matriz(qtdEquacoes);

            for (int i = 0; i < this.qtdEquacoes; i++) {
						line = arquivo.readLine();
						st = new StringTokenizer(line); // pega as variaveis separadas por um espa�o
						for (int j = 0; j < qtdEquacoes+1; j++) {
							mat.inserirElem(i,j,Double.parseDouble(st.nextToken())); //insiro todos os elementos do arquivo em uma inst�ncia da classe matriz
						}
			}
			arquivo.close();
			return mat;

        }
        catch(Exception ex) //Caso d� alg�m erro
        {
            throw new Exception(ex);
        }
    }
    /**
     * Coleta a quantidade de equa��es.
     * Retorna a quantidade de equa��es lidas do arquivo texto.
     * @return a quantidade de equa��es, que � um inteiro.
     */
    public int getQtdEquacoes()
    {
        return qtdEquacoes;
    }

    /**
     * Gera uma representa��o textual de todo conte�do do leitor de arquivos de sistemas de equa��o.
     * Produz e resulta um String com todas as equa��es e a quantidade delas contidas do leitor.
     * @return um String contendo todo conte�do do leitor de arquivos de sistemas de equa��o.
     */
    public String toString()
    {
        String ret = "Quantidade: " + this.qtdEquacoes + "\n\n";
        return ret;
    }

    /**
     * Calcula o c�digo de espalhamento (ou c�digo de hash) de um leitor de arquivos de sistemas de equa��o.
     * Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
     * hashcode) do leitor de arquivos de sistemas de equa��o representado pela inst�ncia chamante do m�todo.
     * @return o c�digo de espalhamento do leitor de arquivos de sistemas de equa��o chamante do m�todo.
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
	     * Constroi uma c�pia da inst�ncia da classe TratadorDeArquivo dada.
	     * Para tanto, deve ser fornecida uma instancia da classe TratadorDeArquivo para ser
	     * utilizada como modelo para a constru��o da nova inst�ncia criada.
	     * @param modelo a inst�ncia da classe TratadorDeArquivo a ser usada como modelo.
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
     * Constroi uma c�pia deste TratadorDeArquivo.
     * Utiliza o construtor de c�pia para gerar uma c�pia de this.
     * @return a c�pia deste TratadorDeArquivo como Object.
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
     * Verifica se o Object fornecido como par�metro representa um
     * TratadorDeArquivo igual �quele representado pela inst�ncia chamante, resultando true em caso afirmativo,
     * ou false, caso contr�rio.
     * @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
     * for aplicado.
     * @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
     * m�todo representarem TratadorDeArquivo iguais, ou false, caso contr�rio.
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

        return true; //�ltimo caso
    }
}
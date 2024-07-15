
public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();

	// funcionalidade PIX
	void atualizarChavePIX(String novaChavePIX);
	void transferirComPIX(double valor, String chavePIX) throws ContaInexistenteException;
}


public class Main {

	public static void main(String[] args) throws ContaInexistenteException {
		Banco banco = new Banco("PereiraBank");// obj que contém a List de Contas
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton, banco);
		Conta poupanca = new ContaPoupanca(venilton, banco);

		cc.depositar(100);
		// Teste transferencia com PIX
		poupanca.atualizarChavePIX("12345");
		cc.transferirComPIX(100, "12345");
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}

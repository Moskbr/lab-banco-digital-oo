
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	// adicionais
	protected Banco banco;// A conta precisa de uma referencia do Banco em que ela pertence
	protected String chavePIX;// para as funcionalidades PIX

	public Conta(Cliente cliente, Banco banco) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.banco = banco;
		banco.adicionarConta(this);
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		System.out.println("Transferência realizada!");
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	// implementações da funcionalidade PIX
	public String getChavePIX() {
		return chavePIX;
	}
	public void setChavePIX(String chavePIX) {
		this.chavePIX = chavePIX;
	}
	public void atualizarChavePIX(String novaChavePIX){
		this.chavePIX = novaChavePIX;
	}
	
	public void transferirComPIX(double valor, String chavePIX) throws ContaInexistenteException{
		Conta contaDestino = banco.obterContaPeloPIX(chavePIX);
		this.transferir(valor, contaDestino);
	}
}

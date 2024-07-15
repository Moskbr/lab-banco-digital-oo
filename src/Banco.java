import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String NomeBanco) {
		contas = new ArrayList<>();
		this.nome = NomeBanco;
	}
	public void adicionarConta(Conta conta){
		contas.add(conta);
	}
	public String getNome() {
		return nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Conta obterContaPeloPIX(String PIX) throws ContaInexistenteException{
		// para tratar um possivel retorno nulo, utiliza-se Optional<>
		Optional<Conta> contaPIX = contas.stream().filter((conta) -> PIX.equalsIgnoreCase(conta.getChavePIX())).findAny();
		if(contaPIX.isPresent())
			return contaPIX.get();
		else {
			System.out.println(" A Chave PIX que você digitou não foi cadastrada em nenhuma conta, ou");
			throw new ContaInexistenteException(this.nome);
		}
	}

}

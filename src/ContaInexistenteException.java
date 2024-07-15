public class ContaInexistenteException extends Exception {
    public ContaInexistenteException(String nomeBanco) {
        super();
        System.out.println("Conta inexistente no banco " + nomeBanco);
    }
}

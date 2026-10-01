package exerciciosSala.P3.src.model;

import exerciciosSala.P3.src.exception.DevolucaoInvalidaException;
import exerciciosSala.P3.src.exception.LimiteEmprestimosExcedidoException;
import exerciciosSala.P3.src.exception.UsuarioNaoCadastradoException;

import java.util.Map;
import java.util.*;

public class Biblioteca {

    public static final int MIN_COPIAS_PARA_PODER_EMPRESTAR = 2;
    public static final int MAX_LIVROS_DEVIDOS_POR_USUARIO = 3;

    private Map<Long, Pessoa> usuarioByCpf;  // mapa para guardar todos os usuários cadastrados (por cpf)
    private Map<String, Integer> quantidadeByLivro;
    private Map<Long, List<Livro>> LivrosEmprestadosByCpf;

    private int totalLivrosNasEstantes;  // contador para o total de livros nas estantes da biblioteca

    public Biblioteca(){
        this.usuarioByCpf = new HashMap<>();
        this.quantidadeByLivro = new HashMap<>();
        this.LivrosEmprestadosByCpf = new HashMap<>();
    }

    /**
     * Cadastra um novo usuário, caso não exista;
     * se já existir, atualiza seus dados, sobrescrevendo nome e endereço no objeto
     * que já existia com aquele CPF.
     *
     * @param usuario A Pessoa a ser cadastrada/atualizada como usuária desta biblioteca.
     */
    public void cadastrarUsuario(Pessoa usuario) {
        long cpf = usuario.getCpf();
        Pessoa usuarioExistente = this.usuarioByCpf.get(cpf);

        if (usuarioExistente == null) {
            // o usuário informado é novo; vamos cadastrá-lo
            this.usuarioByCpf.put(cpf, usuario);


        } else {
            // o usuário informado já existia; vamos atualizá-lo
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEndereco(usuario.getEndereco());
        }
    }

    public Pessoa getUsuario(long cpf){
        return this.usuarioByCpf.get(cpf);
    }

    public int getTotalDeUsuariosCadastrados(){
        return this.usuarioByCpf.size();
    }

    /**
     * Efetua a aquisição de certo número de cópias de um livro.
     *
     * @param livro O livro que desejamos adquirir.
     * @param quantidade A quantidade desejada, que será adquirida e acrescentada à quantidade já existente
     *                   daquele livro na biblioteca (se o livro já existir na biblioteca)
     */
    public void adquirirLivro(Livro livro, int quantidade) {
        if(quantidade >= 1) {
            int quantidadeAtual = this.quantidadeByLivro.getOrDefault(livro.getTitulo(), 0);
            this.quantidadeByLivro.put(livro.getTitulo(), quantidadeAtual + quantidade);
            this.totalLivrosNasEstantes += quantidade;
        }

        // Dica: adicione um Map quantidadeByLivro como atributo de Biblioteca.
    }

    /**
     * Efetua o empréstimo de uma unidade do livro informado para o usuário informado, reduzindo em uma unidade
     * a quantidade daquele livro nas estantes da biblioteca.
     *
     * @param livro O livro que se deseja tomar emprestado
     * @param usuario O usuário que deseja pegar emprestado o livro
     *
     * @return true, se o empréstimo for bem sucedido; false, caso a biblioteca não tenha em suas estantes
     *         a quantidade mínima do livro desejado para que ele possa ser emprestado
     *         (vide model.Biblioteca.MIN_COPIAS_PARA_PODER_EMPRESTAR)
     *
     * @throws UsuarioNaoCadastradoException se o usuário não for cadastrado nesta biblioteca
     * @throws LimiteEmprestimosExcedidoException se o usuário já está ultrapassou o número máximo permitido de
     *                                            livros emprestados nesta biblioteca para cada usuário
     */
    public boolean emprestarLivro(Livro livro, Pessoa usuario)
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException {
        long cpf = usuario.getCpf();
        if(this.usuarioByCpf.get(cpf) == null) {
            throw new UsuarioNaoCadastradoException();
        }
        List<Livro> emprestados = this.LivrosEmprestadosByCpf.getOrDefault(cpf, new ArrayList<>());
        if(emprestados.size() >= MAX_LIVROS_DEVIDOS_POR_USUARIO){
            throw new LimiteEmprestimosExcedidoException();
        }

        if(this.quantidadeByLivro.getOrDefault(livro.getTitulo(), 0) < MIN_COPIAS_PARA_PODER_EMPRESTAR){
            return false;
        }

        this.quantidadeByLivro.put(livro.getTitulo(), quantidadeByLivro.get(livro.getTitulo()) - 1);
        this.totalLivrosNasEstantes--;

        emprestados.add(livro);
        this.LivrosEmprestadosByCpf.put(cpf, emprestados);

        return true;
    }

    /**
     * Recebe de volta um livro que estava emprestado.
     *
     * @param livro O livro que o usuário está devolvendo
     * @param usuario O usuário que devolve o livro
     *
     * @throws DevolucaoInvalidaException caso o livro em questão não exista
     *                                    ou o livro não esteja emprestado para o usuário informado
     */
    public void receberDevolucaoLivro(Livro livro, Pessoa usuario)
            throws DevolucaoInvalidaException {
        long cpf = usuario.getCpf();
        if(quantidadeByLivro.get(livro.getTitulo()) == null){
            throw new DevolucaoInvalidaException();
        }
        List<Livro> emprestados = this.LivrosEmprestadosByCpf.get(cpf);
        if(emprestados == null || !emprestados.contains(livro)){
            throw new DevolucaoInvalidaException();
        }
        emprestados.remove(livro);
        this.quantidadeByLivro.put(livro.getTitulo(), this.quantidadeByLivro.get(livro.getTitulo()) + 1);
        this.totalLivrosNasEstantes++;

    }

    public int getQuantidadeDeLivrosDevidos(Pessoa usuario) {
        return this.LivrosEmprestadosByCpf.getOrDefault(usuario.getCpf(), new ArrayList<>()).size();
    }

    public int getQuantidadeDeLivrosNasEstantes() {
        // ****** NÃO MODIFIQUE ESSE MÉttODo! ******
        return totalLivrosNasEstantes;
    }

    public int getQuantidadeDeLivrosNasEstantes(Livro livro) {
        return quantidadeByLivro.getOrDefault(livro.getTitulo(), 0);
    }
}
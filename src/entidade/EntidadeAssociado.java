package entidade;


public class EntidadeAssociado {

    private int codigo;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private EntidadeTipoAssociado tipoAssociado;

    public EntidadeAssociado() {}
    public EntidadeAssociado(int codigo, String nome, String cpf, String endereco, String telefone,
			EntidadeTipoAssociado tipoAssociado) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.tipoAssociado = tipoAssociado;
	}
	public EntidadeAssociado(EntidadeTipoAssociado tipoAssociado) {
        this.tipoAssociado = tipoAssociado;
    }
    
    public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EntidadeTipoAssociado getTipoAssociado() {
        return tipoAssociado;
    }

    public void setTipoAssociado(EntidadeTipoAssociado tipoAssociado) {
        this.tipoAssociado = tipoAssociado;
    }
}

package memelandia.categorias.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "categorias")
public class Categoria {

    @Id
    private Long id;
    private String nome;
    private String descricao;
    private Date dataCadastro;
    private String idUsuario;

    public String getUsuario() {
        return idUsuario;
    }

    public void setUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Categoria() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }
}

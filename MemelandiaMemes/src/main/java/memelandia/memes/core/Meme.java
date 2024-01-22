package memelandia.memes.core;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "memes")
public class Meme {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Date dataCadastro;
    private String idCategoria;
    private String idUsuario;

    public Meme() {}

    public String getUsuario() {
        return idUsuario;
    }

    public void setUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCategoriaMeme() {
        return idCategoria;
    }

    public void setCategoriaMeme(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "Meme{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", idCategoria='" + idCategoria + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                '}';
    }
}

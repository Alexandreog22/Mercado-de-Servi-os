package br.com.mercadoservicos.controller;

import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.service.UsuarioService;
import br.com.mercadoservicos.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioController implements Serializable{
    
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private UsuarioService usuarioService = new UsuarioService();
    private Boolean desabilitaPF = false;
    
    
    public UsuarioController(){
        listar();
    }
    
    public void listar(){
        usuarios = usuarioService.listar();
    }
    
    public String novo(){
        usuario = new Usuario();
        usuario.setTipo("F");
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Usuario usuario){
        
        this.usuario = usuario;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if (usuarioService.inserir(usuario)){
            UtilMensagens.mensagemSucesso("Sucesso", "Usuario salva com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar a usuario!");
        return null;
    }
    
    public String alterar(){
        if (usuarioService.alterar(usuario)){
            this.listar();
            UtilMensagens.mensagemSucesso("Sucesso", "Usuario alterada com sucesso!");
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a usuario!");
        return null;
    }
    
    public String excluir(Usuario usuario){
        if (usuarioService.excluir(usuario)){
            this.listar();
            UtilMensagens.mensagemSucesso("Sucesso", "Usuario excluída com sucesso!");
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a usuario!");
        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuarios(Usuario usuario) {
        this.usuario = usuario;
    }    

    public Boolean getDesabilitaPF() {
        return desabilitaPF;
    }

    public void setDesabilitaPF(Boolean desabilitaPF) {
        this.desabilitaPF = desabilitaPF;
    }

    public void inverteTipo(){
        if(usuario.getTipo().equals("F")){
            desabilitaPF = false;
        }else{
            desabilitaPF = true;
        }
    }
    
    public String autenticar(){
        if(usuarioService.autenticar(usuario)){
            return "index.xhtml?faces-redirect=true";
        }else{
            UtilMensagens.mensagemErro("Dados inválidos!", "Usuário ou senha incorretos!");
            return null;
        }
    }
}

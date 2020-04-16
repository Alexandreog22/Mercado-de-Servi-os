package br.com.mercadoservicos.controller;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.domain.Servico;
import br.com.mercadoservicos.service.ServicoService;
import br.com.mercadoservicos.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="servicoMB")
@SessionScoped
public class ServicoController implements Serializable{
    
    private Servico servico = new Servico();
    private List<Servico> servicos;
    private ServicoService servicoService = new ServicoService();
    
    public ServicoController(){
        listar();
    }
    
    public void listar(){
        servicos = servicoService.listar();
    }
    
    public String novo(){
        servico = new Servico();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Servico servico){
        this.servico = servico;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if (servicoService.inserir(servico)){
            this.listar();
            UtilMensagens.mensagemSucesso("Sucesso", "Categoria salva com sucesso!");
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar a categoria!");
        return null;
    }
    
    public String alterar(){
        if(servicoService.alterar(servico)){
            this.listar();
            UtilMensagens.mensagemSucesso("Sucesso", "Categoria alterada com sucesso!");
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a categoria!");
        return null;
    }
    
    public String excluir(Servico servico){
        if(servicoService.excluir(servico)){
            this.listar();
            UtilMensagens.mensagemSucesso("Sucesso", "Categoria excluída com sucesso!");
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a categoria!");
        return null;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public ServicoService getServicoService() {
        return servicoService;
    }

    public void setServicoService(ServicoService servicoService) {
        this.servicoService = servicoService;
    }
    
    
}

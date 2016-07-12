package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ClientePrimeMB {
	public static List<Cliente> clientesBD = new ArrayList<>();
	
	private Cliente cliente = new Cliente();
	private DataModel<Cliente> clientes;
	
	public DataModel<Cliente> getClientes() {
		clientes = new ListDataModel<Cliente>(clientesBD);
		return clientes;
	}
	
	public void novo(ActionEvent evt) { cliente = new Cliente(); }
	
	public void setClientes(DataModel<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	
	public void prepararAlterarCliente(ActionEvent evt) {
		cliente = (Cliente)clientes.getRowData();
	}
	public void prepararAdicionarCliente(ActionEvent evt) {
		cliente = new Cliente(); 
	}
	
	public void salvarCliente(ActionEvent evt) {
			clientesBD.add(cliente);
			cliente = new Cliente();
			FacesContext.getCurrentInstance()
			.addMessage("frmEdicaoCliente",
					new FacesMessage("Cliente Salvo com Sucesso!"));
	}
	
    public String excluirCliente(){
		clientesBD.remove(clientes.getRowData());
        return null;
    }

}

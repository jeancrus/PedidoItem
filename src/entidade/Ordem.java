package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.enums.StatusOrdem;

public class Ordem {
	private Date momento;
	private StatusOrdem status;
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Cliente cliente;
	private List<ItemOrdem> itemOrdem = new ArrayList<>();
	
	public Ordem() {
	}

	public Ordem(Date momento, StatusOrdem status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusOrdem getStatus() {
		return status;
	}

	public void setStatus(StatusOrdem status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemOrdem> getItemOrdem() {
		return itemOrdem;
	}

	public void adcItem(ItemOrdem item) {
		itemOrdem.add(item);
	}
	
	public void rmvItem(ItemOrdem item) {
		itemOrdem.remove(item);
	}
	
	public double totalVenda() {
		double soma = 0;
		for (ItemOrdem i : itemOrdem) {
			soma += i.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento da ordem: " + sdf2.format(momento) + "\n");
		sb.append("Status da ordem: " + status + "\n");
		sb.append("Cliente: " + cliente.getNome() + " ");
		sb.append(sdf.format(cliente.getDataNascimento()) + " - ");
		sb.append(cliente.getEmail() + "\n");
		sb.append("Ordem de itens:" + "\n");
		for (ItemOrdem i : itemOrdem) {
			sb.append(i + "\n");
		}
		sb.append("Preço total: $");
		sb.append(String.format("%.2f", totalVenda()));
		return sb.toString();
	}
	
	
	
}

package bean;

import static util.MessageUtil.addErrorMessage;
import static util.MessageUtil.addInfoMessage;

import java.util.List;

import dao.AstronomiaDAO;
import entidade.Astronomia;

@javax.faces.bean.ManagedBean
public class AstronomiaBean {
	private Astronomia astronomia = new Astronomia();
	private List<Astronomia> lista;

	public String salvar() {
		try {
			AstronomiaDAO.salvar(astronomia);
			addInfoMessage("Concluído", "Astros foram salvos com sucesso");
			astronomia = new Astronomia();
		} catch (Exception e) {
			addErrorMessage("Complicou", "Algo deu errado, tente novamente ou verifique o código.");
		}

		return null;
	}

	public String excluir(Astronomia astronomia) {
		try {
			AstronomiaDAO.excluir(astronomia);
			lista = AstronomiaDAO.listar();
			addInfoMessage("Sucesso", "Astros deletados");
		} catch (Exception e) {
			addErrorMessage("Erro", "não foi possível deletas os Astros");
		}
		return null;
	}
	

	public Astronomia getAstronomia() {
		return astronomia;
	}

	public void setAstronomia(Astronomia astronomia) {
		this.astronomia = astronomia;
	}

	public List<Astronomia> getLista() {
		if (lista == null) {
			lista = AstronomiaDAO.listar();
		}
		return lista;
	}

	public void setLista(List<Astronomia> lista) {
		this.lista = lista;
	}
	
	public void mostrar(Astronomia astronomia) {
		addInfoMessage("O que há no espaço ? Astros e estrelas ? ", "Astro " + astronomia.getAstro() + " e sua Categoria " + astronomia.getCategoria());
		
	}
	
	public void ID(Astronomia astronomia) {
		addInfoMessage("Qual ID ?", "O ID selecionado foi..." + astronomia.getId());
	}
}

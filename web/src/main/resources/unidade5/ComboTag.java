package unidade5;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class ComboTag extends TagSupport {

	private String opcoes, selecionado;
	
	public ComboTag(){
		super();
	}
	
	@Override
	public int doStartTag() {
		StringBuffer saida = new StringBuffer();
		saida.append("<select>");
		try {
			StringTokenizer tokens = new StringTokenizer(opcoes,",");
			while (tokens.hasMoreTokens()) {
				String opcao = tokens.nextToken();
				if (opcao.equalsIgnoreCase(selecionado)) {
					saida.append("<option selected>" + opcao + "</option>");	
				} else {
					saida.append("<option>"+ opcao + "</option>");	
				}
			}
			saida.append("</select>");
			pageContext.getOut().print(saida.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	public void setOpcoes(String opcoes) {
		this.opcoes = opcoes;
	}

	public String getOpcoes() {
		return opcoes;
	}

	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}

	public String getSelecionado() {
		return selecionado;
	}	
}























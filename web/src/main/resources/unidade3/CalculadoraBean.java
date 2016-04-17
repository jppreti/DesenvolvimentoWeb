package unidade3;

public class CalculadoraBean {

	public float soma(String v1, String v2) { return Float.parseFloat(v1) + Float.parseFloat(v2); }
	
	public float subtrair(String v1, String v2) { return Float.parseFloat(v1) - Float.parseFloat(v2); }
	
	public float multiplicar(String v1, String v2) { return Float.parseFloat(v1) * Float.parseFloat(v2); }
	
	public float dividir(String v1, String v2) { return Float.parseFloat(v1) / Float.parseFloat(v2); }
	
	public float calcular(String v1, String v2, String opcao) {
		switch (opcao.charAt(0)) {
			case '+': return soma(v1,v2);
			case '-': return subtrair(v1,v2);
			case '*': return multiplicar(v1,v2);
			case '/': return dividir(v1,v2);
			default : return 0;
		}
	}
}



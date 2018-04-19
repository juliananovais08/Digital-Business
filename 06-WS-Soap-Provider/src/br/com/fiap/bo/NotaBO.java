package br.com.fiap.bo;

public class NotaBO {
	
	public float calcularMedia(float nac, float am, float ps) {
		System.out.println("Calculando media");
		return nac*0.2f + am*0.3f + ps*0.5f;
	}
	
	public float calcularPs(float nac, float am) {
		return (6-(nac*0.2f + am *0.3f))*2;
	}

}
package entidades;

public class PessoaFisica extends Pessoa {

	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public Double calcularImposto() {
		
		Double imposto = 0.0;
		
		if(super.getRendaAnual()<20000) {
			imposto = 0.15 * super.getRendaAnual();
			if(gastosSaude>0) {
				imposto -= gastosSaude * 0.5;
			}
		}else {
			imposto = 0.25 * super.getRendaAnual();
			if(gastosSaude>0) {
				imposto -= gastosSaude * 0.5;
			}
		}

		return imposto;
		
	};
	
}

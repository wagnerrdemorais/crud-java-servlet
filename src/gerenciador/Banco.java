package gerenciador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Banco {
	private static List<Empresa> empresas = new ArrayList<>();

	static {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Banco.empresas.add(new Empresa(UUID.randomUUID(), "Alura", format.parse("01/01/1999")));
			Banco.empresas.add(new Empresa(UUID.randomUUID(), "Caelum", format.parse("01/01/1995")));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}
	
	public Empresa getEmpresa(String id) {
		return Banco.empresas.stream()
				.filter(empresa -> empresa.getId().toString().equals(id))
				.findFirst()
				.orElse(new Empresa());
	}

	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}

	public void edita(Empresa empresa) {
		this.remove(empresa.getId());
		Banco.empresas.add(empresa);
	}

	private void remove(UUID id) {
		this.remove(id.toString());
	}

	public void remove(String id) {
		Banco.empresas.removeIf(empresa -> empresa.getId().equals(UUID.fromString(id)));
	}

}

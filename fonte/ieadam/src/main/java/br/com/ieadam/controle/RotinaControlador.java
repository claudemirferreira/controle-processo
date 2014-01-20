package br.com.ieadam.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Car;
import br.com.ieadam.dominio.Rotina;

@ManagedBean
@SessionScoped
public class RotinaControlador {

	private Rotina rotina;

	private List<Car> cars;

	private Car selectedCar;

	private List<Rotina> modulo1;

	private List<Rotina> modulo2;

	private List<Rotina> modulo3;

	public RotinaControlador() {

		this.modulo1 = Rotina.getModulo1();

		this.modulo2 = Rotina.getModulo2();

		this.modulo3 = Rotina.getModulo3();

		cars = new ArrayList<Car>();

		for (int i = 0; i < 9; i++)
			cars.add(new Car("Model_" + i, 2001, "Brand_" + i, "Color_" + i));
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Car> getCars() {
		return cars;
	}

	public Rotina getRotina() {
		return rotina;
	}

	public void setRotina(Rotina rotina) {
		this.rotina = rotina;
	}

	public List<Rotina> getModulo1() {
		return modulo1;
	}

	public void setModulo1(List<Rotina> modulo1) {
		this.modulo1 = modulo1;
	}

	public List<Rotina> getModulo2() {
		return modulo2;
	}

	public void setModulo2(List<Rotina> modulo2) {
		this.modulo2 = modulo2;
	}

	public List<Rotina> getModulo3() {
		return modulo3;
	}

	public void setModulo3(List<Rotina> modulo3) {
		this.modulo3 = modulo3;
	}
}

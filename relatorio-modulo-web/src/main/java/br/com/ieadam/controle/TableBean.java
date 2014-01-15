package br.com.ieadam.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Car;
import br.com.ieadam.dominio.Rotina;

@ManagedBean
@SessionScoped
public class TableBean {

	private List<Car> cars;

	private List<Rotina> rotina1;

	private Car selectedCar;

	public TableBean() {

		rotina1 = Rotina.getModulo1();

		cars = new ArrayList<Car>();

		for (int i = 0; i < 9; i++)
			cars.add(new Car("Model_" + i, 111, "Brand_" + i, "Color_" + i));
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

	public List<Rotina> getRotina1() {
		return rotina1;
	}

	public void setRotina1(List<Rotina> rotina1) {
		this.rotina1 = rotina1;
	}
}

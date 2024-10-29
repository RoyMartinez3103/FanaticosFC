package mx.unam.dgtic;

import mx.unam.dgtic.model.Equipo;
import mx.unam.dgtic.repository.EquipoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class M8E1EquipoTest {

	final String ALUMNO = "RODRIGO MARTINEZ ZAMBRANO";

	@Autowired
	EquipoRepository equipoRepository;

	@Test
	void mostrarTodosTest(){
		System.out.println(ALUMNO);
		System.out.println("Mostrar todos los equipos");

		System.out.println("Se encontraron: " + equipoRepository.count() + " equipos");
		System.out.println("-- EQUIPOS --");
		Iterable<Equipo> it_equipo = equipoRepository.findAll();
		it_equipo.forEach(System.out::println);
	}

/*	@Test
	void buscarUnoTest(){
		String cve_equipo = "CAZ";
		System.out.println(ALUMNO);

		System.out.println("Buscar equipo por clave: " + cve_equipo);

		Optional<Equipo> optional = equipoRepository.findById(1);
		if(optional.isPresent()){
			System.out.println(optional.get());
			Equipo e1 = optional.get();
			System.out.println("Clave equipo: " +e1.getIdEquipo());
			System.out.println("Nombre: " +e1.getNombre());
			System.out.println("Pais: " +e1.getPais());
			System.out.println("Liga: " +e1.getLiga());
		}else {
			System.out.println("Equipo con clave: " + cve_equipo + " no encontrado");
		}
	}

	@Test
	void insertarEquipoTest(){
		System.out.println(ALUMNO);
		System.out.println("Insertar una equipo");

		Equipo equipo = new Equipo("FEY","Feyenord", "Holanda", "Eredivise");
		equipoRepository.save(equipo);

		Optional<Equipo> optional = equipoRepository.findById(1);
		if(optional.isPresent()){
			System.out.println("El equipo insertado es: ");
			System.out.println(optional.get());
		}else{
			System.out.println("Equipo no encontrado, ocurrió un error al insertar la equipo");
		}
	}

	@Test
	void editarUnoTest(){
		System.out.println(ALUMNO);
		System.out.println("Editar un equipo");

		Optional<Equipo> optional = equipoRepository.findById("FEY");

		if(optional.isPresent()) {
			Equipo equipo  = optional.get();
			System.out.println("Equipo antes de editar");
			System.out.println(equipo);

			equipo.setNombre("Feynoord Rotterdam");
			equipo.setLiga("Eredivisie");

			equipoRepository.save(equipo);
			System.out.println("Equipo después de editar");
			System.out.println(equipoRepository.findById("FEY").get());
		}else {
			System.out.println("equipo con clave FEY no encontrado");
		}
	}

	@Test
	void eliminarUnaTest(){
		System.out.println(ALUMNO);
		System.out.println("Eliminar un equipo");

		Optional<Equipo> optional = equipoRepository.findById("FEY");
		if(optional.isPresent()){
			Equipo equipo  = optional.get();
			System.out.println("Equipo antes de eliminar");
			System.out.println(equipo);
			equipoRepository.delete(optional.get());

		}else{
			System.out.println("Equipo con clave FEY no encontrada");
		}
		System.out.println("Eliminar equipo por id");
		equipoRepository.deleteById("FEY");

		System.out.println("Equipos en la BD");
		equipoRepository.findAll().forEach(System.out::println);
	}*/
}

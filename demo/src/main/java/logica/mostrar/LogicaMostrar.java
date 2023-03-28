package logica.mostrar;

import java.util.List;

import interfaz.InterfazMenuAlumno;
import interfaz.InterfazMenuEscuela;
import interfaz.InterfazMenuProfesor;
import logica.conector.LogicaHQL;
import tablas.Alumno;
import tablas.Escuela;
import tablas.Profesor;

public class LogicaMostrar {

    public static void logicaMostrarEscuelas() {
    	List<Escuela> listaEscuelas = LogicaHQL.insertarListaEscuelas();
    
    	for (Escuela escuela : listaEscuelas) {
    		InterfazMenuEscuela.datosListaEscuelas(escuela);
    	}
    }

    public static void logicaMostrarAlumnos(Escuela escuela) {
    	List<Alumno> listaAlumnos = LogicaHQL.insertarListaAlumnos(escuela);
    
    	for (Alumno alumno : listaAlumnos) {
    		InterfazMenuAlumno.datosListaAlumnos(alumno);
    	}
    }

    public static void logicaMostrarProfesor(Escuela escuela) {
    	List<Profesor> listaProfesores = LogicaHQL.insertarListaProfesores(escuela);
    
    	for (Profesor profesor : listaProfesores) {
    		InterfazMenuProfesor.datosListaProfesores(profesor);
    	}
    }
    
}

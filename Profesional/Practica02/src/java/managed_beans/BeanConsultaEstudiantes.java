/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mantenimientos.Estudiante;
import mantenimientos.MantenimientoCarreras;
import mantenimientos.MantenimientoEstudiantes;
import persistencia.Carreras;
import persistencia.Estudiantes;

/**
 *
 * @author Daniel
 */
@ManagedBean
@RequestScoped
public class BeanConsultaEstudiantes {
    
    private List<Estudiante> estudiantes;
    private Estudiante selectedEstudiante;
    /**
     * Creates a new instance of BeanConsultaEstudiantes
     */
    public BeanConsultaEstudiantes() {
        estudiantes = new ArrayList<Estudiante>();
        MantenimientoEstudiantes manEstudiantes = new MantenimientoEstudiantes();
        MantenimientoCarreras manCarreras = new MantenimientoCarreras();
        
        List<Estudiante>listaEstudiantes = manEstudiantes.consultarTodosEstudiantes();
        Iterator it = listaEstudiantes.iterator();
        while (it.hasNext()) {
            Estudiantes e  = (Estudiantes) it.next();
            Carreras c = manCarreras.consultarCarrera(e.getCodigoCarrera());
            estudiantes.add(new Estudiante(e.getCarnet(), e.getApellidos(), e.getNombres(), c.getCarrera()));            
        }
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Estudiante getSelectedEstudiante() {
        return selectedEstudiante;
    }

    public void setSelectedEstudiante(Estudiante selectedEstudiante) {
        this.selectedEstudiante = selectedEstudiante;
    }
    
    
}

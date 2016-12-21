/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managed_beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mantenimientos.MantenimientoCarreras;
import mantenimientos.MantenimientoDepartamento;
import mantenimientos.MantenimientoEstudiantes;
import mantenimientos.MantenimientoMunicipio;
import mantenimientos.MantenimientoPaises;
import persistencia.Carreras;
import persistencia.Departamentos;
import persistencia.Estudiantes;
import persistencia.Municipios;
import persistencia.Paises;
/**
 *
 * @author Daniel
 */
@ManagedBean
@SessionScoped
public class BeanEstudiantes {
    
    private String noCarnet;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String telefono;
    private String codigoPais;
    private String codigoDepartamento;
    private String codigoMunicipio;
    private String codigoCarrera;
    
    private Map<String, String>departamentos = new HashMap<String, String>();
    private Map<String, String>municipios = new HashMap<String, String>();
    private Map<String, String>paises = new HashMap<String, String>();
    private Map<String, String>carreras = new HashMap<String, String>();

    public String getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(String noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Map<String, String> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Map<String, String> departamentos) {
        this.departamentos = departamentos;
    }

    public Map<String, String> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Map<String, String> municipios) {
        this.municipios = municipios;
    }

    public Map<String, String> getPaises() {
        return paises;
    }

    public void setPaises(Map<String, String> paises) {
        this.paises = paises;
    }

    public Map<String, String> getCarreras() {
        return carreras;
    }

    public void setCarreras(Map<String, String> carreras) {
        this.carreras = carreras;
    }
    
    
    public  void guardarDatos(){
        String advertencia = "";
        MantenimientoEstudiantes man = new MantenimientoEstudiantes();
        
        if (apellidos==null || apellidos.equals("")) {
            advertencia += "Apellidos de estudiante es obligatorio...<br>";
        }
        
        if (nombres ==null || nombres.equals("")) {
            advertencia += "Nombres de estudiante es obligatorio...<br>";
        }
        if (direccion == null || direccion.equals("")) {
            advertencia += "Direccion de estudiante es obligatoria...<br>";
        }
        if (codigoPais == null || codigoPais.equals("")) {
            advertencia += "El codigo de Pais es obligatorio...<br>";
        }
        if (codigoDepartamento == null || codigoDepartamento.equals("")) {
            advertencia += "El codigo de departamento es obligatorio...<br>";
        }
        if (codigoMunicipio == null || codigoMunicipio.equals("")) {
            advertencia += "El codigo de municipio es obligatorio...<br>";
        }
        if (codigoCarrera == null || codigoCarrera.equals("")) {
            advertencia += "El codigo de carrera es obligatorio...<br>";
        }
        
        if (advertencia.equals("")) {
            Estudiantes e  = new Estudiantes();
            java.util.Date hoy = new java.util.Date();
            e.setCarnet(noCarnet);
            e.setApellidos(apellidos);
            e.setNombres(nombres);
            e.setDireccion(direccion);
            e.setTelefono(telefono);
            e.setCodigoPais(codigoPais);
            e.setCodigoDepartamento(codigoDepartamento);
            e.setCodigoMunicipio(codigoMunicipio);
            e.setCodigoCarrera(codigoCarrera);
            e.setFechaCreacion(hoy);
            
            
            Estudiantes valEst = man.consultarEstudiante(noCarnet);
            if (valEst!=null) {
                advertencia = "Estudiante ya esta registrado...";
            }else{
                if (man.guardarEstudiante(e)==1) {
                advertencia = "Estudiante almacenado satisfactoriamente...";
                 }else{
                    advertencia= "Estudiante ya se encuentra registrado...";
                }
            }

        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void consultarDatos(){
        String advertencia = "";
        MantenimientoEstudiantes man = new MantenimientoEstudiantes();
        Estudiantes e = man.consultarEstudiante(noCarnet);
        
        if (e==null) {
            advertencia = "Estudiante no encontrado...";
        }else{
            apellidos = e.getApellidos();
            nombres = e.getNombres();
            direccion = e.getDireccion();
            telefono = e.getTelefono();
            
            codigoPais = e.getCodigoPais();
            codigoDepartamento = e.getCodigoDepartamento();
            codigoMunicipio = e.getCodigoMunicipio();
            codigoCarrera = e.getCodigoCarrera();
            
            modificarMunicipio();
            advertencia = "Consultando datos...";
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void eliminarDatos(){
        String advertencia = "";
        MantenimientoEstudiantes man = new MantenimientoEstudiantes();
        
        if (man.eliminarEstudiante(noCarnet)==1) {
            advertencia ="Estudiante eliminado satisfactoriamente...";
        }else{
            advertencia ="Error al tratar de eliminar...";
        }
        
        FacesMessage msg = new FacesMessage(advertencia);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void modificarMunicipio(){
        MantenimientoMunicipio manMunicipios = new MantenimientoMunicipio();
        this.municipios.clear();
        List<Municipios>listaMunicipios = manMunicipios.consultarMunicipioPorDepartamento(codigoDepartamento);
        System.out.println("codigo departamento" + codigoDepartamento);
        Iterator itMun = listaMunicipios.iterator();
        while (itMun.hasNext()) {
            Municipios m = (Municipios) itMun.next();
            this.municipios.put(m.getMunicipio(), m.getCodigoMunicipio());
        }
    }
    
    public void limpiarDatos(){
        this.noCarnet="";
        this.apellidos="";
        this.nombres="";
        this.direccion="";
        this.telefono="";
        this.codigoPais="";
        this.codigoDepartamento="";
        this.codigoMunicipio="";
        this.codigoCarrera="";
        
        FacesMessage msg = new FacesMessage("Limpiando datos...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     * Creates a new instance of BeanEstudiantes
     */
    public BeanEstudiantes() {
        MantenimientoDepartamento manDepartamentos = new MantenimientoDepartamento();
        MantenimientoMunicipio manMunicipios = new MantenimientoMunicipio();
        MantenimientoCarreras manCarreras = new MantenimientoCarreras();
        MantenimientoPaises manPaises = new MantenimientoPaises();
        
        List<Departamentos>listaDepartamentos = manDepartamentos.consultarTodosDepartamentos();
        Iterator itD = listaDepartamentos.iterator();
        while (itD.hasNext()) {
            Departamentos d = (Departamentos) itD.next();
            departamentos.put(d.getDepartamento(), d.getCodigoDepartamento());
        }
        
        List<Municipios>listaMunicipios = manMunicipios.consultarMunicipioPorDepartamento(codigoDepartamento);
        Iterator itM = listaMunicipios.iterator();
        while (itM.hasNext()) {
            Municipios m = (Municipios) itM.next();
            municipios.put(m.getMunicipio(), m.getCodigoMunicipio());
        }
        
        List<Paises>listaPaises = manPaises.consultarTodosPaises();
        Iterator itP= listaPaises.iterator();
        while (itP.hasNext()) {
            Paises p = (Paises) itP.next();
            paises.put(p.getPais(), p.getCodigoPais());
        }
        
        List<Carreras>listaCarreras = manCarreras.consultarTodasCarreras();
        Iterator itC = listaCarreras.iterator();
        while (itC.hasNext()) {
            Carreras c = (Carreras) itC.next();
            carreras.put(c.getCarrera(), c.getCodigoCarrera());
        }    
    }
}

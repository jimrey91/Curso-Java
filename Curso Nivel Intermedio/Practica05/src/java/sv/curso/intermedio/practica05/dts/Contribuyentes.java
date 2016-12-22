package sv.curso.intermedio.practica05.dts;

/**
 *
 * @author Daniel
 */
public class Contribuyentes {
    private String noNit;
    private String nombreContribuyentes;
    private String razonSocial;
    private String representanteLegal;
    private double rentaAnual;

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNombreContribuyentes() {
        return nombreContribuyentes;
    }

    public void setNombreContribuyentes(String nombreContribuyentes) {
        this.nombreContribuyentes = nombreContribuyentes;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public double getRentaAnual() {
        return rentaAnual;
    }

    public void setRentaAnual(double rentaAnual) {
        this.rentaAnual = rentaAnual;
    }

    @Override
    public String toString() {
        return "Contribuyentes{" + "NoNit=" + noNit + ", NombreContribuyentes=" + nombreContribuyentes + ", RazonSocial=" + razonSocial + ", RepresentanteLegal=" + representanteLegal + ", RentaAnual=" + rentaAnual + '}';
    }
    
    
    
}

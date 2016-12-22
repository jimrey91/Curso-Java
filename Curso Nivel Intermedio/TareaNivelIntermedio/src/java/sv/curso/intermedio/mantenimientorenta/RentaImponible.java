/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.curso.intermedio.mantenimientorenta;

/**
 *
 * @author Daniel
 */
public class RentaImponible {
    private String noNit;
    private String nombreEmpleado;
    private double salarioAnual;
    private double aguinaldo;
    private double ingresosServicios;

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public double getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(double aguinaldo) {
        this.aguinaldo = aguinaldo;
    }

    public double getIngresosServicios() {
        return ingresosServicios;
    }

    public void setIngresosServicios(double ingresosServicios) {
        this.ingresosServicios = ingresosServicios;
    }
    
//   
    
//        public void calculoRenta(double salario){
//        double afp = salario * (6.25/100);
//        double rimp = salario - afp;
//        //Tramo I
//        if(rimp <= 4064.00){
//            JOptionPane.showMessageDialog(null, "Exento de impuesto");
          //Tramo II
//        }else if(rimp <= 9142.86){
//            double rimpt = 0.10 * (rimp - 2514.29) + 212.12;
//            JOptionPane.showMessageDialog(null,"La renta imponible es de: " +rimpt);
          //Tramo III
//        }else if(rimp <= 22857.14){
//            double rimpt = 0.20 * (rimp - 9142.87) + 720.00;
//            JOptionPane.showMessageDialog(null, "La renta imponible es de: " + rimpt);
          //Tramo IV
//        }else if(rimp >= 22857.15){
//            double rimpt = 0.30 *(rimp - 22857.15) + 3482.86;
//            JOptionPane.showMessageDialog(null, "La renta imponible es de: " + rimpt);
//        }
//    }
    
//    
}

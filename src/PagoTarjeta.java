public class PagoTarjeta implements MetodoPago, Reembolsable, Verificable{
    private String numTarjeta, cvv, fechaExpiracion, titular;

    public PagoTarjeta(String numTarjeta, String cvv, String fechaExpiracion, String titular) {
        if(numTarjeta == null|| numTarjeta.isEmpty()){
            throw new IllegalArgumentException("Numero de tarjeta vacio");
        }
        if(cvv == null|| cvv.isEmpty()){
            throw new IllegalArgumentException("CVV vacio");
        }
        if(fechaExpiracion == null|| fechaExpiracion.isEmpty()){
            throw new IllegalArgumentException("Fecha de expiracion vacio");
        }
        if(titular == null|| titular.isEmpty()){
            throw new IllegalArgumentException("Titlar vacio");
        }
        this.numTarjeta = numTarjeta;
        this.cvv = cvv;
        this.fechaExpiracion = fechaExpiracion;
        this.titular = titular;
    }
    public String getNumTarjeta() {
        return numTarjeta;
    }
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public boolean validar() {
        if(cvv.length() !=3){
            return false;
        }
        return true;
    }

    @Override
    public boolean procesarPago(double monto, String referencia) {
        if(!validar()){
            System.out.println("Procesamiento de pago rechazado");
            return false;
        }
        System.out.println("Procesamiento de pago con exito");
        System.out.println("Monto: " + monto + "Referencia: " + referencia);
        return true;
    }

    @Override
    public String generarComprobante() {
        String numeroFinal = numTarjeta.substring(numTarjeta.length() -4);
        return "COMPROBANTE "+"\nTARJETA - XXXX-" + numeroFinal;
    }

    @Override
    public boolean procesarDevolucion(double monto, String motivo, int diasDemorados) {
        if (diasDemorados > diasParaDevolucion()){
            System.out.println("Dias para devolucion fuera de limite");
            return false;
        }
        System.out.println("Devolucion de: "+ monto + " con exito");
        return true;
    }

    @Override
    public int diasParaDevolucion() {
        return 30;
    }

    @Override
    public boolean verificarIdentidad(String documento) {
        if(documento.length()>=5){
            return true;
        }
        return false;
    }

    @Override
    public boolean esSeguro() {
        if(cvv.length()==3){
            return true;
        }
        return false;
    }
}

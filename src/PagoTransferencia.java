public class PagoTransferencia implements MetodoPago, Verificable{
    private String numCuenta, banco, titular;

    public PagoTransferencia(String numCuenta, String banco, String titular) {
        if(numCuenta == null || numCuenta.isEmpty()){
            throw new IllegalArgumentException("Numero de cuenta vacio");
        }
        if(banco == null || banco.isEmpty()){
            throw new IllegalArgumentException("Banco vacio");
        }
        if(titular == null || titular.isEmpty()){
            throw new IllegalArgumentException("Titular vacio");
        }
        this.numCuenta = numCuenta;
        this.banco = banco;
        this.titular = titular;
    }

    @Override
    public boolean validar() {
        return numCuenta.length() == 10;
    }

    @Override
    public boolean procesarPago(double monto, String referencia) {
        if(!validar()){
            System.out.println("Procesamiento de pago rechazado");
            return false;
        }
        System.out.println("Procesamiento de pago con exito");
        return true;
    }

    @Override
    public String generarComprobante() {
        if(!validar()){
            return "No se puede generar comprobante";
        }
        return "Banco: " + banco + "\nNumero de cuenta: " + numCuenta;
    }

    @Override
    public boolean verificarIdentidad(String documento) {
        return documento.length() >=5;
    }

    @Override
    public boolean esSeguro() {
        return numCuenta.length()==10;
    }
}

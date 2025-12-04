public class PagoPayPal implements MetodoPago, Reembolsable {
    private String email, token;

    public PagoPayPal(String email, String token) {
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Email vacio");
        }
        if(token == null || token.isEmpty()){
            throw new IllegalArgumentException("Token vacio");
        }
        this.email = email;
        this.token = token;
    }

    @Override
    public boolean validar() {
        return email.contains("@");
    }

    @Override
    public boolean procesarPago(double monto, String referencia) {
        if(!validar()){
            System.out.println("Procesamiento de pago erroneo");
            return false;
        }
        System.out.println("Procesamiento de pago con exito");
        return true;
    }

    @Override
    public String generarComprobante() {
        return "COMPROBANTE PAYPAL - - - " + email + "token unico: " + token;
    }

    @Override
    public boolean procesarDevolucion(double monto, String motivo, int diasDemorados) {
        if(diasParaDevolucion() < diasDemorados){
            System.out.println("Reembolso invalido fuera de rango");
            return false;
        }
        System.out.println("Reembolso aplicado con exito");
        return true;
    }

    @Override
    public int diasParaDevolucion() {
        return 180;
    }
}

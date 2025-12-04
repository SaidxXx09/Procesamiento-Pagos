//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            PagoTarjeta tarjeta = new PagoTarjeta("11111111","123","12/10/2025","Said Quinto");
            System.out.println("--PAGO DE TARJETA--");
            tarjeta.procesarPago(250,"Gorra");
            System.out.println("-- COMPROBANTE --");
            System.out.println(tarjeta.generarComprobante());
            System.out.println("--DEVOLUCION--");
            System.out.println(tarjeta.procesarDevolucion(50,"Monto excido",30));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        //PAYPAL
        try {
            PagoPayPal paypal = new PagoPayPal("ariel@gmail.com","120");
            System.out.println("--PAGO DE PAYPAL--");
            paypal.procesarPago(180,"Teclado");
            System.out.println("-- COMPROBANTE --");
            System.out.println(paypal.generarComprobante());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            PagoTransferencia transferencia = new PagoTransferencia("1200120012","Produbanco","Said Quinto");
            System.out.println("--PAGO DE TRANSFERENCIA--");
            transferencia.procesarPago(500,"LAPTOP");
            System.out.println("--COMPROBANTE--");
            System.out.println(transferencia.generarComprobante());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}
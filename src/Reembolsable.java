public interface Reembolsable {
    boolean procesarDevolucion(double monto, String motivo, int diasDemorados);
    int diasParaDevolucion();
}

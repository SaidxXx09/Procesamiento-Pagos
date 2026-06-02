# 💳 Sistema de Procesamiento de Pagos

Proyecto en Java que simula un sistema de pagos con tres métodos distintos: tarjeta de crédito/débito, PayPal y transferencia bancaria. Cada método valida sus datos, procesa el pago y genera un comprobante. Algunos además soportan devoluciones y verificación de identidad.

---

## ¿Qué hace este proyecto?

- Procesa pagos mediante **tres métodos**:
  - **Tarjeta** — valida CVV de 3 dígitos, genera comprobante enmascarando el número y permite devoluciones hasta 30 días
  - **PayPal** — valida el formato del email, procesa el pago con token único y permite devoluciones hasta 180 días
  - **Transferencia** — valida que el número de cuenta tenga 10 dígitos y genera comprobante con datos del banco
- Genera un **comprobante** por cada pago procesado
- Permite **devoluciones** con control de días límite (Tarjeta y PayPal)
- Verifica la **identidad del titular** y si el método es seguro (Tarjeta y Transferencia)

---

## Estructura del proyecto

```
Procesamiento-Pagos/
└── src/
    ├── Main.java                  # Punto de entrada y pruebas
    ├── MetodoPago.java            # Interfaz: validar, procesarPago, generarComprobante
    ├── Reembolsable.java          # Interfaz: procesarDevolucion, diasParaDevolucion
    ├── Verificable.java           # Interfaz: verificarIdentidad, esSeguro
    ├── PagoTarjeta.java           # Implementa MetodoPago + Reembolsable + Verificable
    ├── PagoPayPal.java            # Implementa MetodoPago + Reembolsable
    └── PagoTransferencia.java     # Implementa MetodoPago + Verificable
```

---

| Clase | MetodoPago | Reembolsable | Verificable |
|---|:---:|:---:|:---:|
| `PagoTarjeta` | ✅ | ✅ | ✅ |
| `PagoPayPal` | ✅ | ✅ | ❌ |
| `PagoTransferencia` | ✅ | ❌ | ✅ |

---

## Reglas por método de pago

| Método | Validación | Devolución máxima |
|---|---|---|
| Tarjeta | CVV de exactamente 3 dígitos | 30 días |
| PayPal | Email debe contener `@` | 180 días |
| Transferencia | Número de cuenta de exactamente 10 dígitos | No aplica |

---

## ¿Cómo ejecutarlo en IntelliJ IDEA?

1. Abre **IntelliJ IDEA**
2. Ve a **File → Open** y selecciona la carpeta del proyecto
3. Espera a que IntelliJ indexe el proyecto
4. Abre el archivo `src/Main.java`
5. Haz clic en el botón ▶ verde o presiona `Shift + F10`
6. El resultado aparecerá en la consola de **Run**

---

## Tecnologías

- **Java** — sin librerías externas
- **POO**: interfaces, implementación múltiple, polimorfismo, validaciones

---

## Autor

| Nombre |
|--------|
| Said Quinto |

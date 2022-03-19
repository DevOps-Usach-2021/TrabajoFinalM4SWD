package com.devops.dxc.devops.model;
public class Util {

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param ahorro
     * @return
     */
    public static int getDxc(int ahorro){
        if(((ahorro*0.1)/getUf()) > 150 ){
            return (int) (150*getUf()) ;
        } else if((ahorro*0.1)<=1000000 && ahorro >=1000000){
            return (int) 1000000;
        } else if( ahorro <=1000000){
            return (int) ahorro;
        } else {
            return (int) (ahorro*0.1);
        }
    }

    /**
     * Método para cacular el impuesto asociado al retiro del 10%.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param retiro
     * @param sueldo
     * @return
     */
    public static int getImpuesto(int retiro, int sueldo){
        // Si el sueldo es menor de $1.500.000 no paga impuesto
        if (sueldo < 1500000) return 0;

        // Si el sueldo está entre $1.500.000 y $3.000.000
        if (sueldo >= 1500000 && sueldo < 3000000) {

            // si retira hasta $1.000.000 paga $94.532
            if (retiro <= 1000000) return 94532;
            // si retira hasta $2.000.000 paga $174.532
            if (retiro <= 2000000) return 174532;
            // si retira hasta $3.000.000 paga $254.532
            if (retiro <= 3000000) return 254532;
            // si retira hasta el máximo ($4.300.000) paga $358.532
            return 358532;

        }

        // Si el sueldo está entre $3.000.000 y $5.000.000 paga $656.253 sin importar el monto del retiro
        if (sueldo >= 3000000 && sueldo < 5000000)  return 656253;

        // Si el sueldo está entre $5.000.000 y $6.000.000 paga $1.607.520 sin importar el monto del retiro
        if (sueldo >= 5000000 && sueldo < 6000000)  return 1607520;

        // Si el sueldo es mayor o igual de $6.000.000 paga $1.830.292 sin importar el monto del retiro
        if (sueldo >= 6000000)  return 1830292;

        return 0;
    }

    /**
     * Método para cacular el Saldo restante luego del retiro del 10%.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param retiro
     * @param ahorro
     * @return
     * @throws Exception
     */
    public static int getSaldo(int retiro, int ahorro) throws Exception{
        if (retiro > ahorro) {
            throw new Exception("El ahorro debe ser mayor o igual que el valor de retiro");
        }

        return ahorro - retiro;
    }

    /**
     * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     * @return
     */
    public static int getUf(){
        return Uf.getUf();
    }
    
}

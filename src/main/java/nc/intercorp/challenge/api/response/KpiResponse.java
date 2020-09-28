package nc.intercorp.challenge.api.response;

import io.swagger.annotations.ApiModelProperty;

public class KpiResponse {

    @ApiModelProperty(name = "promedioEdad", example = "35", notes = "Promedio de edad de todos los clientes")
    private Integer promedioEdad;

    @ApiModelProperty(name = "desvEstandarEdad", example = "7", notes = "Desviacion estandar de la edad de todos los clientes")
    private Integer desvEstandarEdad;

    public Integer getPromedioEdad() {
        return promedioEdad;
    }

    public void setPromedioEdad(Integer promedioEdad) {
        this.promedioEdad = promedioEdad;
    }

    public Integer getDesvEstandarEdad() {
        return desvEstandarEdad;
    }

    public void setDesvEstandarEdad(Integer desvEstandarEdad) {
        this.desvEstandarEdad = desvEstandarEdad;
    }
}

package nc.intercorp.challenge.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class ClienteResponse {

    @ApiModelProperty(name = "nombre", example = "Juan", notes = "Nombre del cliente")
    private String nombre;

    @ApiModelProperty(name = "apellido", example = "Gonzalez", notes = "Apellido del cliente")
    private String apellido;

    @ApiModelProperty(name = "edad", example = "35", notes = "Apellido del cliente")
    private Integer edad;

    @ApiModelProperty(name = "fechaNacimiento", example = "10/09/1985", notes = "Fecha de nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private LocalDate fechaNacimiento;

    @ApiModelProperty(name = "fechaProbableMuerte", example = "10/09/2056", notes = "Fecha de nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate fechaProbableMuerte;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaProbableMuerte() {
        return fechaProbableMuerte;
    }

    public void setFechaProbableMuerte(LocalDate fechaProbableMuerte) {
        this.fechaProbableMuerte = fechaProbableMuerte;
    }
}

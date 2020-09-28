package nc.intercorp.challenge.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateClienteRequest {

    @NotBlank(message = "El nombre no puede ser nulo ni vacio")
    @ApiModelProperty(name = "nombre", example = "Juan", notes = "Nombre del cliente")
    private String nombre;

    @NotBlank(message = "El apellido no puede ser nulo ni vacio")
    @ApiModelProperty(name = "apellido", example = "Gonzalez", notes = "Apellido del cliente")
    private String apellido;

    @NotNull(message = "Fecha de nacimiento no puede ser nulo")
    @ApiModelProperty(name = "fechaNacimiento", example = "10/09/1985", notes = "Fecha de nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private LocalDate fechaNacimiento;

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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

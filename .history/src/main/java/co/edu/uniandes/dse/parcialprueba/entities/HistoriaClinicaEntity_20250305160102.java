package co.edu.uniandes.dse.parcialprueba.entities;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class HistoriaClinicaEntity extends BaseEntity
{
    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;

    @PodamExclude
    @ManyToOne
    private PacienteEntity paciente;

    private String diagnostico;
    private String tratamiento;
    private List<Acudiente> pacientes = new ArrayList<>();
}

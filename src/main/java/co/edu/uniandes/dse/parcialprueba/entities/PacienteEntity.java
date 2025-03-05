package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.*;

@Data
@Entity
public class PacienteEntity extends BaseEntity
{
    String nombre;
    String correo;
    String telefono;

    @PodamExclude 
    @OneToMany(mappedBy = "Paciente", fetch = FetchType.LAZY)
    private List<HistoriaClinicaEntity> historiaClinica = new ArrayList<>();
    
}

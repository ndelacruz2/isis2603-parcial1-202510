package co.edu.uniandes.dse.parcialprueba.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService 
{
    @Autowired
    PacienteRepository pacienteRepository;

    private static final String Telefono_Cifra_1 = "^311.*";
    private static final String Telefono_Cifra_2 = "^601.*";	

    @Transactional 
    public PacienteEntity createPaciente(PacienteEntity paciente) throws IllegalOperationException 
    {
        log.info("Inicia proceso de creación del paciente");
        if (!Pattern.matches(Telefono_Cifra_1, paciente.getTelefono()))
        {
            throw new IllegalOperationException("El registro médico no cumple con el formato esperado");
        }
        if(!Pattern.matches(Telefono_Cifra_2, paciente.getTelefono()))
        {
            throw new IllegalOperationException("El registro médico no cumple con el formato esperado");
        }
        log.info("Termina proceso de creación del médico");
        return pacienteRepository.save(paciente);
    }

    

}

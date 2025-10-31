package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Departamento;

import java.util.ArrayList;
import java.util.UUID;

public class DepartamentosData {
    private ArrayList<Departamento> departamentos;

    public DepartamentosData() {
        departamentos = new ArrayList<>();
        
        // Datos de prueba
        departamentos.add(new Departamento(UUID.randomUUID().toString(), "Soporte Técnico", "Departamento encargado de resolver problemas técnicos", "soporte@helpdesk.com"));
        departamentos.add(new Departamento(UUID.randomUUID().toString(), "Recursos Humanos", "Departamento de gestión de personal", "rrhh@helpdesk.com"));
        departamentos.add(new Departamento(UUID.randomUUID().toString(), "Sistemas", "Departamento de infraestructura IT", "sistemas@helpdesk.com"));
        departamentos.add(new Departamento(UUID.randomUUID().toString(), "Administración", "Departamento administrativo", "admin@helpdesk.com"));
    }

    public void addDepartamento(Departamento departamento) {
        if (departamentos == null) {
            departamentos = new ArrayList<>();
        }
        departamentos.add(departamento);
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }
}

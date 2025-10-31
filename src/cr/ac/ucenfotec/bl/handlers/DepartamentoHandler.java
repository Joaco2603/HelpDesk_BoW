package cr.ac.ucenfotec.bl.handlers;

import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.dl.DepartamentosData;

import java.util.ArrayList;
import java.util.UUID;

public class DepartamentoHandler {
    private DepartamentosData dataDepartamentos;

    public DepartamentoHandler() {
        dataDepartamentos = new DepartamentosData();
    }

    public Departamento addDepartamento(String nombre, String descripcion, String contacto) {
        Departamento departamento = new Departamento(UUID.randomUUID().toString(), nombre, descripcion, contacto);
        dataDepartamentos.addDepartamento(departamento);
        return departamento;
    }

    public Departamento findDepartamentoById(String id) {
        for (Departamento departamento : dataDepartamentos.getDepartamentos()) {
            if (departamento.getId().equals(id)) {
                return departamento;
            }
        }
        return null;
    }

    public Departamento findDepartamentoByNombre(String nombre) {
        for (Departamento departamento : dataDepartamentos.getDepartamentos()) {
            if (departamento.getNombre().equalsIgnoreCase(nombre)) {
                return departamento;
            }
        }
        return null;
    }

    public ArrayList<Departamento> getAllDepartamentos() {
        return dataDepartamentos.getDepartamentos();
    }

    public boolean updateDepartamento(Departamento departamento) {
        ArrayList<Departamento> departamentos = dataDepartamentos.getDepartamentos();
        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i).getId().equals(departamento.getId())) {
                departamentos.set(i, departamento);
                return true;
            }
        }
        return false;
    }

    public boolean deleteDepartamento(String id) {
        ArrayList<Departamento> departamentos = dataDepartamentos.getDepartamentos();
        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i).getId().equals(id)) {
                departamentos.remove(i);
                return true;
            }
        }
        return false;
    }
}

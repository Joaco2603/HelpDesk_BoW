package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Departamento;
import cr.ac.ucenfotec.dl.DataDepartamentos;

import java.util.ArrayList;

public class GestorDepartamento {
    private DataDepartamentos dataDepartamentos;

    public GestorDepartamento() {
        dataDepartamentos = new DataDepartamentos();
    }

    public Departamento addDepartamento(int id, String nombre, String descripcion, String contacto) {
        Departamento departamento = new Departamento(id, nombre, descripcion, contacto);
        dataDepartamentos.addDepartamento(departamento);
        return departamento;
    }

    public Departamento findDepartamentoById(int id) {
        for (Departamento depto : dataDepartamentos.getDepartamentos()) {
            if (depto.getId() == id) {
                return depto;
            }
        }
        return null;
    }

    public Departamento findDepartamentoByNombre(String nombre) {
        for (Departamento depto : dataDepartamentos.getDepartamentos()) {
            if (depto.getNombre().equalsIgnoreCase(nombre)) {
                return depto;
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
            if (departamentos.get(i).getId() == departamento.getId()) {
                departamentos.set(i, departamento);
                return true;
            }
        }
        return false;
    }

    public boolean deleteDepartamento(String id) {
        ArrayList<Departamento> departamentos = dataDepartamentos.getDepartamentos();
        for (int i = 0; i < departamentos.size(); i++) {
            if (String.valueOf(departamentos.get(i).getId()).equals(id)) {
                departamentos.remove(i);
                return true;
            }
        }
        return false;
    }
}

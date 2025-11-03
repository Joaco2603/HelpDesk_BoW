package cr.ac.ucenfotec.bl.handlers;

import cr.ac.ucenfotec.bl.entities.Usuario;
import cr.ac.ucenfotec.dl.UsuariosData;

import java.util.ArrayList;

public class UsuarioHandler {
    private UsuariosData dataUsuarios;

    public UsuarioHandler() {
        dataUsuarios = new UsuariosData();
    }

    public Usuario addUsuario(String cedula, String nombre, String correo, String password, String telefono, String rol) {
        Usuario usuario = new Usuario(cedula, nombre, correo, password, telefono, rol);
        dataUsuarios.addUsuario(usuario);
        return usuario;
    }

    public Usuario findUsuarioByCorreoAndPassword(String correo, String password) {
        for (Usuario usuario : dataUsuarios.getUsuarios()) {
            if (usuario.getCorreo().equals(correo) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario findUsuarioById(String id) {
        for (Usuario usuario : dataUsuarios.getUsuarios()) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario findUsuarioByCorreo(String correo) {
        for (Usuario usuario : dataUsuarios.getUsuarios()) {
            if (usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getAllUsuarios() {
        return dataUsuarios.getUsuarios();
    }

    public boolean updateUsuario(Usuario usuario) {
        ArrayList<Usuario> usuarios = dataUsuarios.getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(usuario.getId())) {
                usuarios.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUsuario(String id) {
        ArrayList<Usuario> usuarios = dataUsuarios.getUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                usuarios.remove(i);
                return true;
            }
        }
        return false;
    }
}

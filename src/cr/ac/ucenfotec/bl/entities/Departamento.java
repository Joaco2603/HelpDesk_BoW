package cr.ac.ucenfotec.bl.entities;

public class Departamento {
    private String id;
    private String nombre;
    private String descripcion;
    private String contacto;

    public Departamento() {
    }

    public Departamento(String id, String nombre, String descripcion, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contacto = contacto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}

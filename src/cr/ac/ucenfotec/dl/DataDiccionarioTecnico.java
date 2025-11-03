package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Tockenizer;
import java.util.ArrayList;

/**
 * DiccionarioTecnico - Contiene listas de palabras (Tockenizer) 
 * clasificadas por categorías técnicas
 * Relación: Composición (0..* contiene Palabra)
 */
public class DataDiccionarioTecnico {
    // Listas que contienen objetos Palabra (Tockenizer)
    private ArrayList<Tockenizer> redes;
    private ArrayList<Tockenizer> impresoras;
    private ArrayList<Tockenizer> cuentas;
    private ArrayList<Tockenizer> hardware;

    public DataDiccionarioTecnico() {
        // Inicializar las listas
        redes = new ArrayList<>();
        impresoras = new ArrayList<>();
        cuentas = new ArrayList<>();
        hardware = new ArrayList<>();

        // Cargar palabras por categoría
        cargarRedes();
        cargarImpresoras();
        cargarCuentas();
        cargarHardware();
    }

    // Métodos para cargar palabras por categoría
    private void cargarRedes() {
        redes.add(new Tockenizer("red", "Técnico", "Redes"));
        redes.add(new Tockenizer("wifi", "Técnico", "Redes"));
        redes.add(new Tockenizer("router", "Técnico", "Redes"));
        redes.add(new Tockenizer("cable", "Técnico", "Redes"));
        redes.add(new Tockenizer("lan", "Técnico", "Redes"));
        redes.add(new Tockenizer("ethernet", "Técnico", "Redes"));
        redes.add(new Tockenizer("switch", "Técnico", "Redes"));
        redes.add(new Tockenizer("conexión", "Técnico", "Redes"));
        redes.add(new Tockenizer("servidor", "Técnico", "Redes"));
        redes.add(new Tockenizer("ping", "Técnico", "Redes"));
    }

    private void cargarImpresoras() {
        impresoras.add(new Tockenizer("impresora", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("imprimir", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("papel", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("toner", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("cartucho", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("cola", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("error", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("driver", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("escáner", "Técnico", "Impresoras"));
        impresoras.add(new Tockenizer("configuración", "Técnico", "Impresoras"));
    }

    private void cargarCuentas() {
        cuentas.add(new Tockenizer("login", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("usuario", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("contraseña", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("perfil", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("acceso", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("permiso", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("seguridad", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("auth", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("email", "Técnico", "Cuentas"));
        cuentas.add(new Tockenizer("sesión", "Técnico", "Cuentas"));
    }

    private void cargarHardware() {
        hardware.add(new Tockenizer("cpu", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("ram", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("disco", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("placa", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("tarjeta", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("monitor", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("mouse", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("teclado", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("fuente", "Técnico", "Hardware"));
        hardware.add(new Tockenizer("ventilador", "Técnico", "Hardware"));
    }

    // Getters que retornan las listas de palabras (Tockenizer)
    public ArrayList<Tockenizer> getRedes() { 
        return redes; 
    }
    
    public ArrayList<Tockenizer> getImpresoras() { 
        return impresoras; 
    }
    
    public ArrayList<Tockenizer> getCuentas() { 
        return cuentas; 
    }
    
    public ArrayList<Tockenizer> getHardware() { 
        return hardware; 
    }

    // Métodos adicionales según el diagrama UML
    
    /**
     * Obtiene todas las palabras de una categoría específica
     */
    public ArrayList<Tockenizer> getCategoria(String categoria) {
        switch (categoria.toLowerCase()) {
            case "redes":
                return redes;
            case "impresoras":
                return impresoras;
            case "cuentas":
                return cuentas;
            case "hardware":
                return hardware;
            default:
                return new ArrayList<>();
        }
    }

    /**
     * Obtiene el atributo (clasificación) de todas las palabras
     */
    public String getAtributo() {
        return "Técnico";
    }

    /**
     * Añade una nueva palabra al diccionario técnico
     */
    public void addPalabra(Tockenizer palabra) {
        if (palabra == null || palabra.getClasificacion() == null) {
            return;
        }
        
        String categoria = palabra.getCategoria();
        if (categoria == null) {
            return;
        }
        
        switch (categoria.toLowerCase()) {
            case "redes":
                redes.add(palabra);
                break;
            case "impresoras":
                impresoras.add(palabra);
                break;
            case "cuentas":
                cuentas.add(palabra);
                break;
            case "hardware":
                hardware.add(palabra);
                break;
        }
    }

    /**
     * Obtiene el total de palabras en el diccionario técnico
     */
    public int getTotalPalabras() {
        return redes.size() + impresoras.size() + 
               cuentas.size() + hardware.size();
    }

    @Override
    public String toString() {
        return "DiccionarioTecnico{" +
                "totalPalabras=" + getTotalPalabras() +
                ", redes=" + redes.size() +
                ", impresoras=" + impresoras.size() +
                ", cuentas=" + cuentas.size() +
                ", hardware=" + hardware.size() +
                '}';
    }
}

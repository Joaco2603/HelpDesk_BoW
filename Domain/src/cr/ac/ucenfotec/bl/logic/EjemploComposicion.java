package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Tockenizer;
import cr.ac.ucenfotec.dl.DiccionarioEmocional;
import cr.ac.ucenfotec.dl.DiccionarioTecnico;

import java.util.ArrayList;

/**
 * Clase de ejemplo que demuestra la relación de COMPOSICIÓN
 * entre los Diccionarios y las Palabras (Tockenizer)
 * 
 * Composición: Los diccionarios CONTIENEN palabras (0..*)
 */
public class EjemploComposicion {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  DEMOSTRACIÓN DE COMPOSICIÓN: Diccionarios → Palabras     ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // ============================================================
        // 1. CREAR DICCIONARIOS (Composición: crean sus palabras)
        // ============================================================
        System.out.println("1️⃣  Creando DiccionarioEmocional...");
        DiccionarioEmocional dicEmocional = new DiccionarioEmocional();
        System.out.println("   ✓ Diccionario creado con " + dicEmocional.getTotalPalabras() + " palabras\n");
        
        System.out.println("2️⃣  Creando DiccionarioTecnico...");
        DiccionarioTecnico dicTecnico = new DiccionarioTecnico();
        System.out.println("   ✓ Diccionario creado con " + dicTecnico.getTotalPalabras() + " palabras\n");
        
        // ============================================================
        // 2. MOSTRAR COMPOSICIÓN: Diccionario CONTIENE Palabras
        // ============================================================
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("COMPOSICIÓN EMOCIONAL: DiccionarioEmocional ◆→ Palabras");
        System.out.println("═══════════════════════════════════════════════════════════");
        mostrarCategoriasEmocionales(dicEmocional);
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("COMPOSICIÓN TÉCNICA: DiccionarioTecnico ◆→ Palabras");
        System.out.println("═══════════════════════════════════════════════════════════");
        mostrarCategoriasTecnicas(dicTecnico);
        
        // ============================================================
        // 3. DEMOSTRAR ACCESO A LAS PALABRAS CONTENIDAS
        // ============================================================
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("ACCESO A PALABRAS CONTENIDAS (Relación 0..*)");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        System.out.println("\n🔹 Palabras de URGENCIA (Emocional):");
        ArrayList<Tockenizer> urgencia = dicEmocional.getUrgencia();
        for (Tockenizer palabra : urgencia) {
            System.out.println("   • " + palabra.getPalabra() + 
                             " [" + palabra.getClasificacion() + ": " + 
                             palabra.getCategoria() + "]");
        }
        
        System.out.println("\n🔹 Palabras de REDES (Técnico):");
        ArrayList<Tockenizer> redes = dicTecnico.getRedes();
        for (Tockenizer palabra : redes) {
            System.out.println("   • " + palabra.getPalabra() + 
                             " [" + palabra.getClasificacion() + ": " + 
                             palabra.getCategoria() + "]");
        }
        
        // ============================================================
        // 4. AGREGAR NUEVAS PALABRAS (Composición: añadir partes)
        // ============================================================
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("AGREGAR NUEVAS PALABRAS AL DICCIONARIO");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        System.out.println("\n➕ Agregando 'desesperado' al diccionario emocional...");
        Tockenizer nuevaPalabraEmocional = new Tockenizer("desesperado", "Emocional", "Frustración");
        dicEmocional.addPalabra(nuevaPalabraEmocional);
        System.out.println("   ✓ Total palabras ahora: " + dicEmocional.getTotalPalabras());
        
        System.out.println("\n➕ Agregando 'vpn' al diccionario técnico...");
        Tockenizer nuevaPalabraTecnica = new Tockenizer("vpn", "Técnico", "Redes");
        dicTecnico.addPalabra(nuevaPalabraTecnica);
        System.out.println("   ✓ Total palabras ahora: " + dicTecnico.getTotalPalabras());
        
        // ============================================================
        // 5. OBTENER CATEGORÍA POR NOMBRE (Método del diagrama UML)
        // ============================================================
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("OBTENER CATEGORÍA POR NOMBRE (Método UML)");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        System.out.println("\n🔍 Buscando categoría 'Positivo' en diccionario emocional:");
        ArrayList<Tockenizer> positivos = dicEmocional.getCategoria("Positivo");
        System.out.println("   Encontradas " + positivos.size() + " palabras positivas");
        System.out.println("   Primeras 3: " + 
                         positivos.get(0).getPalabra() + ", " +
                         positivos.get(1).getPalabra() + ", " +
                         positivos.get(2).getPalabra());
        
        System.out.println("\n🔍 Buscando categoría 'Hardware' en diccionario técnico:");
        ArrayList<Tockenizer> hardware = dicTecnico.getCategoria("Hardware");
        System.out.println("   Encontradas " + hardware.size() + " palabras de hardware");
        System.out.println("   Primeras 3: " + 
                         hardware.get(0).getPalabra() + ", " +
                         hardware.get(1).getPalabra() + ", " +
                         hardware.get(2).getPalabra());
        
        // ============================================================
        // 6. OBTENER ATRIBUTO (Clasificación general)
        // ============================================================
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("OBTENER ATRIBUTO (Método UML)");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        System.out.println("\n📋 Atributo del diccionario emocional: " + dicEmocional.getAtributo());
        System.out.println("📋 Atributo del diccionario técnico: " + dicTecnico.getAtributo());
        
        // ============================================================
        // 7. RESUMEN FINAL
        // ============================================================
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                    RESUMEN DE COMPOSICIÓN                  ║");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.println("║  DiccionarioEmocional ◆──→ " + dicEmocional.getTotalPalabras() + " Palabras (Tockenizer)     ║");
        System.out.println("║  DiccionarioTecnico   ◆──→ " + dicTecnico.getTotalPalabras() + " Palabras (Tockenizer)     ║");
        System.out.println("║                                                            ║");
        System.out.println("║  Total de palabras en el sistema: " + 
                         (dicEmocional.getTotalPalabras() + dicTecnico.getTotalPalabras()) + "                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        
        System.out.println("\n✅ La relación de COMPOSICIÓN está correctamente implementada");
        System.out.println("   - Los diccionarios CONTIENEN palabras (0..*) ");
        System.out.println("   - Las palabras son PARTE INTEGRAL de los diccionarios");
        System.out.println("   - El ciclo de vida de las palabras depende del diccionario");
    }
    
    /**
     * Muestra todas las categorías emocionales y su cantidad de palabras
     */
    private static void mostrarCategoriasEmocionales(DiccionarioEmocional dic) {
        System.out.println("\n📊 Categorías Emocionales:");
        System.out.println("   ├─ Frustración:  " + dic.getFrustracion().size() + " palabras");
        System.out.println("   ├─ Urgencia:     " + dic.getUrgencia().size() + " palabras");
        System.out.println("   ├─ Neutralidad:  " + dic.getNeutralidad().size() + " palabras");
        System.out.println("   └─ Positivo:     " + dic.getPositivo().size() + " palabras");
        System.out.println("   ───────────────────────────────");
        System.out.println("   TOTAL:           " + dic.getTotalPalabras() + " palabras");
    }
    
    /**
     * Muestra todas las categorías técnicas y su cantidad de palabras
     */
    private static void mostrarCategoriasTecnicas(DiccionarioTecnico dic) {
        System.out.println("\n📊 Categorías Técnicas:");
        System.out.println("   ├─ Redes:        " + dic.getRedes().size() + " palabras");
        System.out.println("   ├─ Impresoras:   " + dic.getImpresoras().size() + " palabras");
        System.out.println("   ├─ Cuentas:      " + dic.getCuentas().size() + " palabras");
        System.out.println("   └─ Hardware:     " + dic.getHardware().size() + " palabras");
        System.out.println("   ───────────────────────────────");
        System.out.println("   TOTAL:           " + dic.getTotalPalabras() + " palabras");
    }
}

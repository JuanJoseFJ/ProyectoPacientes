/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloMedico;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CRISTIAN
 */
public class Tabla {
    
    public void LimpiarTabla(DefaultTableModel tabla) // COMPLETO 
    {
        int filas = tabla.getRowCount(); // cuenta numero de filas q tiene la tabla 
        for(int i=0; i<filas; i++)
        {
            tabla.removeRow(0);// valor fijo de 0
        }
    }
}

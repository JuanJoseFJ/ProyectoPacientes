
import Vistas.JFprincipal;

public class Principal {


    public static void main(String[] args) {
        
        JFprincipal frmPrincipal = new JFprincipal(); //es padre
        frmPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH); //se extienda 

        frmPrincipal.setVisible(true);//lo hacemos visible        
        
    }
    
}

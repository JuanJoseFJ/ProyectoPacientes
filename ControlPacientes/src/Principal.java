
import Vistas.JFprincipal;
import org.opencv.core.Core;

public class Principal {


    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        JFprincipal frmPrincipal = new JFprincipal(); //es padre
        frmPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH); //se extienda 

        frmPrincipal.setVisible(true);//lo hacemos visible        
        
    }
    
}

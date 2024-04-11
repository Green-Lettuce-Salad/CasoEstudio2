package cinema;

import javax.swing.JOptionPane;

public class CineComing {
    
    public void CineIngreso(){
        Cine matCine[][] = new Cine[5][6];
        
        String mapa = "";
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (matCine[i][j] == null) {
                    matCine[i][j] = new Cine("L");
                    mapa = mapa + matCine[i][j].getEstado();
                } 
            }
            mapa = mapa + " "+ (i+1) +"\n";
        }
        
        mapa = mapa + "ABCDEF";
        
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantas personas van a ingresar?"));
        
        for (int x = 0; x < cant; x++) {
            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la fila de preferencia\n\n"+mapa+"\n\n"));
            String data = JOptionPane.showInputDialog("Ingrese la letra de la columna de preferencia\n\n"+mapa+"\n\n");
            int columna = 0;

            switch (data) {
                case "A" ->
                    columna = 0;
                case "B" ->
                    columna = 1;
                case "C" ->
                    columna = 2;
                case "D" ->
                    columna = 3;
                case "E" ->
                    columna = 4;
                case "F" ->
                    columna = 5;
            }

            int result = matCine[fila-1][columna].getEstado().compareTo("O");

            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Este asiento está ocupado");
            }
            if (result != 0) {
                matCine[fila-1][columna] = new Cine("O");
                JOptionPane.showMessageDialog(null, "Asiento reservado con éxito");
            }
            
            mapa = "";
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    mapa = mapa + matCine[i][j].getEstado();
                    
                }
                mapa = mapa + " "+ (i+1) +"\n";
            }
        
            mapa = mapa + "ABCDEF";
            
            
            JOptionPane.showMessageDialog(null, "Se agregaron los campos con éxito\n\n"+mapa+"\n\n");
        }
    }
}

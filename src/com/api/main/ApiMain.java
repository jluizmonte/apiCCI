package com.api.main;

import com.api.view.Splash;

/**
 *
 * @author joseluiz
 */
public class ApiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Splash splash = new Splash(null, true);
        splash.criarPastas();
        splash.fechar();
        splash.setVisible(true);
    }
}

package com.api.util;

/**
 * Classe com variavéis para obter informações especificas sobre o sistema
 *
 * @author jluiz
 */
public class ObterInfoSistemaUtil {

    private final String controlecciVersao = " v. 1.0";
    private final String arquiteturaSistema = System.getProperty("os.arch");
    private final String nomeSistema = System.getProperty("os.name");
    private final String versaoSistema = System.getProperty("os.version");
    private final String diretorioUsuario = System.getProperty("user.dir");
    private final String pastaHomeUsuario = System.getProperty("user.home");
    private final String idiomaSistema = System.getProperty("user.language");
    private final String nomeUsuario = System.getProperty("user.name");

    /**
     * @return the arquiteturaSistema
     */
    public String getArquiteturaSistema() {
        return arquiteturaSistema;
    }

    /**
     * @return the nomeSistema
     */
    public String getNomeSistema() {
        return nomeSistema;
    }

    /**
     * @return the versaoSistema
     */
    public String getVersaoSistema() {
        return versaoSistema;
    }

    /**
     * @return the diretorioUsuario
     */
    public String getDiretorioUsuario() {
        return diretorioUsuario;
    }

    /**
     * @return the pastaHomeUsuario
     */
    public String getPastaHomeUsuario() {
        return pastaHomeUsuario;
    }

    /**
     * @return the idiomaSistema
     */
    public String getIdiomaSistema() {
        return idiomaSistema;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @return the controlecciVersao
     */
    public String getAcervoVersao() {
        return controlecciVersao;
    }

}

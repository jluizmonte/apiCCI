package com.api.util;

import com.api.model.SessaoUsuarioModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Classe com as configurações dos arquivos de Log
 *
 * @author joseluiz
 *
 */
public class LogCatUtil {

    File logCat;
    ObterInfoSistemaUtil obterInfoSistema = new ObterInfoSistemaUtil();

    /**
     * criação do aquivo
     */
    public void createFile() {

        logCat = new File(LocalUtil.logFile);

        try {
            logCat.createNewFile();
        } catch (IOException e) {
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(e));
        }

    }

    /**
     * Escrita do log quando for estourado um erro
     *
     * @param log log
     */
    public void writeFile(String log) {
        logCat = new File(LocalUtil.logFile);
        try {
            if ((log == "") || (log == null)) {
                log = "Sem mais registros!";
                LocalUtil.logClass = getClass().toString();
            }

            if (SessaoUsuarioModel.nomeUsuario == null) {
                SessaoUsuarioModel.nomeUsuario = "Usuári@ não logad@";
            }
            FileWriter fileWriter = new FileWriter(logCat, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write("--------");
            bufferedWriter.newLine();
            bufferedWriter.write("USUÁRIO: " + SessaoUsuarioModel.nomeUsuario);
            bufferedWriter.newLine();
            bufferedWriter.write("CLASSE ONDE OCORREU O ERRO: " + LocalUtil.logClass);
            bufferedWriter.newLine();
            bufferedWriter.write("DATA E HORA DO ERRO: " + new LocalUtil().logDateNow);
            bufferedWriter.newLine();
            bufferedWriter.write("DESCRIÇÃO DO ERRO: " + log);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
                    JOptionPane.ERROR_MESSAGE);
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(ex));
        }
    }

    /**
     * cabeçalho padrão do arquivo de log
     */
    public void firstWriteFile() {
        logCat = new File(LocalUtil.logFile);
        try {
            FileWriter fileWriter = new FileWriter(logCat);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("<><>LOGS DO SISTEMA CONTROLE CCI<><>\n");
            bufferedWriter.newLine();
            bufferedWriter.write("INSTITUIÇÃO: " + LocalUtil.logLibrary);
            bufferedWriter.newLine();
            bufferedWriter.write("DATA CRIAÇÃO DO ARQUIVO DE LOG: " + new LocalUtil().logDateNow);
            bufferedWriter.newLine();
            bufferedWriter.write("SISTEMA OPERACIONAL: " + new ObterInfoSistemaUtil().getNomeSistema());
            bufferedWriter.newLine();
            bufferedWriter.write("LICENCIADO PARA: " + new ObterInfoSistemaUtil().getNomeUsuario());
            bufferedWriter.newLine();
            bufferedWriter.write("VERSÃO ATUAL DO SISTEMA:" + obterInfoSistema.getAcervoVersao() + " Final 2022");
            ;
            bufferedWriter.newLine();
            bufferedWriter.write("<<<<< LOGCAT >>>>>\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(new LocalUtil().logDateNow + ": " + "O SISTEMA FOI INSTALADO COM SUCESSO!\n");
            bufferedWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
                    JOptionPane.ERROR_MESSAGE);
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(e));
        }
    }

    /**
     * Criação de um changelog
     */
    public void createWriteChangeLog() {

        logCat = new File(LocalUtil.changelogFile);

        try {
            logCat.createNewFile();
        } catch (IOException e) {
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(e));
        }
        try {
            FileWriter fileWriter = new FileWriter(logCat);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(e));
        }

    }

    /**
     * leitura dos arquivos de log e changelog para exibir numa tela
     */
    public void readNameLogs() {
        File folder = new File(LocalUtil.logFolderDirectory);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                LocalUtil.logLibrary += listOfFiles[i].getName();
            }
        }
    }
}

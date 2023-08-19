package org.com.labs.utils;

import java.util.Scanner;

public class TerminalUI {

    private String[] args;

    public TerminalUI(String[] args) {
        this.args = args;
    }

    private final Scanner scanner = new Scanner(System.in);

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void showAppHeader(){
        this.clear();
        System.out.println("============== Labs File Parser ============== ");
    }

    /*  Verifies if the path was passed on execution arguments
     *  In case not, the path will be requested on the terminal
     * */
    public String getFilePath() {

        if(args.length == 0){
            System.out.println("|> Informe o diretorio completo do arquivo: ");
            return scanner.nextLine();
        }

        return this.args[0];

    }

    public boolean getMinified() {
        clear();
        System.out.println("|> Deseja fazer o minify no arquivo de saída ? (S/N)");
        String minify = scanner.nextLine().toLowerCase();

        if(minify.equals("s")) return true;
        else if(minify.equals("n")) return false;
        else return getMinified();
    }

    public void print(String str) {
        System.out.println(str);
    }

}

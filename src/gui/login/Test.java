/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.login;



/**
 *
 * @author chiri
 */
public class Test {
    private String intrebare;
    private int idIntrebareAleasa;
    private String[] raspunsuri;
    private int idIntrebareCorecta;
    private int numarTeste;

    Test() {
        
    }

    public int getNumarTeste() {
        return numarTeste;
    }

    public void setNumarTeste(int numarTeste) {
        this.numarTeste = numarTeste;
    }
    Test(String intreabare){
        this.intrebare = intreabare;
        raspunsuri = new String[4];
        
    }

    public String getIntrebare() {
        return intrebare;
    }

    public void setIntrebare(String intrebare) {
        this.intrebare = intrebare;
    }

    public int getIdIntrebareAleasa() {
        return idIntrebareAleasa;
    }

    public void setIdIntrebareAleasa(int idIntrebareAleasa) {
        this.idIntrebareAleasa = idIntrebareAleasa;
    }

    public String[] getRaspunsuri() {
        return raspunsuri;
    }

    public void setRaspuns(String raspuns, int idRaspuns) {
        this.raspunsuri[idRaspuns] = raspuns;
    }
    
    public void setIdIntrebareCorecta(int idIntrebareCorecta){
        this.idIntrebareCorecta = idIntrebareCorecta;
    }
    
    public int getIdIntrebareCorecta(){
        return idIntrebareCorecta;
    }
}

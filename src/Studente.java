import java.util.Date;

public class Studente {
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private int matricola;
    private String corsoDiStudi;
    private float[] voti;

    public Studente() {
        voti = new float[10];
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getMatricola() {
        return matricola;
    }

    public String getCorsoDiStudi() {
        return corsoDiStudi;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void setCorsoDiStudi(String corsoDiStudi) {
        this.corsoDiStudi = corsoDiStudi;
    }

    public void aggiungiVoto(float voto, int corso) {
        if (corso >= 0 && corso < 10) {
            voti[corso] = voto;
        }
    }

    public void rimuoviVoti() {
        for (int i = 0; i < 10; i++) {
            voti[i] = 0.0f;
        }
    }

    public float calcolaMediaVoti() {
        float somma = 0;
        int conteggio = 0;
        for (int i = 0; i < 10; i++) {
            somma += voti[i];
            if (voti[i] != 0) {
                conteggio++;
            }
        }
        if (conteggio == 0) {
            return 0; // Evita divisione per zero
        }
        return somma / conteggio;
    }

    public int calcolaEta() {
        Date oggi = new Date();
        long differenza = oggi.getTime() - dataDiNascita.getTime();
        int anni = (int) (differenza / (365 * 24 * 60 * 60 * 1000L));
        return anni;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Cognome: " + cognome + "\n" +
                "Matricola: " + matricola + "\n" +
                "Corso di Studi: " + corsoDiStudi + "\n" +
                "Voti: " + java.util.Arrays.toString(voti);
    }
}

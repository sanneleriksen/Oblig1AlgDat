import java.util.ArrayList;
import java.util.NoSuchElementException;

//Sanne Eriksen, s344225
public class Oblig1 {
    //Oppgave 1
    public static int maks(int[] a){
        if(a.length == 0){
            throw new NoSuchElementException();
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int midlertidig = a[i + 1];
                a[i + 1] = a[i];
                a[i] = midlertidig;
            }
        }
        return a[a.length-1];
    }

    //Det blir flest ombyttinger når det største tallet er først, og færrest når det største tallet allerede er bakerst (0)
    public static int ombyttinger(int[] a){
        int antall = 0;
        if(a.length == 0){
            throw new NoSuchElementException();
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int midlertidig = a[i + 1];
                a[i + 1] = a[i];
                a[i] = midlertidig;
                antall++;
            }
        }
        return antall;
    }

    //Oppgave 2
    public static int antallUlikeSortert(int[] a){
        if(a.length == 0){
            return 0;
        }
        //Teller settes til 1, ettersom første tall ikke blir telt og er tallet som sammenlignes mot de andre tallene.
        int teller = 1;
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i+1]){
                throw new IllegalStateException();
            }
            //Telleren går opp så lenge den finner et ulikt tall på neste plass i arrayet
            if(a[i] != a[i+1]){
                teller++;
            }
        }
        return teller;
    }

    //Oppgave 3
    public static int antallUlikeUsortert(int[] a){
        if(a.length == 0){
            return 0;
        }
        ArrayList<Integer> unikeTall = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (!unikeTall.contains(a[i])) {
                unikeTall.add(a[i]);
            }
        }
        return unikeTall.size();
    }

    //Oppgave 4
    public static void delsortering(int[] a){
        int antallOddetall = 0;
        //Bruker modulo for å finne antall oddetall
        for(int i = 0; i < a.length; i++){
            if(a[i]%2!=0){
                antallOddetall++;
            }
        }

        //Flytter oddetallene til venstre side, og partallene til høyre side
        for(int j = 0; j < antallOddetall; j++){
            if(a[j]%2 == 0){
                for(int k = antallOddetall; k < a.length; k++){
                    if(a[k]%2 != 0){
                        int midlertidig = a[k];
                        a[k] = a[j];
                        a[j] = midlertidig;
                        break;
                    }
                }
            }
        }

        //Sorterer oddetallene i stigende rekkefølge
        for(int j = 0; j < antallOddetall; j++){
            for(int k = j; k < antallOddetall; k++){
                if(a[j] > a[k]){
                    int midlertidig = a[k];
                    a[k] = a[j];
                    a[j] = midlertidig;
                }
            }
        }

        //Sorterer partallene i stigende rekkefølge
        for(int j = antallOddetall; j < a.length; j++){
            for(int k = j; k < a.length; k++){
                if(a[j] > a[k]){
                    int midlertidig = a[k];
                    a[k] = a[j];
                    a[j] = midlertidig;
                }
            }
        }
    }

    //Oppgave5
    public static void rotasjon(char[] a){
        if(a.length == 0){
            return;
        }
        char midlertidig = a[a.length-1];
        for(int i = a.length -1; i > 0; i--){
            a[i] = a[i-1];
        }
        a[0] = midlertidig;
    }

    //Oppgave 7a
    public static String flett(String s, String t){
        int kortest = Math.min(s.length(), t.length());
        String flettet = "";

        for(int i = 0; i < kortest; i++){
            flettet += s.charAt(i);
            flettet += t.charAt(i);
        }

        if(t.length() > s.length()){
            for(int j = kortest; j < t.length(); j++){
                flettet += t.charAt(j);
            }
        }else if(s.length() > t.length()){
            for(int k = kortest; k < s.length(); k++){
                flettet += s.charAt(k);
            }
        }
        return flettet;
    }

    //Forstår ikke helt hva oppgave 7b ønsker at jeg skal gjøre
}

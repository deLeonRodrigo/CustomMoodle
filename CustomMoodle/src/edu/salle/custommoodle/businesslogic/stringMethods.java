package edu.salle.custommoodle.businesslogic;

/**
 * Rodrigo Eugenio de León Castilla | Mat. 66330
 * Universidad de La Salle Bajío
 */
public class stringMethods {
    public static char getVocal(int index, String word){
        char aux;
        int indexAux = 0;
        for(int i = 0; i < word.length(); i++){
            aux = word.charAt(i);
            if (aux == 'A'||aux == 'E'||aux == 'I'||aux == 'O'||aux == 'U'){
                indexAux++;
                if(indexAux == index) return word.charAt(i);
            }
        }
        System.out.println("No vocals found or not enough vocals on the word, will return ' '");
        return ' ';
    }
    public static char getConsonant(int index, String word){
        char aux;
        int indexAux = 0;
        for(int i = 0; i < word.length(); i++){
            aux = word.charAt(i);
            if (aux != 'A' && aux != 'E' && aux != 'I' && aux != 'O' && aux != 'U'){
                indexAux++;
                if(indexAux == index) return word.charAt(i);
            }
        }
        System.out.println("No consonants found or not enough consonants on the word, will return ' '");
        return ' ';
    }
}

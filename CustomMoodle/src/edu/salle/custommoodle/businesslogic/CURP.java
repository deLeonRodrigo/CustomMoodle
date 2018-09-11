package edu.salle.custommoodle.businesslogic;

/**
 * Rodrigo Eugenio de León Castilla | Mat. 66330
 * Universidad de La Salle Bajío
 */
public class CURP {
    public String name;
    public String lastNameF; //Father's last name
    public String lastNameM; //Mother's last name
    public String day; // Day of birth
    public String month; // Month of birth
    public String year; // year of birth
    public char gender; // H for male, M for female (spanish)
    public String homeState; // Place of Birth
    public String getCURP(){
        checkName();
        String CURP = "";
        CURP += lastNameF.charAt(0);
        CURP += stringMethods.getVocal(1, lastNameF);
        CURP += lastNameM.charAt(0);
        CURP += name.charAt(0);
        CURP += year + month + day;
        getHomeStateInitials(homeState);
        CURP += gender + homeState + stringMethods.getConsonant(1, lastNameF.substring(1)) 
                + stringMethods.getConsonant(1, lastNameM.substring(1)) + stringMethods.getConsonant(1, name.substring(1));
        return CURP;
    }
    public void getHomeStateInitials(String state){
        if(state.equals("Aguascalientes")) this.homeState = "AS";
        if(state.equals("Baja California")) this.homeState = "BC";
        if(state.equals("Baja California Sur")) this.homeState = "BS";
        if(state.equals("Campeche")) this.homeState = "CC";
        if(state.equals("Chiapas")) this.homeState = "CS";
        if(state.equals("Chihuahua")) this.homeState = "CH";
        if(state.equals("Coahuila")) this.homeState = "CL";
        if(state.equals("Colima")) this.homeState = "CM";
        if(state.equals("Ciudad de México")) this.homeState = "DF";
        if(state.equals("Durango")) this.homeState = "DG";
        if(state.equals("Guanajuato")) this.homeState = "GT";
        if(state.equals("Guerrero")) this.homeState = "GR";
        if(state.equals("Hidalgo")) this.homeState = "HG";
        if(state.equals("Jalisco")) this.homeState = "JC";
        if(state.equals("México")) this.homeState = "MC";
        if(state.equals("Michoacán")) this.homeState = "MN";
        if(state.equals("Morelos")) this.homeState = "MS";
        if(state.equals("Nayarit")) this.homeState = "NT";
        if(state.equals("Nuevo León")) this.homeState = "NL";
        if(state.equals("Oaxaca")) this.homeState = "OC";
        if(state.equals("Puebla")) this.homeState = "PL";
        if(state.equals("Querétaro")) this.homeState = "QO";
        if(state.equals("Quintana Roo")) this.homeState = "QR";
        if(state.equals("San Luis Potosí")) this.homeState = "SP";
        if(state.equals("Sinaloa")) this.homeState = "SL";
        if(state.equals("Sonora")) this.homeState = "SR";
        if(state.equals("Tabasco")) this.homeState = "TC";
        if(state.equals("Tamaulipas")) this.homeState = "TS";
        if(state.equals("Tlaxcala")) this.homeState = "TL";
        if(state.equals("Veracruz")) this.homeState = "VZ";
        if(state.equals("Yucatán")) this.homeState = "YN";
        if(state.equals("Zacatecas")) this.homeState = "ZS";
        if(state.equals("No Mexicano")) this.homeState = "NE";
    }
    public void checkName(){
        if(name.equals("JOSE MARIA") || name.equals("MARIA JOSE")){
            name = "XXXX";
        }else if(name.contains("MARIA")){
            String[] splitName = name.split(" ");
            if(splitName.length > 1){
               if("MARIA".equals(splitName[0])) name = splitName[1];
               else name = splitName[0];
            } else name = "XXXX";
        } else if (name.contains("JOSÉ") || name.contains("JOSE")){
            String[] splitName = name.split(" ");
            if(splitName.length > 1){
                if("JOSÉ".equals(splitName[0]) || "JOSE".equals(splitName[0])) name = splitName[1];
                else name = splitName[0];
            }else name = "XXXX";
        }
    }
}

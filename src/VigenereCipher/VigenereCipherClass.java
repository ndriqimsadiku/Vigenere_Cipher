package VigenereCipher;

import java.util.List;

public class VigenereCipherClass {
   
    public static String encrypt(String plaintexti, String celesi) {    
    	
        if (!celesi.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Invalid key, it must be one, or more characters in range from a to z");
       
        plaintexti = plaintexti.replaceAll("[^a-zA-Z]", "").toUpperCase();        
        celesi = StringUtilClass.rptString(celesi, plaintexti.length()).toUpperCase();

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintexti.length(); i++) {            
            String toEncrypt = String.valueOf(plaintexti.charAt(i)); 
            
            int shift = celesi.charAt(i) - 'A';
            ciphertext.append(encryptCaesar(toEncrypt, shift));
        }
        return ciphertext.toString();
    }
    
    public static String decrypt(String cipherteksti, String celesi) {
       
        if (celesi == null || !celesi.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Key must have one, or more characters in range from a to z");
       
        cipherteksti = cipherteksti.replaceAll("[^a-zA-Z]", "").toUpperCase();       
        celesi = StringUtilClass.rptString(celesi, cipherteksti.length()).toUpperCase();

        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < cipherteksti.length(); i++) {            
            String perDekriptim = String.valueOf(cipherteksti.charAt(i));
            
            int Cshift = celesi.charAt(i) - 'A';
            plaintext.append(decryptCaesar(perDekriptim, Cshift));
        }
        return plaintext.toString();
    }
   
    public static int CalcBestGuessLenOfKey(String ciphertexti) {
        if (ciphertexti == null || ciphertexti.length() == 0)
            return -1;
        
        ciphertexti = ciphertexti.replaceAll("[^a-zA-Z]", "");        
        int maximalLenOfKey = 12;
        maximalLenOfKey = maximalLenOfKey > ciphertexti.length() ? ciphertexti.length() : maximalLenOfKey;

        for (int i = 2; i < maximalLenOfKey; i++) {
            
           // List<String> stringsNeIntervalin = StringUtilClass.StrsAtInterval(ciphertexti, i);
            
//            double tempIndexofC = stringsNeIntervalin.stream()
//                    
//                    .mapToDouble(FreqLetterClass::indexOfCoincidence)
//                    
//                    .average().getAsDouble();
//            
//            if (FreqLetterClass.closeToEng(tempIndexofC))
//                return i;
        }

        return -1;
    }
   
    public static String calculateKey(String ciphertext) {
        int lengthofK = CalcBestGuessLenOfKey(ciphertext);
        
      if (lengthofK == -1) return null;
        
        List<String> caesarCipherStrings = StringUtilClass.StrsAtInterval(ciphertext, lengthofK);
      StringBuilder celesi = new StringBuilder();
        
        for (String caesarCipherTxt : caesarCipherStrings) {            
            int Cshift = calculateShiftCaesar(caesarCipherTxt);            
           char VleraChar = (char) (Cshift + 'A');            
         celesi.append(VleraChar);
     }

        return celesi.toString();
    }
    
   
    
    public static String decryptCaesar(String ciferteksti, int shifti) {
        
    	 ciferteksti = ciferteksti.replaceAll("[^a-zA-Z]", "").toUpperCase();
         StringBuilder plainteksti = new StringBuilder();
         for (char c : ciferteksti.toCharArray()) {
             int pozicioni = c - 'A';
             
             pozicioni -= shifti;
             
             //pozicioni = Math.floorMod(pozicioni, FreqLetterClass.ALPHABET_COUNT);
             
             pozicioni += 'A';
             plainteksti.append((char) pozicioni);
         }
         return plainteksti.toString();

    }
  public static String encryptCaesar(String plainteksti, int shifti) {
        
	  plainteksti = plainteksti.replaceAll("[^a-zA-Z]", "").toUpperCase();
      StringBuilder ciferteksti = new StringBuilder();
      for (char c : plainteksti.toCharArray()) {
         int pozicioni = c - 'A';
          
          pozicioni += shifti;
         
        //  pozicioni = Math.floorMod(pozicioni, FreqLetterClass.ALPHABET_COUNT);
          
          pozicioni += 'A';
          ciferteksti.append((char) pozicioni);
      }
      return ciferteksti.toString();

    }
    
  
   
  
   
    public static int calculateShiftCaesar(String ciferteksti) {
    	 ciferteksti = ciferteksti.replaceAll("[^a-zA-Z]", "");
         int shiftimi = 0;
         double maks = Integer.MAX_VALUE;
//         for (int i = 0; i < FreqLetterClass.ALPHABET_COUNT; i++) {
//              double tempMaksimumi = FreqLetterClass.chiSquareAgainstEnglish(decryptCaesar(ciferteksti, i));
//              if (tempMaksimumi < maks) {
//                 maks = tempMaksimumi;
//                 shiftimi = i;
//             }
//         }
         return shiftimi;

    }
}
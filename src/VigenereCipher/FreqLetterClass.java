package VigenereCipher;



public class FreqLetterClass {

    public static int alfabeti = 26;

     public static double kufiriPoshtem = 0.061;
    public static double kufiriEperm = 0.071;
    public static double indexi = 0.0686;

   
    public static double A = 8.167;
    public static double B = 1.492;
    public static double C = 2.782;
    public static double D = 4.253;
    public static double E = 12.702;
    public static double F = 2.228;
    public static double G = 2.015;
    public static double H = 6.094;
    public static double I = 6.966;
    public static double J = 0.153;
    public static double K = 0.772;
    public static double L = 4.025;
    public static double M = 2.406;
    public static double N = 6.749;
    public static double O = 7.507;
    public static double P = 1.929;
    public static double Q = 0.095;
    public static double R = 5.987;
    public static double S = 6.327;
    public static double T = 9.056;
    public static double U = 2.758;
    public static double V = 0.978;
    public static double W = 2.360;
    public static double X = 0.150;
    public static double Y = 1.974;
    public static double Z = 0.074;

    public static double[] FREKUENCAT = {
            A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
    };

    public static int[] countChar(String m) {
        m = m.replaceAll("[^a-zA-Z]", "").toUpperCase();
        int[] n = new int[alfabeti];
        for (char c : m.toCharArray())
            n[c - 'A']++;
        return n;
    }

   
    public static double[] expCharCount(int l) {
        double[] exp = new double[alfabeti];
        for (int i = 0; i < alfabeti; i++) {
            
            exp[i] = (l * (FREKUENCAT[i] / 100));
        }
        return exp;
    }

   
    public static boolean closeToEng(double indeksC) {
        return kufiriPoshtem < indeksC && indeksC < kufiriEperm;
    }

   
    public static double indeksC(String teksti) {

        
        teksti = teksti.replaceAll("[^a-zA-Z]", "").toUpperCase();
        if (teksti.length() < 1) return -1;
       
        int[] counts = FreqLetterClass.countChar(teksti);

        double sum = 0.0;
        
        for (int i = 0; i < FreqLetterClass.alfabeti; i++) {
            double fi = counts[i];
            if (fi > 0.0)
                sum += fi * (fi - 1.0);
        }
        
        return sum / (teksti.length() * (teksti.length() - 1));
    }

   
    public static double CharIndSquareAgEnglish(String ciferteksti) {
        ciferteksti = ciferteksti.replaceAll("[^a-zA-Z]", "");
         int[] charCount = FreqLetterClass.countChar(ciferteksti);
       
        double[] expCharCount = FreqLetterClass.expCharCount(ciferteksti.length());

        double f = 0.0;
        for (int i = 0; i < FreqLetterClass.alfabeti; i++) {
           
            f += Math.pow(charCount[i] - expCharCount[i], 2) / expCharCount[i];
        }
        return f;
    }
}

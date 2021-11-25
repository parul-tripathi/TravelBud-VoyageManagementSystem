package com.arnav.verma;

public class GeneratePNR
{
	/*public static void main(String[] args) {
		GeneratePNR obj =new GeneratePNR();
		System.out.println(obj.randomAlphaNumeric(11));
	}*/
	
    private static final String ALPHA_NUMERIC_STRINGA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA_NUMERIC_STRINGB = "0123456789";
    
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        int n=count;
        while (count-- != 0) {
            if(count>=((n+1)/2)){
                int character = (int)(Math.random()*ALPHA_NUMERIC_STRINGA.length());
                builder.append(ALPHA_NUMERIC_STRINGA.charAt(character));
            }
            else{
                int character = (int)(Math.random()*ALPHA_NUMERIC_STRINGB.length());
                builder.append(ALPHA_NUMERIC_STRINGB.charAt(character));
            }
        }
        return builder.toString();
    }
}

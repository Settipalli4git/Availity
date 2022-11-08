package com.availity;

import java.util.Stack;

public class LISPChecker {

    public static void main(String[] args){
        String testVal = "(I am a(test)(test23)$#())";
        if(validateParanthesisLISP(testVal)) {
        	System.out.println("It is Good");
        } else {
        	System.out.println("It is INVALID");
        }
        System.out.println(validateParanthesisLISP("") ? "It is Good" : "It is INVALID");
        System.out.println(validateParanthesisLISP(")") ? "It is Good" : "It is INVALID");
        System.out.println(validateParanthesisLISP("()()") ? "It is Good" : "It is INVALID");
        System.out.println(validateParanthesisLISP("()(()") ? "It is Good" : "It is INVALID");
    }

   public static boolean validateParanthesisLISP(String code) 
    {
        if (code == null || code.length() == 0) return true;
        String value = code.replaceAll("[^()]","");
        Stack lispStack = new Stack();
        
        for (char c : value.toCharArray()) {
            switch(c){
                case('('):
                    lispStack.push("(");
                    break;
                case(')'):
                    if (lispStack.empty() || lispStack.peek() != "(") return false;
                    lispStack.pop();
                    break;
            }
        }
    
        return lispStack.empty();
    }
}

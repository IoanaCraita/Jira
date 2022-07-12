package com.ioana;

public class Improvement extends Issue {

   private String reasonForImprovement;

    public String getReasonForImprovement() {
        return reasonForImprovement;
    }

    public void setReasonForImprovement(String reasonForImprovement) {
        this.reasonForImprovement = reasonForImprovement;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(reasonForImprovement);
    }
}


//printline o sa printeze pe 2 linii diferite
// print doar printeaza , daca vreau sa trimit undeva stringul nu as putea
//imparteala pe pachete
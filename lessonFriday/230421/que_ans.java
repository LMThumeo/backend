import java.io.Serializable;

class que_ans implements Serializable{
    String ques,a,b,c,d,ans;
    public que_ans(){};
    public que_ans(String ques, String a, String b, String c, String d, String ans){
        this.ques=ques;
        this.a=a;
        this.b=b;
        this.c=c;
        this .d=d;
        this.ans=ans;
    };
    public String getAns(){
        return ans;
    }

    void display(){
        System.out.println("Cau hoi: "+ques);
        System.out.println("A. "+a);
        System.out.println("B. "+b);
        System.out.println("C. "+c);
        System.out.println("D. "+d);
    } 
  
}

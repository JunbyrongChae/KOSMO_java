package Quiz.step1;
class One{
    public One foo(){return this;}
}
class Two extends One{
    public One foo(){
        return this;
    }
}
class Three extends Two{
    //insert method here
}
public class Q10v {
}


/**********************************************************
 * Which two methods, inserted individually, correctly complete the Three class? (Choose two.)
 * A. public void foo() { }
 * B. public int foo() { return 3; }
 * C. public Two foo() { return this; } (v)
 * D. public One foo() { return this; } (v)
 * E. public Object foo() { return this; }
 **************************************************************/
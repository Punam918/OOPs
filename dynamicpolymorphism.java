class animal{
    void makesound(){
        System.out.println("Animal sound")
    }
}

class dog extends animal{
    @Override
    void makesound(){
        System.out.println("Dog barks");
    }
}

public class testingdynamicpolymorphism{
    public static void main(String[] args)
    {
        animal myanimal = new dog();
        myanimal.makesound();
    }
}
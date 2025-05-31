class dog{
    // this are attributes
    private String name;
    private int age;
    private String dateAttended;


    //creating constructor same as __init__ in python
    public dog(String name, int age, String dateAttended){
        this.name = name;
        this.age = age;
        this.dateAttended = dateAttended;
    }

    // java method for displaying info
    public void displayinfoofdog(){
        System.out.println("name:" + name+",age:"+ age+",date attended: dateattended");
    }

    public static void main(String[] args){
        dog dog1 = dog("tommy",'2022-09-09')
        dog dog2 = dog("jerry",4,"2087-05-04")
    }

    dog1.displayinfoofdog();
    dog2.displayinfoofdog();
}
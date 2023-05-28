import java.time.LocalDate;

public class Human {
    public int age;
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public int weight;
    public int number;

    public Human get(int i){
        return(this);
    }

    public int getAge() {
        return(this.age);
    }
    public String getFirstName() {
        return(this.firstName);
    }
    public String getLastName() {
        return(this.lastName);
    }
    public LocalDate getBirthDate() {
        return(this.birthDate);
    }
    public int getWeight() {
        return(this.weight);
    }

    public void printInfo(){
        System.out.print(
                this.firstName+' '+
                this.lastName+ ' '+
                this.age+" лет "+
                this.birthDate+ " "+
                this.weight+" кг \n");
    }
    public int getNumber(){
        return this.number;
    }
    public void setNumber(int n){
        this.number=n;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}

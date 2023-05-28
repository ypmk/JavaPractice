public class Second implements Predicate{

    @Override
    public boolean isDegreeOfTwo(int num) {
        while (num != 1 && num % 2 == 0) {
            num /= 2;
            num /= 2;
        }
        while (num != 1 && num % 2 == 0) {
            num /= 2;
        }

        if (num==1){
            return true;
        }
        else{
            return false;
        }


    }
}

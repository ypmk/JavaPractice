import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);

        Human human_1 = new Human();
        human_1.age=15;
        human_1.firstName="Anya";human_1.lastName="Mahonina";
        human_1.weight=48;
        human_1.birthDate= LocalDate.of(2008, 1, 14);

        Human human_2 = new Human();
        human_2.age=16;
        human_2.firstName="Katya";
        human_2.lastName="Severina";
        human_2.weight=49;
        human_2.birthDate= LocalDate.of(2008, 9, 26);

        Human human_3 = new Human();
        human_3.age=57;
        human_3.firstName="Kirill";
        human_3.lastName="Petrov";
        human_3.weight=80;
        human_3.birthDate= LocalDate.of(1965, 5, 30);

        Human human_4 = new Human();
        human_4.age=26;
        human_4.firstName="Den";
        human_4.lastName="Vasylevskiy";
        human_4.weight=60;
        human_1.birthDate= LocalDate.of(1997, 2, 8);

        ArrayList<Human> input = new ArrayList<>();
        input.add(human_1);
        input.add(human_2);
        input.add(human_3);
        input.add(human_4);
        Stream<Human> stream = input.stream();

        for (int i=0;i<input.size();i++){
            input.get(i).setNumber(i);
        }

        System.out.println("Сортировка по имени в обратном порядке:");
        List<String> list_FirstNames = Arrays.asList(
                human_1.firstName,
                human_2.firstName,
                human_3.firstName,
                human_4.firstName);
        List<String> sortedList = list_FirstNames.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(sortedList);
        System.out.println();

        System.out.println("Фильтрация по возрасту, больше чем 20 лет:");
        stream.filter(str1 -> str1.getAge() > 20)
                .sorted(Comparator.comparingInt(Human::getAge))
                .forEach(System.out::println);
        System.out.println();

        Stream<Human> stream_1 = input.stream();
        System.out.println("Выбор первых трех элементов списка:");
        stream_1.filter(str1 -> str1.getNumber()<3)
                .forEach(System.out::println);
        System.out.println();

        Stream<Human> stream_2 = input.stream();
        String s="";
        System.out.println("Конкатенация имен в строку через пробел:");
        stream_2.forEach(x->x.getFirstName());
        System.out.print(s);







        for(int i=0;i<input.size();i++) {
           s+=input.get(i).firstName;
           s+=" ";
        }
        System.out.print(s);


    }


}


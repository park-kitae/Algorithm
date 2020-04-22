package algorithm.study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class streamTest {

    public static void main(String[] args){
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        List<Integer> integers2 = Arrays.asList(5,3,6,2,3,5);

        int sum = integers.stream()
                .reduce(0, (prev, next) -> prev = prev > next ? prev : next);

        System.out.println(sum);


        List<person> personList = new ArrayList<>();
        personList.add(new person("park", 22, Arrays.asList(new address("010", "new york"), new address("020", "seoul"))));
        personList.add(new person("park", 30, Arrays.asList(new address("020", "ulsan"))));
        personList.add(new person("kim", 25, Arrays.asList(new address("030", "busan"))));
        personList.add(new person("un", 45, Arrays.asList(new address("010", "london"), new address("030", "paris"))));

        double averageAge = personList.stream().collect(Collectors.averagingInt(person::getAge));
        System.out.println(averageAge);
        Map<Integer, List<person>> lists = personList.stream().collect(Collectors.groupingBy(p-> (int) Math.floor(p.age / 10) * 10));
        System.out.println(lists);

    }

    public static class person{
        private String name;
        private int age;
        private List<address> addresses;

        public person (String name, int age, List<address> addresses){
            this.name = name;
            this.age = age;
            this.addresses = addresses;
        }

        public int getAge(){
            return this.age;
        }

        public List<address> getAddresses() {
            return addresses;
        }
    }

    public static class address{
        private String phone;
        private String address;

        public address(String phone, String address){
            this.phone = phone;
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }
    }

}

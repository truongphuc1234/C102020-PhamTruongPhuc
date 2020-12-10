package bai12_java_collection_framework.thuc_hanh.ex_3_comparable_comparator;

import java.util.*;

public class SimpsonSorting {
    public static void main(String[] args) {
        List<Simpson> simpsons = new ArrayList<>();
        simpsons.add(new Simpson("Homer"));
        simpsons.add(new Simpson("Marge"));
        simpsons.add(new Simpson("Bart"));
        simpsons.add(new Simpson("Lisa"));

        Collections.sort(simpsons);
        for(Simpson simpson: simpsons){
            System.out.print(simpson+"\t");
        }
        System.out.println();

        Collections.reverse(simpsons);

        for(Simpson simpson: simpsons){
            System.out.print(simpson);
        }
        System.out.println();

        Simpson[] simpsonsArray = {new Simpson("Homer"),new Simpson("Marge"),new Simpson("Bart"),new Simpson("Lisa")};
        Arrays.sort(simpsonsArray);

        for(Simpson simpson: simpsonsArray){
            System.out.print(simpson);
        }
        System.out.println();

        Map<Simpson,String> simpsonTree = new TreeMap<>();
        simpsonTree.put(new Simpson("Moe"),"shotgun");
        simpsonTree.put(new Simpson("Lenny"),"Carl");
        simpsonTree.put(new Simpson("Homer"),"television");
        simpsonTree.put(new Simpson("Barney"),"beer");


        System.out.println(simpsonTree);

        Set<Simpson> simpsonSet = new TreeSet<>();
        simpsonSet.add(new Simpson("Moe"));
        simpsonSet.add(new Simpson("Lenny"));
        simpsonSet.add(new Simpson("Homer"));
        simpsonSet.add(new Simpson("Barney"));

        System.out.println(simpsonSet);

        List<Simpson> characters = new ArrayList<>();

        characters.add(new Simpson("Homer"));
        characters.add(new Simpson("Moe"));

        Collections.sort(characters,(Comparator.<Simpson>
                comparingInt(character1 -> character1.name.length())
                .thenComparingInt(character2 -> character2.name.length())));

        System.out.println(characters);
    }
}

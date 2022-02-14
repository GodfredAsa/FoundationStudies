package com.company.StreamBetter;


import java.util.List;
import java.util.stream.Collectors;


public class Spot {

   public static  List<Miner> miners = List.of(

            new Miner("Fred","Dansoman", List.of(new Jewellery("Gold", 5))),
            new Miner("Hanson","Opeibia", List.of(new Jewellery("Diamond", 6))),
            new Miner("Kwesi","Accra", List.of(new Jewellery("Silver", 3))),
            new Miner("Appiah","Kumasi", List.of(new Jewellery("Stone", 2))),
            new Miner("Kingsford","New town", List.of(new Jewellery("Gravel", 1))),
            new Miner("Gadagoe","Madina", List.of(new Jewellery("Gold", 5))),
            new Miner("Elizabeth","Mamobi", List.of(new Jewellery("Diamond", 6))),
            new Miner("Jackson","Dansoman", List.of(new Jewellery("Gold", 5)))
    );


    public static void main(String[] args) {
      /* List<Miner> goldMiners = */


        miners.stream()
                .filter(miner-> miner.getJewelleries()
                        .stream().anyMatch(jewelleryWorth->jewelleryWorth.getWorth()>5))
                .map(name -> name.getName() + " " + name.getPlace()  + " " + name.getJewelleries())

                .forEach(System.out::println);


        List<Miner> goldMiners = getMinersByMineral("Gold");
        int counter = 1;

        System.out.println("-----------------------------------");
        for(Miner miner: goldMiners){
            System.out.println( counter++  + ". " + miner.getName() + " " + miner.getPlace() );
            System.out.println("-----------------------------------");
        }
    }


    public static List<Miner> getMinersByMineral(String mineral){

      return miners.stream()
                .filter(miner -> miner.getJewelleries()
                        .stream().anyMatch(gold->gold.getItemName().equals(mineral)))
                .collect(Collectors.toList());
    }




}

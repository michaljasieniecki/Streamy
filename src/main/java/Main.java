import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Square> squares = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 5 + random.nextInt(20); i++){
            squares.add(new Square( random.nextDouble()*20));
        }
        //a)
        List<Square> poleObwod = squares.stream()
                .filter(square ->square.getArea() >square.getPerimeter())
                .collect(Collectors.toList());
        System.out.println("a)");
        System.out.println(poleObwod);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //b)
        List<Square> rosObwod= squares.stream()
                .sorted(Comparator.comparingDouble(square -> square.getArea()))
                .collect(Collectors.toList());
        System.out.println("b)");
        System.out.println(rosObwod);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        //c)
        double sredniaFigur = squares.stream()
                .mapToDouble(square -> square.getPerimeter())
                .summaryStatistics().getAverage();
        System.out.println("c)");
        System.out.println(sredniaFigur);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //d)
        double srdPole = squares.stream()
                .mapToDouble(square -> square.getArea())
                .summaryStatistics().getAverage();
        List<Square> SortMal = squares.stream()
                .filter(square -> square.getArea() < srdPole)
                .sorted(Comparator.comparingDouble(Square::getArea)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("d)");
        System.out.println("Srednia powierzchnia:" + srdPole);
        SortMal.stream().forEach(square -> System.out.println(square.getArea()));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        //e)
        double sumaPola = squares.stream()
                .mapToDouble(square -> square.getArea())
                .summaryStatistics().getSum();
        System.out.println("e)");
        System.out.println(sumaPola);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //to map
        Map<Square,Double> map = squares.stream()
                .collect(Collectors.toMap(square -> square, square -> square.getArea()));
        System.out.println("mapa");
        System.out.println(map);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}



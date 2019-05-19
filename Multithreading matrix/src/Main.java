import java.util.*;
import java.util.ArrayList;
import java.lang.String;
import java.util.Random;
import java.lang.Double;



public class Main {
    List<Integer> shape = new ArrayList<Integer>();
    static int ilosc_watkow;
    static ArrayList<Integer> m = new ArrayList();
    static ArrayList<Integer>ran= new ArrayList<Integer>();
    static ArrayList<Integer>ran2 = new ArrayList<Integer>();
    static ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> random1 = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> random2 = new ArrayList<ArrayList<Integer>>();

    static ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

    static public void printWector(ArrayList<Integer>vector){
        for (int i =0;i < vector.size();i++)
        System.out.println(vector.get(i));
    }

    static ArrayList<ArrayList<Integer>> createMatrix(ArrayList<Integer>shape){
        ArrayList mat = new ArrayList();
            for(int j = 0; j < shape.get(1); j++){
                mat.add(0);
            }
        for(int i = 0; i < shape.get(1); i++){
            matrix.add(mat);
        }
        return matrix;
    }

    static public void printMatrix(ArrayList<ArrayList<Integer>> matrix){
        for(int i =0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(0).size(); j++){
                System.out.print(matrix.get(i).get(j)+ ", ");
            }
            System.out.println(" ");
        }
    }

    public static int random_float(int min, int max){
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static ArrayList<Integer> randomVector(int size,int min,int max){
        ArrayList<Integer> vec = new ArrayList<>();
            for(int i =0; i < size ; i++){
                int e = random_float(min,max);
                vec.add(e);
            }
        return vec;
    }

    static ArrayList<ArrayList<Integer>> randomMatrix1(ArrayList<Integer>shape, int min, int max){

        for(int i = 0; i < shape.get(0); i++) {
            int b = shape.get(1);
            ran = randomVector(b, min, max);
            random1.add(ran);
        }
        return random1;
    }

    static ArrayList<ArrayList<Integer>> randomMatrix2(ArrayList<Integer>shape, int min, int max){

        for(int i = 0; i < shape.get(0); i++) {
            int b = shape.get(1);
            ran2 = randomVector(b, min, max);
            random2.add(ran2);
        }
        return random2;
    }



    public static void main(String[] args) throws Exception
    {
        int m, n, p;

        ArrayList<Integer>shape = new ArrayList<Integer>();

        ArrayList<Integer>wspolrzedne1 = new ArrayList<Integer>();
        ArrayList<Integer>wspolrzedne2 = new ArrayList<Integer>();

        System.out.println("Podaj wymiar m: ");
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();

        System.out.println("Podaj wymiar n (wspolny paramatr): ");
        Scanner scanner1 = new Scanner(System.in);
        n = scanner1.nextInt();

        System.out.println("Podaj wymiar p: ");
        Scanner scanner2 = new Scanner(System.in);
        p = scanner2.nextInt();

        ArrayList<Integer>dane = new ArrayList<Integer>();
        dane.add(0,m);
        dane.add(1,p);

        wspolrzedne1.add(0,m);
        wspolrzedne1.add(1,n);
        wspolrzedne2.add(0,n);
        wspolrzedne2.add(1,p);

        C = createMatrix(dane);

        // durkowanie macierzy zerowej
        //printMatrix(C);

        int min_w = 0, maks_w = 0;

        System.out.println("Podaj minimalna wartosc macierzy ");
        Scanner scanner3 = new Scanner(System.in);
        min_w = scanner3.nextInt();

        System.out.println("Podaj maksymalna wartosc macierzy ");
        Scanner scanner4 = new Scanner(System.in);
        maks_w = scanner4.nextInt();

        System.out.println("Ile watkow chcesz utowrzyć? ");
        Scanner scanner5 = new Scanner(System.in);
        ilosc_watkow = scanner5.nextInt();

        random1 = randomMatrix1(wspolrzedne1, min_w,maks_w);
        random2 = randomMatrix2(wspolrzedne2, min_w,maks_w);

        System.out.println("Macierz1:");
        printMatrix(random1);

        System.out.println("Macierz2:");
        printMatrix(random2);


    }
}

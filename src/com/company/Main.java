package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


            public static void main(String[] args) throws IOException {

                String Harry = new String(Files.readAllBytes(Paths.get("C:\\Users\\Flax\\Desktop\\harry.txt")));    //Показуєм шлях до тексту



                String harryCleaned = Harry.replaceAll("[^a-zA-Z0-9 ]", "");                             //Очищаємо Harry від лишніх символів
                String[] harryWords = harryCleaned.split(" ");                                                     //Розділяє рядок по пробілу "space"
                String[] harryLines = Harry.split("\\n");                                                          //Розділяє рядок по \n "Enter"


                //------------------------------------------------------------------------------------------------
                // 1. Знаходимо найдовше слово в harryWords[i]

                String longestWord = "";
                for (int i = 0; i < harryWords.length; i++) {                          //Запускаєм цикл по довжині рядка
                    if ( harryWords[i].length() > longestWord.length()){
                        longestWord = harryWords[i];
                    }
                }
                System.out.println("Найдовше слово - " + longestWord);                //Виводим в консоль найдовше слово



                //-------------------------------------------------------------------------------------------------
                // 2. Підраховуєм кількість слів "Harry" в тексті.

                int counter = 0;                                                    //Пусте значення
                for (int i = 0; i < harryLines.length; i++) {                       //Цикл
                    if (harryLines[i].contains("Harry")) {
                        counter++;
                    }
                }
                System.out.println("Ім'я Harry зустрічається в " + counter +        //Виводим результат
                        " рядках.");

                //---------------------------------------------------------------------------------------------------


                // 3.Знаходимо особливі слова та робимо масив хешів


                String distinktString = "";
                for (int i = 0; i < harryWords.length; i++) {
                    if ( !distinktString.contains(harryWords[i])) {
                        distinktString += harryWords[i] + " ";
                    }
                }
                String[] distinktArray = distinktString.split(" ");
                System.out.println( "Всього слів у тексті - " + harryWords.length);
                System.out.println( "Distinct words - " + distinktArray.length);

                Integer[] hashArray = new Integer[distinktArray.length];
                for (int i = 0; i < distinktArray.length; i++) {
                    hashArray[i] = distinktArray[i].hashCode();

                }

                //--------------------------------------------------------------------------------------------------
                // 4.

                for (int i = 0; i < hashArray.length; i++) {
                    counter = 0;
                    for (int j = i+1; j < hashArray.length; j++) {
                        if ( hashArray[j] != null) {
                            if ( hashArray[i] == hashArray[j] ) {
                                counter ++;
                                hashArray[j] = null;
                            }
                        }
                    }
                    if ( counter != 0){
                        System.out.println( "Хеші перетинаються - " + hashArray[i] +
                                " - " + counter);
                    }
                }
                System.out.println(counter);
    }
}

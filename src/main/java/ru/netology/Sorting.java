package ru.netology;

public class Sorting {

    public static void main(String[] args) {
        //общие исходные данные для всех сортировок
        int[] arr = {5, 33, 142, 4, 3, 3, 40, 1, 5, 18, 7, 25};
        int[] arr2 = {6, 123, 35, 5, 1};

        /*исходные данные для демонстрации слияния с рекурсией, это нужно поместить в метод bubbleSort и передать в него
        один большой массив arr, он будет разбит на несколько и рекурсивным вызовом метода 2 части будут отсортированы
       int[] arr1 = Arrays.copyOfRange(arr,0, arr.length/2);
        int[] arr4 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
         */

        //исходные данные для демонстрации сортировки путём слияния понадобится результирующий массив
        int[] arrRes = new int[arr.length + arr2.length];
        for (int i = 0; i < arrRes.length; i++) {
            arrRes[i] = 0;
        }

        //исходные данные для быстрой сортировки
        int low = 0;
        int high = arr.length - 1;

        //исходные данные для сортировки подсчетом
        int [] counter;

//ВЫЗОВ ФУНКЦИЙ:



/*
        //упорядочиваю "пузырьком" два массива (так же требуется для слияния)
        bubbleSort(arr);
        bubbleSort(arr2);



        //тут выполняю сортировку слиянием
        mergerSort(arr, arr2, arrRes);

 */


/*
        //для быстрой сортировки с пивотированием
        quickSort(arr, low, high);
          */

/*
        //сортировка подсчетом(линейная)
       counter = countingSort(arr);

 */



        //это просто метод вывода в консоль любого массива для наглядности
        output(arr);


    }


    public static void output(int[]arr){
        for (int i = 0; i < arr.length; i++) {
/*
            //вывод для сортировки подсчетом
            if(arr[i]!=0) {
                int x = arr[i];
                while(x!=0) {
                    System.out.print(i + " ");
                   x--;
                }
            }

 */

            System.out.print(arr[i] + " ");
        }
    }




    public static void bubbleSort(int[] arr) {
        //счетчик текущей позиции в массиве (используется для остановки цикла while)
        int iArr = 0;
        while (iArr < arr.length) {
            //первый цикл for мне нужен, чтобы не тратить время на анализ уже отсортированных значений в конце массива
            //я их как бы обрезаю во втором цикле for где вычитаю значение i
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int x = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = x;
                    }
                }
            }
            iArr++;
        }
        iArr=0;
    }






    public static int[] mergerSort(int[] arr, int[] arr2, int[] arrRes) {
        //счетчики текущих позиций в массивах
        int iArr = 0;
        int iArr2 = 0;
        int iArrRes = 0;
        //до тех пор пока оба массива не закончится, цикл будет выполняться
        while (iArr < arr.length || iArr2 < arr2.length) {
            //первые два if на случай, если один из массивов закончился
            if (iArr == arr.length) {
                arrRes[iArrRes] = arr2[iArr2];
               iArr2++;
            }else if (iArr2 == arr2.length){
                    arrRes[iArrRes] = arr[iArr];
                    iArr++;
                    //эти условия, для определения наименьшего значения из 2х массивов, когда их сравниваем поочередно
                } else if (arr[iArr] < arr2[iArr2] || arr[iArr] == arr2[iArr2]) {
                    arrRes[iArrRes] = arr[iArr];
                    iArr++;
                } else {
                    arrRes[iArrRes] = arr2[iArr2];
                    iArr2++;
                }
                iArrRes++;
            }
            return arrRes;
        }







    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }







    public static int[] countingSort(int[]arr){

        int counterSize = maxCounterValue(arr);

        int[] counter = new int [counterSize];

        for(int i=0; i< arr.length; i++){
            counter[arr[i]] = counter[arr[i]]+1;
        }
        return counter;
    }
    public static int maxCounterValue(int[]arr){
        int counterSize=0;

        for(int i=0; i<arr.length; i++){

            if(arr[i+1]==arr[arr.length-1]&&counterSize<arr[i+1]){
                counterSize=arr[i+1];
                return counterSize+1;
            }else if (arr[i+1]==arr[arr.length-1]&&counterSize>=arr[i+1]){
                return counterSize+1;
            }

            if (counterSize<arr[i]){
                counterSize=arr[i];
            }
        }
        return counterSize+1;
    }
    }




package Lesson_6_homework;

public class MainHome6 {
    public MainHome6() {
    }

    // Логгирование сделал в пакете _NetworkChat.server
    // Класс Server - добавил статический logger
    // В ClientHandler в определенных местах добавил метод info.

    public static void main(String[] args) {

        // 2. Мссив чисел после последней четверки...

        MainHome6 main = new MainHome6();

        //int[] testRes = main.AfterLastFour(new int[]{1,2,3,5,6,4,5,6});

        // 3. Состав массива из 1,4.

    }

    public int[] AfterLastFour(int[] mas){
        int[] resTemp = new int[mas.length];
        int counter = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[mas.length - i-1] == 4) {
                break;
            }
            resTemp[i] = mas[mas.length - i-1];
            counter++;
        }

        if (counter == 0) return null;

        int[] res = new int[counter];

        for (int i = 0; i < counter; i++) {
            res[res.length-i-1] = resTemp[i];
        }

        return res;

    }

    public boolean CheckOneFour(int[] mas){
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]==1 || mas[i]==4){
                return true;
            }
        }
        return false;
    }

}

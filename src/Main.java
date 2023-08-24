

public class Main {
        public static void main(String[] args) {
                java.util.Scanner in = new java.util.Scanner(System.in);
                String input = in.nextLine();

                calc(input);

        }

public static String calc(String input) {


            String output="";

        // Задаем массив арабских чисел для вычислений arab[] от 1 до 10
        int[] arab = new int[10];
        for (int i = 0; i < 10; ++i)
            arab[i]=i+1;

        // Задаем массив римских цифр rim[] от I до X
        String[] rim = new String[10];
        rim[0]="I";
        rim[1]="II";
        rim[2]="III";
        rim[3]="IV";
        rim[4]="V";
        rim[5]="VI";
        rim[6]="VII";
        rim[7]="VIII";
        rim[8]="IX";
        rim[9]="X";

        // Задаем массив арабских цифр от 1 до 10 (строки) arabstr[]
        String[] arabstr = new String[10];
        arabstr[0]="1";
        arabstr[1]="2";
        arabstr[2]="3";
        arabstr[3]="4";
        arabstr[4]="5";
        arabstr[5]="6";
        arabstr[6]="7";
        arabstr[7]="8";
        arabstr[8]="9";
        arabstr[9]="10";

        //  Ввод примера с клавиатуры в переменную input



        //  Определяем наличие одного из символов операции (+ - . *)
        //  Потом определяем, где пробелы в массиве переменной input

        int probel1 = 10;
        int probel2 = 10;
        String symbolcheck = " +-*/";
        int m = 0;
        String op1user = "";
        String op2user = "";
        String symboluser = "";

        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) == symbolcheck.charAt(1)) || (input.charAt(i) == symbolcheck.charAt(2)) || (input.charAt(i) == symbolcheck.charAt(3)) || (input.charAt(i) == symbolcheck.charAt(4))) m++;
        }

        if (m > 1) output = "throws Exception // т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+,-,/,*)";

        if (m != 0) {
                for (int i = 0; i < input.length(); i++) {
                        if (input.charAt(i) == symbolcheck.charAt(0) && probel1 == 10) probel1 = i;
                        if (input.charAt(i) == symbolcheck.charAt(0) && probel1 < 10) probel2 = i;

                }

        //  проверка пробелов
        //        System.out.println("Позиции пробелов в примере (начиная с нуля): " + probel1 + " " + probel2);

                //  Записываем аргументы и знак действия в переменные op1user (0,1), symboluser(3,4), op2user (5)
                op1user = input.substring(0, probel1);
                symboluser = input.substring(probel1 + 1, probel1 + 2);
                op2user = input.substring(probel2 + 1);
        }

        else output = "throws Exception // т.к. строка не является не является математической операцией";

        // Вычисляем с арабскими цифрами

        int res=20;
        int op1=30;
        //  Рекомендуется сделать исключение "ФОРМАТ ввода данных" в ссответствии с Требованием 3
        //  См. строку 118 (снять знаки комментария, при этом заработают переменные
        //  op1format и op2format)
        String op1format="";
        int op2=40;
        String op2format="";
        String checkarab1 = "0";
        String checkrim1 = "0";
        String checkarab2 = "0";
        String checkrim2 = "0";
        String checkarabrim = "0";

        for (int i = 0; i < 10; i++) {
            if (op1user.equals(arabstr[i])) op1 = arab[i];
            if (op1user.equals(rim[i])) op1 = arab[i];
            if (op2user.equals(arabstr[i])) op2 = arab[i];
            if (op2user.equals(rim[i])) op2 = arab[i];

        }
        for (int i = 0; i < 10; i++) {
            if (op1user.equals(arabstr[i])) checkarab1 = "первое арабское";
            if (op1user.equals(rim[i])) checkrim1 = "первое римское";
            if (op2user.equals(arabstr[i])) checkarab2 = "второе арабское";
            if (op2user.equals(rim[i])) checkrim2 = "второе римское";
            else if (op1 == 30) {
                op1format="не от 1 до 10"; op1 = 1;
            }
            else if (op2 == 40) {
                op2format="не от 1 до 10"; op2 = 1;
            }

        }

        if (checkarab1.equals("первое арабское") && (checkarab2.equals("второе арабское"))) checkarabrim="оба арабские";
        if (checkrim1.equals("первое римское") && (checkrim2.equals("второе римское"))) checkarabrim="оба римские";
        if (checkarab1.equals("первое арабское") && (checkrim2.equals("второе римское"))) checkarabrim="первое арабское, второе римское";
        if (checkrim1.equals("первое римское") && (checkarab2.equals("второе арабское"))) checkarabrim="первое римское, второе арабское";

        if (checkarabrim.equals("оба римские") && (op1 < op2) && symboluser.equals("-"))  output = "throws Exception // т.к. в римской системе нет отрицательных чисел";
        else if (checkarabrim.equals("оба римские") && (op1 < op2) && symboluser.equals("/")) output = "throws Exception // т.к. в римской системе нет числа ноль";
        else if (checkarabrim.equals("оба римские") && (op1 == op2) && symboluser.equals("-")) output = "throws Exception // т.к. в римской системе нет числа ноль";

        else if (checkarabrim.equals("первое римское, второе арабское")) output = "throws Exception // т.к. используются одновременно разные системы счисления";
        else if (checkarabrim.equals("первое арабское, второе римское")) output = "throws Exception // т.к. используются одновременно разные системы счисления";
        else if (op1user.isEmpty() && op2user.isEmpty()) output = output;

        else if (op1format.equals("не от 1 до 10") || op2format.equals("не от 1 до 10")) output = "throws Exception // т.к. формат как минимум одного из чисел не находится в диапазоне от 1 до 10";

        if (output.isEmpty()) {
                    if (symboluser.equals("+")) res = op1 + op2;
                    if (symboluser.equals("-")) res = op1 - op2;
                    if (symboluser.equals("*")) res = op1 * op2;
                    if (symboluser.equals("/")) res = op1 / op2;
        }

        // Расчет ответа для римских цифр
        // Задаем массив римских цифр rimdec[] - десятки
        String[] rimdec = new String[11];
        rimdec[0]="";
        rimdec[1]="X";
        rimdec[2]="XX";
        rimdec[3]="XXX";
        rimdec[4]="XL";
        rimdec[5]="L";
        rimdec[6]="LX";
        rimdec[7]="LXX";
        rimdec[8]="LXXX";
        rimdec[9]="XC";
        rimdec[10]="C";

        // Задаем массив римских цифр rimnum[] - единицы
        String[] rimnum = new String[11];
        rimnum[0]="";
        rimnum[1]="I";
        rimnum[2]="II";
        rimnum[3]="III";
        rimnum[4]="IV";
        rimnum[5]="V";
        rimnum[6]="VI";
        rimnum[7]="VII";
        rimnum[8]="VIII";
        rimnum[9]="IX";
        rimnum[10]="X";


        // Задаем массив римских цифр от 1 до 100 rimall[]
        String[] rimall = new String[101];
        int k=0;
        for (int j = 0; j < 10; ++j)
            for (int i = 0; i < 10; ++i){
                rimall[k]=rimdec[j]+rimnum[i]; ++k;
            }
        rimall[k]=rimdec[10]="C";


        // Расчет ответа для арабских цифр
        // Задаем массив римских цифр arabdec[] - десятки
        String[] arabdec = new String[11];
        arabdec[0]="";
        arabdec[1]="1";
        arabdec[2]="2";
        arabdec[3]="3";
        arabdec[4]="4";
        arabdec[5]="5";
        arabdec[6]="6";
        arabdec[7]="7";
        arabdec[8]="8";
        arabdec[9]="9";
        arabdec[10]="100";

        // Задаем массив арабских цифр arabnum[] - единицы
        String[] arabnum = new String[11];
        arabnum[0]="0";
        arabnum[1]="1";
        arabnum[2]="2";
        arabnum[3]="3";
        arabnum[4]="4";
        arabnum[5]="5";
        arabnum[6]="6";
        arabnum[7]="7";
        arabnum[8]="8";
        arabnum[9]="9";
        arabnum[10]="10";


        // Задаем массив арабских цифр от 1 до 100 araball[]
        String[] araball = new String[101];
        int p = 0;
        for (int j = 0; j < 10; ++j)
            for (int i = 0; i < 10; ++i){
                araball[p] = arabdec[j] + arabnum[i]; ++p;
            }
        araball[p] = arabdec[10]="C";



        //   Вывод данных в соответствии с требованиями
        if (output.isEmpty())
                if (checkarabrim.equals("оба арабские") && (op1 < op2) && (symboluser.equals("-"))) {
                        res = res * (-1);
                        output = ("-" + araball[res]);
                } else if (checkarabrim.equals("оба арабские")) output = (araball[res]);

        else if (checkarabrim.equals("оба римские")) output = (rimall[res]);
        else output = output;

        System.out.println(output);
        return input;
}




}


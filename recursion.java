class Main{

    // 最小値と最大値の間のランダムな数値を取得する1つのタスク
    public static int randomInteger(int min, int max){
        // ランダムな整数を取得します。
        // minとmaxの間のランダム数の公式は、ran * (max - min + 1) + min
        // ranは、0 < x < 1を指します。
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    // 文字の文字コードが奇数か偶数かチェックする1つのタスク
    public static boolean isCharCodeEven(char character ){
        boolean isEven = false;
        // Javaではchar型に演算子を使うと、文字コードに変換されます。
        // char型をint型へ型変換を行うことで、文字コードを取得できます。
        System.out.println((int)character);
        if(character % 2 == 0){
            isEven = true;
        }
        return isEven;
    }

    // 文字のインデックスを把握するための文字列を返す1つのタスク
    public static String chosenCharacter(int index, String string){
        return "The char [" + string.charAt(index) + "] at index " + index;
    }

    // もっとシンプルで簡潔にまとめることができます
    public static String randomCharEvenOrOdd(String string1){
        int randomIndex = randomInteger(0, string1.length()-1);
        String message = chosenCharacter(randomIndex,string1);
        return isCharCodeEven(string1.charAt(randomIndex)) ? message + " is Even" : message + " is Odd";
    }

    public static void main(String[] args){
        System.out.println(isRandomCharVowel("Don't tell me lies."));
        System.out.println(isRandomEncodeEven("Don't tell me lies.","Don't tell me lies."));
    }

    // 例題1
    // 小文字で構成される文字列を1つ受け取り、文字列内のランダムな文字が母音ならtrue、子音ならfalseを返す、isRandomCharVowelという関数を作成してください。
    public static boolean isRandomCharVowel(String n){
        int randomIndex = randomInteger(0, n.length()-1);
        char a = n.charAt(randomIndex);
        if(a == 'a' || a == 'b' || a == 'c' || a == 'e' || a == 'o') return true;
        return false;
    }


    // 例題2
    // 2つの文字列が与えられるので、文字列のランダムな文字の文字コードの合計が偶数ならTrue、奇数ならFalseを返す、isRandomEncodeEvenという関数を作成してください。
    public static boolean isRandomEncodeEven(String n,String m){
        int randomIndex = randomInteger(0, n.length()-1);
        int randomIndex2 = randomInteger(0, n.length()-1);
        int a = (int)n.charAt(randomIndex);
        int b = (int)m.charAt(randomIndex);

        if(a + b % 2 == 0)return true;
        return false;

    }
}

// X高校の生徒であるStevenは、友達と一緒にカラオケへ遊びに出かけました。カラオケでは以下の条件によって、値段が変更になります。

// - 明日学校があるかに応じて、値段が変更になります。翌日が祝日または土日の場合、値段が4倍になります。
// - Stevenのクレジットカードの下四桁が閏年の場合、値段が半額になります。閏年の条件は以下の通りです。①4で割り切れる ②100で割り切れる場合は、閏年にしない ③例外として 400 で割り切れる場合は、閏年とする
// - カラオケでは、3人以下では1人8ドル、4人以上では1人6ドル、10人以上では1人5ドルになります。

// では、明日の曜日 day、祝日かどうかをあらわすブーリアン値 isHoliday、クレジットカードの下四桁 lastDigits、友達の人数 num が与えられるので、カラオケで請求される金額を返す、getKaraokeFee という関数を作成してください。

class Main{

    public static void main(String[] args){

        // 120
        System.out.println(getKaraokeFee("Sunday", true, 1900, 5));
        // 120
        System.out.println(getKaraokeFee("Sunday", true, 2000, 12));
        // 64
        System.out.println(getKaraokeFee("Saturday", false, 1900, 2));
        // 48
        System.out.println(getKaraokeFee("Saturday", false, 2000, 4));
        // 24
        System.out.println(getKaraokeFee("Monday", false, 2002, 3));
        // 200
        System.out.println(getKaraokeFee("Monday", true, 2024, 20));

    }

    public static int getKaraokeFee(String day,boolean holiday,int year,int pepoleNumber){
        boolean a = nextHoliday(day,holiday);

        boolean b = leapYear(year);

        int c = pepoleCount(pepoleNumber);

        if(a) c *= 4 ;
        if(b) c /= 2;

        return c;

    }

    // - 明日学校があるかに応じて、値段が変更になります。翌日が祝日または土日の場合、値段が4倍になります。
    public static boolean nextHoliday(String day,boolean holiday){
        return day == "Sunday" || day == "Saturday" || holiday ;
    }

    // - Stevenのクレジットカードの下四桁が閏年の場合、値段が半額になります。閏年の条件は以下の通りです。
    //  ①4で割り切れる ②100で割り切れる場合は、閏年にしない ③例外として 400 で割り切れる場合は、閏年とする
    public static boolean leapYear(int year){
            if (year % 400 == 0) return true;
            else if (year % 100 == 0) return false;
            else if (year % 4 == 0) return true;
            return false;
    }

    // - カラオケでは、3人以下では1人8ドル、4人以上では1人6ドル、10人以上では1人5ドルになります。
    public static int pepoleCount(int people){
        int perPerson;
        
        if (people <= 3) perPerson = 8;
        else if (people < 10) perPerson = 6;
        else perPerson = 5;

        return perPerson * people;
    }

}


class Main{

    public static int wholeNumberAddition(int x, int y){
        // yがゼロになった時、追加する1がないので、xを返します。
        if(y <= 0){
            return x;
        }
        return wholeNumberAddition(x+1,y-1);
    }

    public static void main(String[] args){
        System.out.println(wholeNumberAddition(5,4));   // 9
        System.out.println(wholeNumberAddition(10,23)); // 33
        System.out.println(wholeNumberSubstraction(5,4));   // 9
        System.out.println(wholeNumberSubstraction(23,10)); // 33
    }

    // 例題
    // 同じ要領で引き算を実装してみましょう。
    // 関数名: wholeNumberSubstraction

    public static int wholeNumberSubstraction(int x ,int y){
        if(y == 0){
            return x;
        }
        return wholeNumberSubstraction(x-1,y-1);
    }

    // wholeNumberSubstraction(5,4) → 1
    // wholeNumberSubstraction(23,10) → 13

}


class Main{

    public static void main(String[] args){
        // summationOfc(2, 5)-->10
        System.out.println(summationOfc(2,5));
        // summationOfc(3, 5)-->15
    }

     public static int g(int i){
        return i;
    }

    public static int summationOfc(int x,int y){
        if(y <= 0){
            return 0;
        }
        return g(x) + summationOfc(x, y-1 );
    }

}


class Main{

    public static void main(String[] args){
        System.out.println(lengthString("hello"));
        System.out.println(mergeString("abc","def"));
    }

    // 例題1
    // 文字列が与えられるので、再帰を用いて、文字列の長さをカウントする、lengthStringという関数を作成してください。

    // "hello" -> 5
    // "helloworld" -> 10

    // abcde
    // 1 + bcde
    // 1 + 1 + cde
    // 1 + 1 + 1 + de
    // 1 + 1 + 1 + 1 + e
    // 1 + 1 + 1 + 1 + 1 + 0
    // 5
    // のような処理を考えてみましょう。

    public static int lengthString(String n){
        if(n.length() <= 0){
            return 0;
        }
        return 1 + lengthString(n.substring(1));
    }

    // 例題2
    // 同じサイズの文字列s1、s2が与えられるので、それぞれの文字を1->2の順番で交互に組み合わせる、mergeStringという関数を再帰を使って作成してください。

    // (abc, def)
    // ad + (bc, ef)
    // ad + be + (c,f)
    // ad + be + cf + ( , )
    // adbecf
    // のような処理を考えてみましょう。

    // "abc","def" → adbecf
    // "hello","world" → hweolrllod

    public static String mergeString(String n ,String m){
        if(n.length() <= 0 || m.length() <= 0){
            return "";
        }
        return n.charAt(0) + "" + m.charAt(0) + mergeString(n.substring(1), m.substring(1) );
    }

    //  if (string1.length() <= 0 || string2.length() <= 0) {
    //         return "";
    //     }
    //     // ""を混ぜることでchar型をString型にする
    //     return string1.charAt(0) + "" + string2.charAt(0) + mergeString(string1.substring(1),string2.substring(1));

}

// パスカルの三角形
// easy
// 図のように三角数の数列があります。天才 Pascal は小学生の時にこの並びを見て規則的な発見をしました。
// 整数 x が与えられるので、x 番目の三角形に含まれるドットの数を返す、numberOfDots という関数を再帰を使って作成してください。

class Solution{
    public static int numberOfDots(int x){
        //ここから書きましょう
        double Exponentiation = numberOfExponentiation(x);

        Exponentiation += 1;

        return (int)Math.floor(x * Exponentiation);

    }

    public static double numberOfExponentiation(int x){
        if(x <= 1){
            return 0;
        } 
        return 0.5 + numberOfExponentiation(x - 1);
    }

     public static int numberOfDots(int x){
        // xが1番目になったときに再帰終了
        if (x <= 1) return 1;
        // x番目で加わるドット数 + x-1番目までのドット数
        return x + numberOfDots(x-1);
    }
}

// 正方形の合計面積
// easy
// 1 辺 1 の正方形をスタートとして、1 辺の長さ、正方形の個数を列ごとに増加させていきます。
// i 列の中には 1 辺 i の正方形が i 個あり、i 列に含まれる正方形の合計面積を計測します。
// 自然数 x が与えられるので、1 列から x 列までに含まれる全ての正方形の面積の合計値を返す、
// totalSquareArea という関数を再帰によって作成してください。総和や 3 乗を計算するために必要な他の関数は用いて構いません。

class Solution{
    public static int totalSquareArea(int x){
        //ここから書きましょう
        if(x <= 0){
            return 0;
        }
        return (x * x) * x + totalSquareArea(x -1);
    }
}


class Main {

    // 例題1
    // 文字列s1とs2が与えられるので、共通の接頭辞を返す、commonPrefixという関数を作成
    public static String commonPrefix(String s1, String s2) {
        return commonPrefixHelper(s1, s2, "", 0);
    }

    public static String commonPrefixHelper(String s1, String s2, String total, int index) {
        if (index >= s1.length() || index >= s2.length() || s1.charAt(index) != s2.charAt(index)) {
            return total;
        }

        return commonPrefixHelper(s1,s2,total + s1.charAt(index),index + 1);
    }


    // 例題2 【チャレンジ問題】
    // 整数が与えられるので、負の数になるまで5を引いていき、その後5を足していく、reduceByFiveという関数を出力してください。関数でそれぞれの値を出力

    // 数値が減少していき、元の数値と等しくなる時がベースケースとなり、数値を比較する必要があるので、与えられた数値とは異なるパラメータcurr(current numberの略)を追加します。
    // また負の数に到達した後に、今までとは異なる処理を"継続的に"行う必要があるため、flagを使ってブーリアン値で状況を追跡します。(currが0以上になったとしても、今までとは異なる処理を行う必要があるため。)

    public static String reduceByFive(int number) {
        return reduceByFiveHelper(number, number, false);
    }

    public static String reduceByFiveHelper(int number, int curr, boolean flag) {
        if (number == curr && flag) {
            System.out.println(curr);
            return "";
        }

        if (curr < 0 || flag) {
            System.out.println(curr);
            return reduceByFiveHelper(number, curr + 5, true);
        }
        
        System.out.println(curr);
        return reduceByFiveHelper(number, curr - 5, flag);
    }


    public static void main(String[] args){

        // 例題1
        // "abc"
        System.out.println(commonPrefix("abcdefg","abcxyz"));
        // "auto"
        System.out.println(commonPrefix("autopilot","autobiography"));
        // "a"
        System.out.println(commonPrefix("aaa","a"));


        // 例題2
        // 16,11,6,1,-4,1,6,11,16
        reduceByFive(16);

        // 9,4,-1,4,9
        reduceByFive(9);

        // 5,0,-5,0,5
        reduceByFive(5);
    }
}

// 正方形の合計枚数
// easy
// Thomas は図画工作で色紙を使って飛行機を作成しています。
// 色紙にはさまざまなサイズが用意されており、選択することができます。
// 今、Thomas は長方形の色紙からできるだけ大きく、かつ同じ大きさの正方形を何枚も切り取ることを計画しています。
// 長方形の大きさとして、縦 x、横 yが与えられるので、正方形の合計枚数を返す、countSquare という関数を作成してください。

class Solution{
    public static int countSquare(int x,int y){
        //ここから書きましょう
        return (x * y) / countSquareHelper(x,y);
    }

    public static int countSquareHelper(int x ,int y){
        if(y == 0){
            return x * x;
        }
        return countSquareHelper(y,x % y );
    }
}

// 正方形の合計枚数
// easy
// Thomas は図画工作で色紙を使って飛行機を作成しています。
// 色紙にはさまざまなサイズが用意されており、選択することができます。
// 今、Thomas は長方形の色紙からできるだけ大きく、かつ同じ大きさの正方形を何枚も切り取ることを計画しています。
// 長方形の大きさとして、縦 x、横 yが与えられるので、正方形の合計枚数を返す、countSquare という関数を作成してください。

class Solution{
    public static int countSquare(int x,int y){
        //ここから書きましょう
        return (x * y) / countSquareHelper(x,y);
    }

    public static int countSquareHelper(int x ,int y){
        if(y == 0){
            return x * x;
        }
        return countSquareHelper(y,x % y );
    }
}


class Main {

    // 例題 【チャレンジ問題】
    // 今n段の階段があり、この階段では1ステップで1段、および2段しか登ることができません。
    // 階段の頂上まで到達するまでのステップが何通りあるか数えるnumberOfWaysという関数を作成してください。

    // 例えば、n=3の時、頂上に到達するには、1+1+1、1+2、2+1の3通りが存在します。
    // n=4の時、1+1+1+1、1+2+1、1+1+2、2+1+1、2+2の5通りが存在します。

    public static void main(String[] args) {

        // 5 → 8
        System.out.println(numberOfWays(5));
        // 10 → 89
        // 20 → 10946


    }
    
    
    public static int numberOfWays(int n){
        if(n == 1)return 1;
        if(n == 2)return 2;

        return numberOfWays(n - 1) + numberOfWays(n - 2);

    }


}

// 3 の累乗 n が与えられるので、整数 n を 3 で除算できる回数を返す、divideBy3Count という関数を作成してください。
class Solution{
    public static int divideBy3Count(int n){
        //ここから書きましょう
        return divideBy3CountHelper(n,0) ;
    }

    public static int divideBy3CountHelper(int n ,int count){
        if(n/3 < 1)return count;

        return divideBy3CountHelper(n / 3, count + 1);
    }
}

// 約数
// easy
// 天才小学生の Julia ちゃんは学校で出された約数を求める問題に対して 1 問 1 問素因数分解するのが面倒に感じたため、独自でプログラムを開発することにしました。
// ある数値 number が与えられるので、number の約数を小さい順に返す divisor という関数を再帰を使って定義してください。
class Solution{
    public static String divisor(int number){
        //ここから書きましょう
        return divisorHelper(number,1);
    }

    public static String divisorHelper(int n, int m){
        if(m == n)return String.valueOf(m);
        if(n % m == 0){
            return String.valueOf(m) + "-" + divisorHelper(n  ,m + 1);
        }
        return divisorHelper(n , m + 1);
    }
}





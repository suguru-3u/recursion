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


// 投資の計算
// easy
// Kathy は現在価格 goalMoney ドルの土地の購入するために、年利 interest（0 < interest < 100）%の金融商品に capitalMoney ドル投資しようと計画しています。
// goalMoney, interest, capitalMoney が与えられるので、何年後に土地の購入ができるかを返す、howLongToReachFundGoal という関数を再帰によって作成してください。
// なお、毎年得られた利益は同商品に再投資するとし、土地の価格は経過する年数が偶数（0 を含む）の時は 2%、奇数の時は 3% 上昇します。
// また、人の寿命は 80 歳未満と仮定し、80 年以上かかる時は 80 としてください

class Solution{
    public static int howLongToReachFundGoal(int capitalMoney,int goalMoney,int interest){
        //ここから書きましょう
        return howLongToReachFundGoalHelper(capitalMoney,goalMoney,interest,0);
    }

    public static int howLongToReachFundGoalHelper(
        double capitalMoney,double goalMoney,double interest,int age){

            if(goalMoney < capitalMoney || age == 80)return age;
            
            if(age % 2 == 0)goalMoney *= 1.02;
            else goalMoney *= 1.03;
            
            capitalMoney *= interest / 100 + 1;

            return howLongToReachFundGoalHelper(capitalMoney,goalMoney,interest,age + 1);

    }
}

class Main{

    // 自然数digitsが与えられるので、桁数を分解して足し合わせる、splitAndAddという関数を末尾再帰を使って作成

    public static int splitAndAdd(int digits){
        return splitAndAddHelper(digits, 0);
    }

    public static int splitAndAddHelper(int digits, int total) {
        if (digits < 10) return digits + total;
        return splitAndAddHelper(digits / 10, total + digits % 10);
    }

    public static void main(String[] args){

        // 10
        System.out.println(splitAndAdd(19));

        // 23
        System.out.println(splitAndAdd(23387));

        // 23
        System.out.println(splitAndAdd(546125));

    }
}

// フィボナッチ数列
// easy
// Jack は魔法使いからもらった豆を裏庭に植えて昼寝をしました。昼寝から目覚めて裏庭を確認するとその豆は巨木へと成長し、
// 雲の上にある巨人の城にたどりつくまでの大きさになっていました。豆を観察すると、以下の条件で 1 秒ずつ成長することがわかりました。

// f(0) = 0

// 　
// f(1) = 1

// 　
// f(n) = f(n-1) + f(n-2) (n ≥ 2)

// 整数 n が与えられるので、n 秒後の木の高さを求める、fibonacci という関数を作成してください。

class Solution{
    public static int fibonacci(int n){
        //ここから書きましょう
        return fibonacciHelper(0,1,n);
    }

    public static int fibonacciHelper(int n,int m ,int count){
        if(count == 0)return n;
        return fibonacciHelper(m, n + m , count -1);
    }
}

// 数字の分割
// medium
// 自然数 digits（0 < digits < 1015）が与えられるので、数字を 1 桁ずつ分解して、それぞれの値を合計し、
// その値が 1 桁になるまで同じ作業を繰り返した時、それぞれの合計値を足し合わせて得られる値を返す、recursiveDigitsAdded という関数を再帰を使って作成してください。
// 例えば、45622943 の場合、1 桁ずつ分解することによって、4 + 5 + 6 + 2 + 2 + 9 + 4 + 3 = 35 となりますが、値が 1 桁ではないので、
// もう一度 35 = 3 + 5 = 8 のように分解します。最後にそれぞれ足し合わせて 8 + 35 = 43 となります。
// 99999999999884 の場合は、9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 8 + 8 + 4 = 119 となり、その後 1 + 1 + 9 = 11 となるので、119 + 11 + 2 = 132 となります。

class Solution{
    public static int recursiveDigitsAdded(long digits){
        //ここから書きましょう
        return recursiveDigitsAddedHelper(digits,0,0);
    }

    public static int recursiveDigitsAddedHelper(long digits,long total,long totalSeconnd){

        if(digits < 10){
            total += digits;
            if(total < 10)return (int)(total + totalSeconnd);
            return recursiveDigitsAddedHelper(total,0,totalSeconnd + total);
        }
        return recursiveDigitsAddedHelper(digits / 10,total + digits % 10,totalSeconnd);

    }
}


// グローバルスコープでMainというクラスを定義します。
class Main{
    public static int x = 34;

    public static void main(String[] args){
        //クラスのためのスコープも作成されます。

        // xを出力します。
        // ここでは、xは定義されていないので、
        // 親のスコープが検索されます。
        System.out.println(x); //34

        // 現在のローカルスコープでxを宣言します。
        int x = 56;

        // xを検索します。
        // 最初に検索されるのはローカルスコープです。
        // したがって56が出力されます。
        System.out.println(x);
    }

}

// グローバルスコープでAというクラスを定義します。
class A{
    public static int x = 3;
    public static int y = 10;

    public static int multiply(int x){
        // yを検索します。
        // yはローカルスコープで見つからず、
        // y = 10として親スコープツリーで見つかりました。
        return x * y;
    }

    //Aの中にまたBというクラスを定義します。
    static class B{
        public static int x = 15;

        public static int multiply(int x){
            // yを検索します。
            // yはローカルスコープで見つからず、
            // y = 10として親スコープツリーで見つかりました。
            return x * y;
        }
    }
}

class Main{

    public static void main(String[] args){
        int x = 33;
        System.out.println(x); // 33

        System.out.println(A.x); // 3

        System.out.println(A.multiply(5)); // 50

        System.out.println(A.B.x); //15

        System.out.println(A.B.multiply(2)); // 20
    }
}


class Main{

    public static String monsterAttackSwitchMenu(String monster){
        int attack = 1000;
        String message = "'s attack is:";
        // モンスターの名前を入力として受け取って、ケースで比較してみましょう。
        switch(monster) {
            case "Cyclops":
                attack *= 1.8;
                message = "Cyclops" + message + attack;
                break;
            case "Ogre":
                attack *= 2.5;
                message = "Ogre" + message + attack;
                break;
            case "Zombie":
                attack *= 1.2;
                message = "Zombie" + message + attack;
                break;
            default :
                // これが最後のステートメントなので、ここにbreak文をつけてもつけなくても問題ありません。
                message = "Monster does not exist.";
        }

        return message;
    }

    public static void main(String[] args){
        System.out.println(monsterAttackSwitchMenu("Cyclops"));
        System.out.println(monsterAttackSwitchMenu("Ogre"));
        System.out.println(monsterAttackSwitchMenu("Zombie"));
        System.out.println(monsterAttackSwitchMenu("Ghost"));
        System.out.println(redirectionUrl("English"));
        System.out.println(redirectionUrl("Japanese"));
        System.out.println(redirectionUrl("Spanish"));
        System.out.println(redirectionUrl("a"));
    }

// / 例題
// 選択された言語によって、www.example.orgのサブディレクトリにリダイレクトする、redirectionUrlという関数を作成してください。

// English -> www.example.org/en
// Japanese -> www.example.org/ja
// Spanish -> www.example.org/es
// Russian -> www.example.org/ru
// それ以外の場合 -> www.example.org

    public static String redirectionUrl(String lungech){
        String url = "www.example.org/";

        switch(lungech){
            case "English":
                url += "en";
                break;
            case "Japanese":
                url += "ja";
                break; 
            case "Spanish":
                url += "es";
                break; 
            case "Russian":
                url += "ru";
                break; 
            default:
                url = "www.example.org";
                break; 
        }

        return url;
    }
}


// 例題1
// アルファベットが与えられるので、文字コードが奇数の時にTrue、偶数の時にFalseを返す、isEncodeOddという関数を作成してください。

// "a" -> True
// "k" -> True
// "p" -> False
// "z" -> False


// 例題2
// ビットが与えられるので、0と1を反転するoneComplementという関数を再帰を使って作成してください。


// "0101010" -> "1010101"
// "0000" -> "1111"
// "111111" -> "000000"
// "1011110" -> "0100001"





class Main{

    public static String isEven(int n){
        return (n % 2 == 0) ? "The number " + n + " is even" : "The number " + n + " is odd";
    }

    public static void main(String[] args){
        System.out.println(isEven(43));
        System.out.println(isEven(44));
        System.out.println(isEven(1023));
        System.out.println(isEven(9992));
        System.out.println(isEncodeOdd("a"));
        System.out.println(isEncodeOdd("k"));
        System.out.println(oneComplement("1010101"));
        System.out.println(oneComplement("1000"));
    }

    public static boolean isEncodeOdd(String n){
        return (Character.codePointAt(n ,0) % 2 == 1) ? true : false ;
    }

    public static String oneComplement(String m){
        return oneComplementHelper(m, "", 0);
    }

    public static String oneComplementHelper(String n ,String m,int z){
        if(n.length() == z)return m;

        m += n.charAt(z) == '1' ? '0' : '1' ;

        return oneComplementHelper(n,m,z + 1);

    }
}

// / 例題
// 自然数nが与えられるので、1からnまで文字列として出力するprintFizzbuzzという関数を作成してください。
// ただし、3の倍数の時にはfizz、5の倍数の時にはbuzz、15の倍数の時にはfizzbuzzと出力してください。


class Main{

    public static void countUpToN(int n){
        for(int i = 0; i < n; i++){
            System.out.println(i);
        }
    }

    public static void printAllCharacters(String str){
        for(int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
        }
    }

    public static void main(String[] args){
        countUpToN(15);
        printAllCharacters("Hello World!!");
        printFizzbuzz(15);
    }

    public static void printFizzbuzz(int n){
        for(int i = 1; i < n ; i++){
            if(i % 5 == 0 && i % 3 == 0 ){
                System.out.println("fizzbuzz");
            }else if(i % 5 == 0){
                System.out.println("buzz");
            }else if(i % 3 == 0){
                System.out.println("fizz");
            }else{
                System.out.println(i);
            }
        }
    }
}

// あるクラスの生徒たちが飼っているペットの情報が文字列 s で与えられます。
// si が 0 の時、i 番目の生徒はペットを飼っていないことを、1 のとき、i 番目の生徒は犬を飼っていることを、2 のとき、
// i 番目の生徒は猫を飼っていることを表します。
// さて、このような文字列 s が与えられたときに、このクラスでペットを飼っている人の人数を返す、countPetOwner という関数を定義してください。

class Main {

    // countPetOwner("1112002102")  7
    // countPetOwner("1020202")  4
    // countPetOwner("122211220")  8


    public static void main(String[] args){
        System.out.println(countPetOwner("122211220"));
    }

    public static int countPetOwner(String s){

        int count = 0;
        for(int i = 0; i < s.length() ; i ++){
            if(s.charAt(i) == '1' || s.charAt(i) == '2'){
                count += 1;
            }
        }
        return count;
    }
}

// 1 と同じ設定で、そのクラスに犬を飼っている人と、猫を飼っている人、どちらが多いか求めてください。犬を飼っている人が多い場合は
//  "dog"、猫を飼っている人の方が多い場合は "cat"、同じ場合は、"dogcat" と返す、catOrDog という関数を作成してください。

class Main {

    // catOrDog("1112002102")  dog
    // catOrDog("111222")  dogcat
    // catOrDog("1112222222")  cat


    public static void main(String[] args){
        System.out.println(catOrDog("1112222222"));
    }

    public static String catOrDog(String s){

        int cat = 0;
        int dog = 0;

        for(int i = 0; i < s.length() ; i ++){
            if(s.charAt(i) == '1') dog += 1;
            if(s.charAt(i) == '2') cat += 1;
        }

        if(cat > dog) return "cat";
        else if(cat == dog) return "dogcat";
        else return "dog";
    }
}

// 1 と同じ設定に対して、i 番目の生徒と i+1 番目の生徒の飼っているペットが同じとき、その二人は気が合うペアだとします。
// このクラスに気が合うペアが何組いるか返す、matchPetOwner という関数を作成してください。

class Main {

    // matchPetOwner("111")  2
    // matchPetOwner("111022121")  3
    // matchPetOwner("100202001")  0


    public static void main(String[] args){
        System.out.println(matchPetOwner("100202001")); // dog
    }

     public static int matchPetOwner(String s) {
        int countMatch = 0;
      
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) countMatch += 1;
        }
        return countMatch;
    }
}

// 例題1
// 自然数nが与えられるので、1からnまで文字列として出力するfizzbuzzという関数をwhile文を使って作成してください。
// ただし、3の倍数の時にはfizz、5の倍数の時にはbuzz、15の倍数の時にはfizzbuzzと出力してください。

// 例題2
// 自然数digitsが与えられるので、桁数を分解して足し合わせる、splitAndAddという関数をwhile文を使って作成してください。



// 例題3
// 数字を1桁ずつ分解して、それぞれの値を合計し、その値が1桁になるまで同じ作業を繰り返した時、それぞれの合計値を足し合わせて得られる値を返す、
// whileDigitsAddedという関数を例題2を使って作成してください。

class Main {
    

    public static void main(String[] args){
        // fizzbuzz(20);

        System.out.println(splitAndAdd(23387));
        System.out.println(whileDigitsAdded(23387));
    }

    public static void fizzbuzz(int m){

        int n = 0;
        while(m > n){
            n += 1;
            if(n % 5 == 0 && n % 3 == 0 ) System.out.println("fizzbuzz");
            else if(n % 5 == 0) System.out.println("buzz");
            else if(n % 3 == 0) System.out.println("fizz");
            else System.out.println(String.valueOf(n));
        }
        return;
    }

    public static int splitAndAdd(int digits){

        int total = 0;

        while(digits >= 10){           
            total += digits % 10;
            digits /= 10 ;
        }
        return digits + total;
    }

    public static int whileDigitsAdded(int digits){
        int total = 0;

        while(splitAndAdd(digits) >= 10){
            digits = splitAndAdd(digits);
            total += digits;
        }
        return  total + splitAndAdd(digits);
    }

}


// 素数
// easy
// Kate は音楽の野外フェスを行うことになり、入場者の中から抽選でプレゼントを渡す企画を立てています。
// そこで、素数の値で入場した方を当選者とすることにしました。入場者番号 number が与えられるので、素数かどうか判定する isPrime という関数を作成してください。

class Solution{
    public static boolean isPrime(int number){
        //ここから書きましょう
        return isPrimeHelper(number);
    }

    public static boolean isPrimeHelper(int number){
        
        for(int i = 2 ; i < number ; i++){
            if(number % i == 0)return false;
        }

        return number > 1;

    }
}

// 出席管理
// easy
// R 大学ではどの授業でも 3 回以上欠席すると、単位を取得できない制度です。
// Participate を表す P と Absence を表す A によって構成される文字列 string が与えられるので、
// 単位取得可能であれば pass、不可能であれば fail を返す、doYouFail という関数を作成してください。

class Solution{
    public static String doYouFail(String string){
        //ここから書きましょう
        int count = 0;

        for(int i = 0; i < string.length() ; i++){
            if(string.charAt(i) == 'A') count += 1;
            if(count >= 3)return "fail";
        }
        
        return "pass";
    }
}


// 割り切れない
// easy
// Jane は体育祭実行委員会に所属しており、クラスから複数人お手伝いを呼ばなければなりません。
// そこで、出席番号がある特定の値で割り切れない人を呼ぼうと考えています。
// クラスの人数 x、値 y が与えられるので、お手伝いの出席番号を全て返す関数 notDivided を作成してください。ただし（x,y）≠（1,1）とします。

class Solution{
    public static String notDivided(int x,int y){
        //ここから書きましょう
        String message = "";
        for(int i = 1; i <= x ; i++){
            if(i % y != 0)message += i + "-";
        }
        return message.substring(0, message.length() - 1);
    }
}


class Solution{
    public static String notDivided(int x,int y){
        //ここから書きましょう
        String message = "";
        for(int i = 1; i <= x ; i++){
            if(i % y != 0)message += i + "-";
        }
        return message.substring(0, message.length() - 1);
    }
}


// 10進数から16進数への書き換え
// medium
// Zayn は 16 進数しか使えない世界は飛ばされてしまったため、自動で 10 進数を 16 進数へ変えるプログラムを作ることにしました。
// 正の 10 進数 decNumber が与えられるので、16 進数に書き換える decimalToHexadecimal という関数を作成してください。

class Solution{
    public static String decimalToHexadecimal(int decNumber){
      
    String hexadecimal = "0123456789ABCDEF";
    String hex = "";
    int currentHex = 0;

    while(decNumber > 0){
        currentHex = decNumber % 16;
        hex = hexadecimal.charAt(currentHex) + hex ;
        decNumber = (int)Math.floor(decNumber/16);
    }

    return hex;


    
}



// ここから書いてください
class Animal{
    // 状態
    String name: // 動物の名前
    String species: // 動物の種
    String description: // 動物の説明
    double weightKg: // 動物の体重kg
    double heightM: // 動物の身長(垂直に立ち上がった時の身長を指す)メートル
    bool isPredator: // 動物は捕食者かどうか
    double speedKph: // 動物の時速
    String urlPic: // 動物の写真のURL
    String registerDate: // 動物園に登録された日付(例.2020/04/03)
    // 状態 - クラス変数
    static double activityMultiplier = 1.2: 
    // どれほど動物が活発的か表す数字。動物園の動物は檻に入れられているので活動が制限されているとみなし、活動指数を1.2とします。


    // 挙動
    public String getStateString(){
        return this.name;
    } 
    
    public double getBmi(){
        return this.weightKg / (this.heightM * this.heightM);
    } // 動物のBMIを返します。BMIの公式 kg/(height2) を使ってください。
    
    public double getDailyCalories(){
        return (70 * Math.pow(this.weightKg,0.75)) * this.activityMultiplier;
    }
       
    public bool isDangerous(){
        if(this.isPredator || this.heightM > 1.7 || this.speedKph > 35)return true;
        return false;
    }
    
    // 動物が危険かどうか判断するブーリアン値を返します。動物が捕食者だった場合、危険とみなされ、身長が1.7メートル以上、もしくは時速35km/h以上の場合も危険とみなされます。
bool isFaster(animal): // 動物のオブジェクトを受け取り、動物のオブジェクトがパラメータの入力として渡された動物より速いかどうか判断します。
}
// 状態: name, species, description, weightKg, heightM, isPredator, speedKph, urlPic, registerDate

// 入力例1:
// rabbit = Animal("rabbit", "leporidae", "Rabbits are small mammals in the family Leporidae of the order Lagomorpha (along with the hare and the pika).", 10, 0.3, False, 20, "img1", "2020/5/25")

// 出力例1
// rabbit.getStateString() : "name: rabbit, species: leporidae, description: Rabbits are small mammals in the family Leporidae of the order Lagomorpha (along with the hare and the pika)., weight: 10kg, height: 0.3m, Not Predator, speed: 20kph, urlPic: img1, registerDate: 2020/5/25"
// rabbit.getBmi() : 111.11111111111111
// rabbit.getDailyCalories() : 472.36671315989327
// rabbit.isDangerous() : false

// 入力例2:
// elephant = Animal("elephant", "Elephantidae", "Elephants are mammals of the family Elephantidae and the largest existing land animals.", 300, 3, False, 5, "img2", "2020/5/26")

// 出力例2
// elephant.getStateString() : "name: elephant, species: Elephantidae, description: Elephants are mammals of the family Elephantidae and the largest existing land animals., weight: 300kg, height: 3m, Not Predator, speed: 5kph, urlPic: img2, registerDate: 2020/5/26"
// elephant.getBmi() : 33.333333333333336
// elephant.getDailyCalories() : 6055.08476361958
// elephant.isDangerous() : true
// elephant.isFaster(rabbit) : false
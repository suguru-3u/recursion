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




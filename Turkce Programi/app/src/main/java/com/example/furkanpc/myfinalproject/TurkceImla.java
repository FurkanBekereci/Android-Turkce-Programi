package com.example.furkanpc.myfinalproject;

/**
 * Created by FurkanPC on 12.01.2017.
 */

public class TurkceImla {

    private String s ;
    private String []sonuç;
    int counter = 0;
    int a = 0,b = 0,c = 0 ,d = 0,e = 0,f = 0,g = 0,h = 0,j = 0,k = 0,l = 0,m = 0;

    public TurkceImla(String s){
        this.s = s;
    }

    public boolean BuyukUnluUyumu(String x){			//Büyük ünlü uyumuna uyup uymadığını kontrol eder.

        String temp = "" ;
        for(int i = 0 ; i < x.length() ; i++){
            if(x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'ı' || x.charAt(i) == 'i'
                    || x.charAt(i) == 'u' || x.charAt(i) == 'ü' || x.charAt(i) == 'o' || x.charAt(i) == 'ö'){
                temp += "" + x.charAt(i);
            }
        }

        int counter1 = 0 , counter2 = 0;

        for(int j = 1 ; j < temp.length() ; j++){
            if(temp.charAt(0) == 'a' || temp.charAt(0) == 'ı' || temp.charAt(0) == 'o' || temp.charAt(0) == 'u'){
                if(temp.charAt(j) == 'a' || temp.charAt(j) == 'ı' || temp.charAt(j) == 'o' || temp.charAt(j) == 'u')
                    counter1++;
            }
            else{
                if(temp.charAt(j) == 'e' || temp.charAt(j) == 'i' || temp.charAt(j) == 'ö' || temp.charAt(j) == 'ü')
                    counter2++;
            }
        }

        if(counter1 == temp.length()-1 || counter2 == temp.length()-1)
            return false;
        else
            return true;
    }

    public boolean KucukUnluUyumu(String x){			//Küçük ünlü uyumuna uyup uymadığını kontrol eder.

        String temp = "" ;
        for(int i = 0 ; i < x.length() ; i++){
            if(x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'ı' || x.charAt(i) == 'i'
                    || x.charAt(i) == 'u' || x.charAt(i) == 'ü' || x.charAt(i) == 'o' || x.charAt(i) == 'ö'){
                temp += "" + x.charAt(i);
            }
        }
        int count1 = 0,count2 = 0,count3 = 0;
        for(int j = 0 ; j < temp.length() ; j++){
            if(temp.charAt(0) == 'a' || temp.charAt(0) == 'e' || temp.charAt(0) == 'ı' || temp.charAt(0) == 'i'){
                if(temp.charAt(j) == 'a' || temp.charAt(j) == 'e' || temp.charAt(j) == 'ı' || temp.charAt(j) == 'i')
                    count1++;
            }
            if(temp.charAt(0) == 'o' || temp.charAt(0) == 'ö' || temp.charAt(0) == 'u' || temp.charAt(0) == 'ü'){
                if(temp.charAt(1) == 'a' || temp.charAt(1) == 'e'){
                    for(int a = 2 ; a < temp.length() ; a++){
                        if(temp.charAt(a) == 'a' || temp.charAt(a) == 'e')
                            count2++;
                    }
                }

                for(int b = 1 ; b < temp.length() ; b++){
                    if(temp.charAt(b) == 'u' || temp.charAt(b) == 'ü') count3++;
                    else break;
                }

                if(count3 == temp.length()-1) return false;
                else{
                    for(int c = count3 ; c < temp.length() ; c++){
                        if(temp.charAt(c) != 'u' || temp.charAt(c) != 'ü')
                            return true;
                    }
                }

            }
        }

        System.out.println(count1 + "" + count2 +""+ count3 +"");
        if(count1 == temp.length() || count2 == temp.length()-2) return false;
        else return true;
    }

    public boolean oö(String x){						//İlk heceden sonra o ya da ö harfleri bulunup bulunmadığına bakar.

        String temp = "" ;
        for(int i = 0 ; i < x.length() ; i++){
            if(x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'ı' || x.charAt(i) == 'i'
                    || x.charAt(i) == 'u' || x.charAt(i) == 'ü' || x.charAt(i) == 'o' || x.charAt(i) == 'ö'){
                temp += "" + x.charAt(i);
            }
        }

        for(int j = 1 ; j < temp.length() ; j++){
            if(temp.charAt(j) == 'o' || temp.charAt(j) == 'ö')
                return true;
        }

        return false;
    }

    public boolean uzunUnlu_InceA(String x){			//Uzun ünlü veya şapkalı a bulunup bulunmadığını kontrol eder.

        for(int i = 0 ; i < x.length() ; i++){
            if(x.charAt(i) == 'â' || x.charAt(i) == 'î' || x.charAt(i) == 'û')
                return true;
        }

        return false;
    }

    public boolean h_f_j_bulunmaz(String x){				//Türkçe kelimelerde h , f veya j harfi bulunmaz eğer bulunursa kök değişikliğe uğramıştır.

        for(int i = 0 ; i < x.length() ; i++){
            if(x.charAt(i) == 'h' || x.charAt(i) == 'f' || x.charAt(i) == 'j') return true;
        }
        return false;
    }

    public boolean sozcuk_basi(String x){				//Sözcük başında l, r, ğ, c, m, n, v, z harfleri bulunmaz.

        if(x.charAt(0) == 'l' || x.charAt(0) == 'r' || x.charAt(0) == 'ğ' || x.charAt(0) == 'c'
                || x.charAt(0) == 'm' || x.charAt(0) == 'n' || x.charAt(0) == 'v' || x.charAt(0) == 'z')
            return true;
        else
            return false;
    }

    public boolean ikiUnlu(String x){					//Türkçede iki ünlü yan yana bulunmaz.

        for(int i = 0 ; i < x.length()-1 ; i++){
            if(x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'ı' || x.charAt(i) == 'i'
                    || x.charAt(i) == 'u' || x.charAt(i) == 'ü' || x.charAt(i) == 'o' || x.charAt(i) == 'ö'){
                if(x.charAt(i+1) == 'a' || x.charAt(i+1) == 'e' || x.charAt(i+1) == 'ı' || x.charAt(i+1) == 'i'
                        || x.charAt(i+1) == 'u' || x.charAt(i+1) == 'ü' || x.charAt(i+1) == 'o' || x.charAt(i+1) == 'ö')
                    return true;
            }
        }
        return false;
    }

    public boolean ikiUnsuz(String x){					//Türkçede başta iki ünsüz yan yana bulunmaz.

        if(x.charAt(0) != 'a' && x.charAt(0) != 'e' && x.charAt(0) != 'ı' && x.charAt(0) != 'i'
                && x.charAt(0) != 'u' && x.charAt(0) != 'ü' && x.charAt(0) != 'o' && x.charAt(0) != 'ö'){
            if(x.charAt(1) != 'a' && x.charAt(1) != 'e' && x.charAt(1) != 'ı' && x.charAt(1) != 'i'
                    && x.charAt(1) != 'u' && x.charAt(1) != 'ü' && x.charAt(1) != 'o' && x.charAt(1) != 'ö')
                return true;
        }
        return false;
    }

    public boolean kokteAyniUnsuz(String x){			//Kökte aynı iki ünsüz yanyana gelmez.

        for(int i = 0 ; i < x.length()-1 ; i++){
            if(x.charAt(i) != 'a' && x.charAt(i) != 'e' && x.charAt(i) != 'ı' && x.charAt(i) != 'i'
                    && x.charAt(i) != 'u' && x.charAt(i) != 'ü' && x.charAt(i) != 'o' && x.charAt(i) != 'ö'){
                if(x.charAt(i) == x.charAt(i+1)) return true;
            }
        }
        return false;
    }

    public boolean sonHarf(String x){     				//Son harf b , c , d ,g ,ğ olmaz.

        if(x.charAt(x.length()-1) == 'b' || x.charAt(x.length()-1) == 'c' || x.charAt(x.length()-1) == 'd' || x.charAt(x.length()-1) == 'g' || x.charAt(x.length()-1) == 'ğ')
            return true;
        else
            return false;
    }

    public boolean uc_sessiz(String x){

        for(int i = 0 ; i < x.length()-2 ; i++){
            if(x.charAt(i) != 'a' && x.charAt(i) != 'e' && x.charAt(i) != 'ı' && x.charAt(i) != 'i'
                    && x.charAt(i) != 'u' && x.charAt(i) != 'ü' && x.charAt(i) != 'o' && x.charAt(i) != 'ö'){
                if(x.charAt(i+1) != 'a' && x.charAt(i+1) != 'e' && x.charAt(i+1) != 'ı' && x.charAt(i+1) != 'i'
                        && x.charAt(i+1) != 'u' && x.charAt(i+1) != 'ü' && x.charAt(i+1) != 'o' && x.charAt(i+1) != 'ö'){
                    if(x.charAt(i+2) != 'a' && x.charAt(i+2) != 'e' && x.charAt(i+2) != 'ı' && x.charAt(i+2) != 'i'
                            && x.charAt(i+2) != 'u' && x.charAt(i+2) != 'ü' && x.charAt(i+2) != 'o' && x.charAt(i+2) != 'ö')
                        return true;
                }
            }
        }
        return false;
    }

    public char u_ü_uyumu(String x){

        String temp = "" ;
        for(int i = 0 ; i < x.length() ; i++){
            if(x.charAt(i) == 'a' || x.charAt(i) == 'e' || x.charAt(i) == 'ı' || x.charAt(i) == 'i'
                    || x.charAt(i) == 'u' || x.charAt(i) == 'ü' || x.charAt(i) == 'o' || x.charAt(i) == 'ö'){
                temp += "" + x.charAt(i);
            }
        }

        for(int a = 0 ; a < temp.length() ; a++){

        }

        return (Character) null;
    }

    public String[] getResult(){
        sonuç = new String[20];
        if(oö(s) == true){
            counter++;
            if(a == 0) sonuç[counter] = "-Kelimede ilk heceden sonra o veya ö harfi bulunduğu için kelime Türkçe değildir.\n";
            a++;
        }
        if(BuyukUnluUyumu(s) == true){
            counter++;
            if(b == 0) sonuç[counter] =  "-Kelime büyük ünlü uyumuna uymadığı için Türkçe değildir.\n";
            b++;
        }
        if(KucukUnluUyumu(s) == true){
            if(c == 0)	sonuç[counter] = "-Kelime küçük ünlü uyumuna uymadığı için Türkçe değildir.\n";
            counter++;
            c++;
        }
        if(uzunUnlu_InceA(s) == true){
            if(d == 0)	sonuç[counter] = "-Kelimede şapkalı a(â) bulunduğu için kelime Türkçe değildir.\n";
            counter++;
            d++;
        }
        if(h_f_j_bulunmaz(s) == true){
            if(e == 0)	sonuç[counter] = "-Kelimede içinde h , f veya j harfi bulunduğu için kelime Türkçe değildir.\n";
            counter++;
            e++;
        }
        if(sozcuk_basi(s) == true){
            if(f == 0)	sonuç[counter] = "-Kelime l,r,ğ,c,v,m,n,z harflerinden biriyle başladığı için Türkçe değildir.\n";
            counter++;
            f++;
        }
        if(ikiUnlu(s) == true){
            if(g == 0)	sonuç[counter] = "-Kelimede iki ünlü yanyana geldiği için kelime Türkçe değildir.\n";
            counter++;
            g++;
        }
        if(ikiUnsuz(s) == true){
            if(j == 0)	sonuç[counter] = "-Kelimenin başında iki ünsüz yanyana geldiği için kelime Türkçe değildir.\n";
            counter++;
            j++;
        }
        if(sonHarf(s) == true){
            if(k == 0)	sonuç[counter] = "-Kelime b,c,d,g,ğ harflerinden biriyle bittiği için Türkçe değildir.\n";
            counter++;
            k++;
        }
        if(kokteAyniUnsuz(s) == true){
            if(l == 0)	sonuç[counter] = "-Kelimede aynı iki ünsüz yanyana bulunduğu için kelime Türkçe değildir.\n";
            counter++;
            l++;
        }
        if(uc_sessiz(s) == true){
            if(m == 0)	sonuç[counter] = "-Kelimede üç ünsüz yanyana bulunduğu için kelime Türkçe değildir.\n";
            counter++;
            m++;
        }
        if(counter == 0) sonuç[counter] = "Kelime Türkçedir.\n(NOT : Kelimedeki harf ve ses değişiklikleri dikkate alınmamıştır.)";

        return sonuç;
    }
}



class Solution {
    
    public String intToRoman(int num) {
        String romanString = "";

        if(num / 1000 > 0){
            int itr = num / 1000;
            while(itr-- > 0){
                romanString += "M";
                num -= 1000;
            }
        }

        if(num / 900 > 0){
            int itr = num / 900;
            while(itr-- > 0){
                romanString += "CM";
                num -= 900;
            }
        }

        if(num / 500 > 0){
            int itr = num / 500;
            while(itr-- > 0){
                romanString += "D";
                num -= 500;
            }
        }

        if(num / 400 > 0){
            int itr = num / 400;
            while(itr-- > 0){
                romanString += "CD";
                num -= 400;
            }
        }

        if(num / 100 > 0){
            int itr = num / 100;
            while(itr-- > 0){
                romanString += "C";
                num -= 100;
            }
        }

        if(num / 90 > 0){
            int itr = num/90;
            while(itr-- > 0){
                romanString += "XC";
                num -= 90;
            }
        }

        if(num / 50 > 0){
            int itr = num/50;
            while(itr-- > 0){
                romanString += "L";
                num -= 50;
            }
        }

        if(num / 40 > 0){
            int itr = num / 40;
            while(itr-- > 0){
                romanString += "XL";
                num -= 40;
            }
        }

        if(num / 10 > 0){
            int itr = num / 10;
            while(itr-- > 0){
                romanString += "X";
                num -= 10;
            }
        }

        if(num / 9 > 0){
            int itr = num / 9;
            while(itr-- > 0){
                romanString += "IX";
                num -= 9;
            }
        }

        if(num / 5 > 0){
            int itr = num / 5;
            while(itr-- > 0){
                romanString += "V";
                num -= 5;
            }
        }

        if(num / 4 > 0){
            int itr = num / 4;
            while(itr-- > 0){
                romanString += "IV";
                num -= 4;
            }
        }

        while(num > 0){
            romanString += "I";
            num--;
        }

        return romanString;
    }
}
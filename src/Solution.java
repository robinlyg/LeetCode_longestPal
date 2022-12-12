import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

 Letters are case sensitive, for example, "Aa" is not considered a palindrome here.*/


class Solution {
    public static int longestPalindrome(String s) {
        //ex: "abccccdd" -> output: 7
        //b/c one longest palindrome that can be build is dccaccd, which has a length of 7
        if(s.length() == 1)
        {
            return 1;
        }
        HashMap<Character, Integer> t = table(s);

        if(t.size() == 1){
            return t.get(s.charAt(0));
        }

        int count = 0;
        boolean odd = false;
        boolean longOdd = false;

        //for each char in s look up its value if even add 1 to count if odd set odd to true
       for(Character c : t.keySet())
       {
           System.out.println("c= "+c);
            if (t.get(c) % 2 == 0) {
                System.out.println("C is even");
                System.out.println(t.get(c));
                count += t.get(c);
            } else if (t.get(c) == 1) {
                System.out.println("c is 1");
                System.out.println(t.get(c));
                odd= true;
            } else {
                System.out.println("large odd");

                if(longOdd){
                    System.out.println(t.get(c) - 1);
                    count+=(t.get(c) - 1);}
                else{
                    System.out.println(t.get(c));
                    count += t.get(c);
                    longOdd = true;
                }
            }

       }

        if(odd && !(longOdd)){
            count += 1;
        }

        return count;
    }

    public static HashMap<Character, Integer> table(String s)
    {
        HashMap<Character, Integer> table = new HashMap<>();
        //go through each char add to table and make a count
        for(int i = 0; i < s.length(); i++){

            //if table is empty add
            if(table.isEmpty())
            {
                table.put(s.charAt(i),1);
            }
            //if not in the table add
            else if(!(table.containsKey(s.charAt(i)))){
                table.put(s.charAt(i),1);
            }
            else{
                table.replace(s.charAt(i), table.get(s.charAt(i))+1);
            }


            //if in table edit it's count

        }
        System.out.println(table);
        return table;
    }
    public static void main(String[] args) {
        String s = "bananas"; //naaan

        System.out.println(longestPalindrome(s));
       // table(s);
    }
}

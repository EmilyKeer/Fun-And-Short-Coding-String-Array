/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/


public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length()<=numRows) return s;
        ArrayList<String> results = new ArrayList<String>(numRows);
        for (int i=0; i<numRows; i++) {
            //results.get(i) = "";
            results.add("");
        }
        boolean even = false;
        int row = 0;
        for (int i=0; i<s.length(); i++) {
            results.set(row, results.get(row) + s.charAt(i));
            if (numRows == 2) {
                if(row == 0) row = 1;
                else row =0;
                continue;
            }
            if (!even) {
               row++; 
               if (row == numRows) {
                   
                   row = numRows - 2; 
                   even = true;                
               }
            } else {
                row--;
                    if (row == 0) {
                    even = false;
                }
            }
              
        }
        String totalResult = new String();
        for (int i=0; i<numRows; i++) {
            //totalResult.add(results.get(i));
            totalResult = totalResult + results.get(i);
        }
        return totalResult;
    }
}


//string builder optimize
public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
    
    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}

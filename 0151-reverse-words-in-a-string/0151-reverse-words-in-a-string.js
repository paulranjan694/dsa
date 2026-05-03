/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let n = s.length, i=n-1, ans = "",j=i;
    s=s.trim();
    while(i>=0){
        let j=i;
        while(i>=0 && s[i] !== " "){
            i--;
        }
        ans+= s.substring(i+1,j+1)+" ";
        while(i>=0 && s[i] === " "){
            i--;
        }
    }
    return ans.trim();
};
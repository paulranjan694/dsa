/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
    let n = s.length, i=0,j=n-1;

    while(i<=j){
        swap(s,i,j)
        i++;
        j--;
    }

};

var swap = function(s, i, j){
    let t = s[i];
    s[i]=s[j];
    s[j]=t;
}
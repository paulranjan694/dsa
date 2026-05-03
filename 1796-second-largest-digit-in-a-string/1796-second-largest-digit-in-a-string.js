/**
 * @param {string} s
 * @return {number}
 */
var secondHighest = function(s) {
    let sec=-1,lar=-1;
    for(let c of s){
        if(c-'0' >= 0 && c - '0' <= 9){
            let num = parseInt(c);
            if(num > lar){
                sec = lar;
                lar=num;
            }else if(num > sec && num != lar){
                sec=num;
            }
        }
    }

    return sec;
};
class ProductOfNumbers {
    //List<Integer> list = null;
   List<Integer> pp = null;
    public ProductOfNumbers() {
        //list = new ArrayList<>();
        pp = new ArrayList<>();
    }
    
    public void add(int num) {
       // list.add(num);
        if(num==0){
            pp = new ArrayList<>();
           // pp.add(1);
        }else{  
            if(pp.size() == 0){
                pp.add(num);
            }else{
                int p = pp.get(pp.size()-1);
                p *= num;
                pp.add(p);
            }
        }


    }
    
    public int getProduct(int k) {
        if(pp.size() == k) 
            return pp.get(pp.size() - 1);
        if(pp.size()-k-1 < 0) return 0; //handling 0 case, as we re-init the list so 'k' elements don't exists in list
        return pp.get(pp.size() - 1)/pp.get(pp.size() - k-1);
        // int p = 1;
        // for(int i = list.size() - k;i<list.size();i++){
        //     p *= list.get(i);
        // }
        // return p;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
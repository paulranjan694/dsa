// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peekedElement;
    private boolean isPeeked;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator=iterator;
        isPeeked=false;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(isPeeked){
            return peekedElement;
        }
        isPeeked=true;
        peekedElement=iterator.next();
        return peekedElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!isPeeked){
            return iterator.next();
        }
        Integer result = peekedElement;
        peekedElement=null;
        isPeeked=false;
        return result;
	}
	
	@Override
	public boolean hasNext() {
	    return isPeeked || iterator.hasNext();
	}
}
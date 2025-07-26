/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    

    private String getHostName(String url){
        return url.split("/")[2];
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String startHostName = getHostName(startUrl);
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);
        Set<String> visited = new HashSet<>(Arrays.asList(startUrl));

        while(!queue.isEmpty()){
            String url = queue.remove();
            for(String nextUrl : htmlParser.getUrls(url)){
                if(getHostName(nextUrl).equals(startHostName) && !visited.contains(nextUrl)){
                    queue.add(nextUrl);
                    visited.add(nextUrl);
                }
            }
        }

        return new ArrayList<>(visited);
    }
}
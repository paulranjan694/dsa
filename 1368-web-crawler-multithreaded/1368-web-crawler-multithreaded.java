/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> result = ConcurrentHashMap.newKeySet();
        String hostname = getHostname(startUrl);

        ExecutorService executor = Executors.newFixedThreadPool(64);
        result.add(startUrl);
        crawl(result, startUrl, hostname, executor, htmlParser);
        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(result);
    }

    private String getHostname(String url) {
        int idx = url.indexOf('/', 7);
        return (idx != -1) ? url.substring(0, idx) : url;
    }

    private void crawl(Set<String> result, String start, String hostname, ExecutorService executor, HtmlParser htmlParser) {
        List<Future> futures = new ArrayList<>();
        for (String url : htmlParser.getUrls(start)) {
            if (url.startsWith(hostname) && result.add(url)) {
                futures.add(executor.submit(() -> crawl(result, url, hostname, executor,htmlParser)));
            }
        }
        for (Future f : futures) {
            try {
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
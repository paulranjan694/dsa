import java.util.*;
import java.util.concurrent.*;

/**
 * // This is the HtmlParser's API interface.
 * interface HtmlParser {
 *     public List<String> getUrls(String url);
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = ConcurrentHashMap.newKeySet();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        String hostname = getHostname(startUrl);
        visited.add(startUrl);
        queue.offer(startUrl);

        ExecutorService executor = Executors.newFixedThreadPool(64);
        List<Future<?>> futures = new ArrayList<>();

        // Spawn 32 worker threads
        for (int i = 0; i < 64; i++) {
            futures.add(executor.submit(() -> {
                while (true) {
                    String currentUrl = null;
                    try {
                        currentUrl = queue.poll(1, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }

                    if (currentUrl == null) break;

                    for (String nextUrl : htmlParser.getUrls(currentUrl)) {
                        if (nextUrl.startsWith(hostname) && visited.add(nextUrl)) {
                            queue.offer(nextUrl);
                        }
                    }
                }
            }));
        }

        // Wait for all tasks to complete
        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return new ArrayList<>(visited);
    }

    private String getHostname(String url) {
        int idx = url.indexOf('/', 7);
        return (idx != -1) ? url.substring(0, idx) : url;
    }
}

package URLShortener;

import java.util.HashMap;
import java.util.Random;

public class URLShortener {
    private HashMap<String, String> urlMap;
    private Random random;
    private String characters;
    private int shortUrlLength;

    public URLShortener() {
        urlMap = new HashMap<>();
        random = new Random();
        characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        shortUrlLength = 6; // Length of the generated short URLs
    }

    public String shortenURL(String longUrl) {
        String shortUrl = generateShortUrl();

        urlMap.put(shortUrl, longUrl);

        return shortUrl;
    }

    public String getLongURL(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    private String generateShortUrl() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < shortUrlLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String longUrl = "https://www.google.com";
        String shortUrl = shortener.shortenURL(longUrl);

        System.out.println("Long URL: " + longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Retrieved Long URL: " + shortener.getLongURL(shortUrl));
    }
}

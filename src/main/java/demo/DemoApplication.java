package demo;

public class DemoApplication {

  public static void main(String[] args) {
    //SpringApplication.run(DemoApplication.class, args);
    String word = "abcdefghijklmno";
    StringBuilder[] result = parts(word, 2);

    int bucketIndex = 0;
    int [] counters = new int[result.length];
    int idx = 0;
    int lineControl = 0;
    int lineSize = result[idx].length();
    for (int i = 0; i < word.length(); i++) {
      if (lineControl == lineSize) {
        System.out.println();
        lineSize = result[++idx].length();
        lineControl = 0;
      }
      if(bucketIndex == result.length){
        bucketIndex = 0;
      }
      System.out.print(result[bucketIndex].charAt(counters[bucketIndex]++));
      bucketIndex++;
      lineControl++;
    }
    System.out.println();
  }

  private static StringBuilder[] parts(String word, int split) {
    int bucketIndex = 0;
    StringBuilder[] bucket = new StringBuilder[split];
    for (int i = 0; i < word.length(); i++) {
      char letter = word.charAt(i);
      if(bucketIndex == bucket.length){
        bucketIndex = 0;
      }
      if(bucket[bucketIndex] == null){
        bucket[bucketIndex] = new StringBuilder();
      }
      bucket[bucketIndex].append(letter);
      bucketIndex++;
    }

    return bucket;
  }

}
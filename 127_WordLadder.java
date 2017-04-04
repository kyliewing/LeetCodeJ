//One-End BFS
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        if(wordSet.size()==0) return 0;
        if(!wordSet.contains(endWord)) return 0;
        Set<String> toVisit = new HashSet();
        toVisit.add(beginWord);
        int dist=1;
        while(!toVisit.isEmpty()){   //notic set.isEmpty()
            Set<String> temp = new HashSet();
            for(String word: toVisit){
                if(word.equals(endWord))
                    return dist;
                char[] wordArray = word.toCharArray();  //notice this line
                for (int i=0;i<wordArray.length;i++){
                    char old=wordArray[i];
                    for(char c='a';c<='z';c++){
                        wordArray[i]=c;
                        String replaced = String.valueOf(wordArray);  //notice this line
                        if(wordSet.size()>0 && wordSet.contains(replaced)){
                            temp.add(replaced);
                            wordSet.remove(replaced);
                        }
                    }
                    wordArray[i]=old;
                }
            }
            toVisit=temp;
            dist++;
        }
        return 0;
    }
}


//Two-End BFS
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        if(wordSet.size()==0) return 0;
        if(!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet(), endSet = new HashSet();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int dist=2;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> temp = new HashSet();
            if(beginSet.size()>endSet.size()){
                Set<String> swap = new HashSet();
                swap=beginSet;
                beginSet=endSet;
                endSet=swap;
            }
            for(String word: beginSet){
                char[] wordArray = word.toCharArray();  //notice this line
                for(int i=0;i<wordArray.length;i++){
                    char old=wordArray[i];
                    for(char c='a';c<='z';c++){
                        wordArray[i]=c;
                        String replaced=String.valueOf(wordArray); //notice this line
                        if(endSet.contains(replaced))
                            return dist;
                        if(wordSet.contains(replaced)){
                            temp.add(replaced);
                            wordSet.remove(replaced);
                        }
                    }
                    wordArray[i]=old;
                }
            }
            beginSet=temp;
            dist++;
        }
        return 0;
    }
}







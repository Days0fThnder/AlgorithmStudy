package google;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    class TrieNode{
        Character value;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean endOfWord;
        boolean visted;

        public TrieNode(){
        }

        public TrieNode(Character value){
            this.value = value;
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
    }

    Trie trieTree = new Trie();
    void insertContact(String contact){

        if(contact == null || contact.length() == 0){
            return;
        }
        TrieNode current = trieTree.root;
        for (Character ch: contact.toCharArray()){
            if(current.children.containsKey(ch)){
                current = current.children.get(ch);
            }else{
                TrieNode node = new TrieNode(ch);
                current.children.put(ch, node);
                current = node;
            }
        }
        current.endOfWord = true;
    }

    private int lookupContact(String contact) {
        if(contact == null || contact.length() == 0){
            return 0;
        }
        TrieNode current = trieTree.root;
        //int charCounter = 0;
        for (Character ch: contact.toCharArray()){
            if(!current.children.containsKey(ch)){
                return 0;
            }else {
                current = current.children.get(ch);
            }
        }

        return searchWords(current);//current.children.keySet()
    }
    private int searchWords(TrieNode node){
        int words = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        node.visted = true;
        queue.add(node);
        while(!queue.isEmpty()){
            TrieNode s = queue.remove();
            for (TrieNode n : s.children.values()){
                if(n.visted == false){
                    n.visted = true;
                    queue.add(n);
                }
                if(n.endOfWord == true){
                    words++;
                }
            }
        }
        return words;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int numOfContact = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if("add".equals(op)){
                sl.insertContact(contact);
            }else if ("find".equals(op)){
                numOfContact = sl.lookupContact(contact);
                System.out.println(numOfContact);
            }
        }
    }

}

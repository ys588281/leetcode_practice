package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge721 {

    public static void main(String[] args) {

    }
    Map<String, String> parents;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        Map<String, Set<String>> unions = new HashMap<>();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents.put(account.get(i), account.get(i));
                owners.put(account.get(i), account.get(0));
            }
        }

        for (List<String> account : accounts) {
            String p = find(account.get(1));

            for (int i = 2; i < account.size(); i++) {
                parents.put(find(account.get(i)), p);
            }
        }

        for (List<String> account : accounts) {
            String p = find(account.get(1));
            unions.putIfAbsent(p, new HashSet<>());
            for (int i = 1; i < account.size(); i++) {
                unions.get(p).add(account.get(i));
            }
        }


        List<List<String>> results = new ArrayList<>();
        for (String key : unions.keySet()) {
            String name = owners.get(key);
            List<String> list = new ArrayList<>(unions.get(key));
            Collections.sort(list);
            list.add(0, name);
            results.add(list);
        }

        return results;

    }

    public String find(String i) {
        if(i != parents.get(i)){
            parents.put(i, find(parents.get(i)));
        }
        return parents.get(i);
    }
}

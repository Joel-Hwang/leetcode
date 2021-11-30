package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class _721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for(int i = 0; i<accounts.size(); i++) accounts.set(i, clean(accounts.get(i)));
        do{
            for (int i = 0; i < accounts.size() - 1; i++) {
                for (int j = i + 1; j < accounts.size(); j++) {
                    List<String> temp = merge(accounts.get(i), accounts.get(j));
                    if(temp == null) continue;
                    accounts.set(i, temp);
                    accounts.set(j, null);
                }
            }
    
            for(int i = accounts.size()-1; i>=0; i--){
                if(accounts.get(i) == null) accounts.remove(i);
            }

        }while(!isClean(accounts));
        
        return accounts;
    }

    private boolean isClean(List<List<String>> accounts){
        for(int i = 0; i<accounts.size()-1; i++){
            for(int j = i+1; j<accounts.size(); j++){
                if(!accounts.get(i).get(0).equals(accounts.get(j).get(0))) continue;
                if(hasCommonEmail(accounts.get(i),accounts.get(j))) return false;
            }
        }
        return true;
    }

    private boolean hasCommonEmail(List<String> a, List<String> b){
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < b.size(); j++) {
                if (a.get(i).equals(b.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }


    private List<String> merge(List<String> a, List<String> b) {
        if( a== null || b == null) return null;
        if (!a.get(0).equals(b.get(0))) return null;
        if (!hasCommonEmail(a,b)) return  null;

        Set<String> mailSet = new HashSet<String>();
        for (int i = 1; i < a.size(); i++) mailSet.add(a.get(i));
        for (int i = 1; i < b.size(); i++) mailSet.add(b.get(i));
        List<String> newRow = new ArrayList<>(mailSet);
        Collections.sort(newRow);
        newRow.add(0, a.get(0));
        return newRow;
    }

    private List<String> clean(List<String> a) {
        if(a == null) return null;
        Set<String> aSet = new HashSet<>();
        for (int i = 1; i<a.size(); i++)
            aSet.add(a.get(i));
        List<String> aMail = new ArrayList<>(aSet);
        Collections.sort(aMail);
        aMail.add(0, a.get(0));
        return aMail;
    }

    public List<List<String>> accountsMerge2(List<List<String>> accounts) {

        List<List<String>> res = new ArrayList();
        for (List<String> row : accounts) {
            String name = row.get(0);
            List<String> mails = row.subList(1, row.size());
            Collections.sort(mails);
            List<String> newRow = new ArrayList<>();
            newRow.add(name);
            newRow.addAll(mails);
            res.add(newRow);
        }
        Collections.sort(res, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (o1.get(0).equals(o2.get(0))) {
                    return o1.get(1).compareTo(o2.get(1));
                } else
                    return o1.get(0).compareTo(o2.get(0));
            };
        });

        setMails(res, res.size() - 1);
        for (int i = res.size() - 2; i >= 0; i--) {
            List<String> preRow = res.get(i + 1);
            List<String> row = res.get(i);

            List<String> mergedMails = mergedMail(row, preRow);
            if (mergedMails == null) {
                setMails(res, i);
                continue;
            }
            mergedMails.add(0, row.get(0));
            res.set(i, mergedMails);
            res.remove(preRow);
        }

        return res;
    }

    private void setMails(List<List<String>> res, int i) {
        List<String> row = res.get(i);
        List<String> mergedMails = mergedMail(row);
        mergedMails.add(0, row.get(0));
        res.set(i, mergedMails);
    }

    private List<String> mergedMail(List<String> a, List<String> b) {
        if (!a.get(0).equals(b.get(0)))
            return null;
        boolean sholdMerge = false;
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < b.size(); j++) {
                if (a.get(i).equals(b.get(j))) {
                    sholdMerge = true;
                    break;
                }
            }
            if (sholdMerge)
                break;
        }
        if (!sholdMerge)
            return null;

        Set<String> mailSet = new HashSet<String>();
        for (int i = 1; i < a.size(); i++)
            mailSet.add(a.get(i));
        for (int i = 1; i < b.size(); i++)
            mailSet.add(b.get(i));

        List<String> mailList = new ArrayList<>(mailSet);
        Collections.sort(mailList);
        return mailList;
    }

    private List<String> mergedMail(List<String> a) {
        Set<String> mailSet = new HashSet<String>();
        for (int i = 1; i < a.size(); i++)
            mailSet.add(a.get(i));
        List<String> mailList = new ArrayList<>(mailSet);
        Collections.sort(mailList);
        return mailList;
    }

    @Test
    public void test() {
        List<String> r1 = Arrays.asList(new
        String[]{"John","johnsmith@mail.com","john_newyork@mail.com"});
        List<String> r2 = Arrays.asList(new
        String[]{"John","johnsmith@mail.com","john00@mail.com"});
        List<String> r3 = Arrays.asList(new String[]{"Mary","mary@mail.com"});
        List<String> r4 = Arrays.asList(new String[]{"John","johnnybravo@mail.com"});
        List<List<String>> param = new ArrayList<>();
        param.add(r1);
        param.add(r2);
        param.add(r3);
        param.add(r4);
        //accountsMerge(param);

        r1 = Arrays.asList(new
        String[]{"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"});
        r2 = Arrays.asList(new
        String[]{"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"});
        r3 = Arrays.asList(new
        String[]{"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"});
        r4 = Arrays.asList(new
        String[]{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"});
        List<String> r5 = Arrays.asList(new
        String[]{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"});
        param = new ArrayList<>();
        param.add(r1);
        param.add(r2);
        param.add(r3);
        param.add(r4);
        param.add(r5);
        //accountsMerge(param);

        r1 = Arrays.asList(new
        String[]{"David","David0@m.co","David1@m.co"});
        r2 = Arrays.asList(new
        String[]{"David","David3@m.co","David4@m.co"});
        r3 = Arrays.asList(new
        String[]{"David","David4@m.co","David5@m.co"});
        r4 = Arrays.asList(new
        String[]{"David","David2@m.co","David3@m.co"});
        r5 = Arrays.asList(new
        String[]{"David","David1@m.co","David2@m.co"});
        param = new ArrayList<>();
        param.add(r1);
        param.add(r2);
        param.add(r3);
        param.add(r4);
        param.add(r5);
        accountsMerge(param);

        r1 = Arrays.asList(new String[] { "David", "David0@m.co", "David0@m.co", "David1@m.co",
                "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co", "David6@m.co", "David7@m.co" });
        r2 = Arrays.asList(new String[] { "David", "David0@m.co", "David0@m.co", "David1@m.co",
                "David2@m.co", "David3@m.co", "David4@m.co", "David5@m.co", "David6@m.co", "David7@m.co" });
        r3 = Arrays.asList(new String[] { "David", "David2@m.co", "David18@m.co", "David19@m.co",
                "David20@m.co", "David21@m.co", "David22@m.co", "David23@m.co", "David24@m.co", "David25@m.co" });
        r4 = Arrays.asList(new String[] { "David", "David3@m.co", "David27@m.co", "David28@m.co",
                "David29@m.co", "David30@m.co", "David31@m.co", "David32@m.co", "David33@m.co", "David34@m.co" });
        r5 = Arrays.asList(new String[] { "David", "David1@m.co", "David9@m.co", "David10@m.co",
                "David11@m.co", "David12@m.co", "David13@m.co", "David14@m.co", "David15@m.co", "David16@m.co" });
        param = new ArrayList<>();
        param.add(r1);
        param.add(r2);
        param.add(r3);
        param.add(r4);
        param.add(r5);
        //accountsMerge(param);


        r1 = Arrays.asList(new String[] { "Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co" });
        r2 = Arrays.asList(new String[] { "Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co" });
        r3 = Arrays.asList(new String[] { "Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co" });
        r4 = Arrays.asList(new String[] { "Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co" });
        r5 = Arrays.asList(new String[] { "Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co" });
        param = new ArrayList<>();
        param.add(r1);
        param.add(r2);
        param.add(r3);
        param.add(r4);
        param.add(r5);
        //accountsMerge(param);
    }
}
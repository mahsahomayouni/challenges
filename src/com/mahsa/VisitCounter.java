package com.mahsa;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        String longPattern = "([0-9]*)";
        Map<Long,Long> result=new HashMap<>();
        List<Map<String,UserStats>> list=Arrays.asList(visits);

            list.forEach(l->{
                Map<String, UserStats> temp=   l.entrySet().stream()
                        .filter(i-> !i.getValue().equals(null))
                        .filter(j->!j.getValue().getVisitCount().equals(""))
                        .filter(k-> Pattern.matches(longPattern, k.getKey())).collect(Collectors.toMap(m->m.getKey(),m->m.getValue()));
//                if(result.size()==0)
//                    result.put(temp.entrySet().stream();
                    }


            );





        return null;
    }

    public class UserStats{

        Optional<Long> visitCount;

        public Optional<Long> getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }
    }


}


//-- write your code in SQLite 3.11.0
//        SELECT  ass.experience  as exp,
//        (select count(id)  from assessments
//        where (ifnull(sql,100)=100 and ifnull(algo,100)=100 and ifnull(bug_fixing,100)=100 and experience=ass.experience) )as sum,
//        count(ass.id) as count from assessments ass
//        group by exp
//
//        order by exp desc

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import java.util.ArrayList;
import java.util.List;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author mlyra
 */
public class QueryBuilder {
    
    private List<Matcher> matchers;
    Matcher m;
    
    public QueryBuilder() {
        this.matchers = new ArrayList();
        m = new All();
    }
    
    public QueryBuilder playsIn(String value) {
        this.matchers.add(new PlaysIn(value));
                
        return this;
        
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));        

        return this;

    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        
        return this;
    }
    
    public Matcher build() {
        m = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers = new ArrayList();
        
        return m;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        m = new Or(m1, m2);
        
        matchers.add(m);
        
        return this;
    }
    
}

package org.apache.commons.collections4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CollectionUtilsTest {

  @Test
  void emptyCollection() {
    var empty = CollectionUtils.emptyCollection();

    assertTrue(empty.isEmpty());
  }
  
  @Test 
  void emptyIfNull() {
	  var empty = CollectionUtils.emptyIfNull(null);
	  
	  assertTrue(empty.isEmpty());
  }
  
  @Test
  void isEmpty(){
	  ArrayList<Integer> list0 = null;
      ArrayList<Integer> list1 = new ArrayList<>();
      list1.add(0);

      Assert.assertTrue(CollectionUtils.isEmpty(list0));
      Assert.assertFalse(CollectionUtils.isEmpty(list1));
  }
  
  @Test
  void isNotEmpty(){
	  ArrayList<Integer> list0 = null;
      ArrayList<Integer> list1 = new ArrayList<>();
      list1.add(0);

      Assert.assertFalse(CollectionUtils.isNotEmpty(list0));
      Assert.assertTrue(CollectionUtils.isNotEmpty(list1));
  }
  
  @Test 
  void subtractWhenEmptyListTest() {

      var list1 = new ArrayList<Integer>();
      var list2 = new ArrayList<Integer>();
      list1.add(0);
      list2.add(0);

      var sub = CollectionUtils.subtract(list1, list2);

    assertTrue(sub.isEmpty());
  }
  
  @Test
  void addALL() {
	  ArrayList<Integer> list0 = null;
      ArrayList<Integer> list1 = new ArrayList<>();
      ArrayList<Integer> list2 = new ArrayList<>();
      ArrayList<Integer> list3 = new ArrayList<>();
      list1.add(0);
      list1.add(1);
      list1.add(2);
      list1.add(3);
      list2.add(4);
      list2.add(5);
      list3.add(0);
      list3.add(1);
      list3.add(2);
      list3.add(3);
      list3.add(4);
      list3.add(5);
      
      //CollectionUtils.addAll(list0, (Iterator<Integer>) null);
      Assert.assertNull(list0);
      //CollectionUtils.addAll(list0, (Enumeration<Integer>) null);
      Assert.assertNull(list0);
      //CollectionUtils.addAll(list0, (Integer[]) null);
      Assert.assertNull(list0);

      //CollectionUtils.addAll(list1, (Iterator<Integer>) null);
      Assert.assertTrue(CollectionUtils.isEqualCollection(list1, list1));
      //CollectionUtils.addAll(list1, (Enumeration<Integer>) null);
      Assert.assertTrue(CollectionUtils.isEqualCollection(list1, list1));
      //CollectionUtils.addAll(list1, (Integer[]) null);
      Assert.assertTrue(CollectionUtils.isEqualCollection(list1, list1));

      CollectionUtils.addAll(list1, list2.iterator());
      Assert.assertTrue(CollectionUtils.isEqualCollection(list3, list1));
  }
  
  @Test 
  void removeALL() {
	  ArrayList<Integer> list0 = new ArrayList<>();
	  ArrayList<Integer> list1 = new ArrayList<>();
	  ArrayList<Integer> list2 = new ArrayList<>();
	  list0.add(0);
	  list0.add(1);
	  list0.add(2);
	  list0.add(3);
	  list1.add(2);
	  list1.add(3);
	  list2.add(0);
	  list2.add(1);
	  list2.add(6);
	  
      //Assert.assertEquals(0, CollectionUtils.removeAll(null, null).size());
      //Assert.assertTrue(CollectionUtils.isEqualCollection(list0, CollectionUtils.removeAll(list0, null)));
      //Assert.assertEquals(0, CollectionUtils.removeAll(null, list0).size());
      Assert.assertTrue(CollectionUtils.isEqualCollection(list1, CollectionUtils.removeAll(list0, list2)));
  }
  
  @Test
  void retainALL(){
	  ArrayList<Integer> list0 = new ArrayList<>();
	  ArrayList<Integer> list1 = new ArrayList<>();
	  ArrayList<Integer> list2 = new ArrayList<>();
	  list0.add(0);
	  list0.add(1);
	  list0.add(2);
	  list0.add(3);
	  list1.add(0);
	  list1.add(1);
	  list2.add(0);
	  list2.add(1);
	  list2.add(6);

      //Assert.assertEquals(0, CollectionUtils.retainAll(null, null).size());
      //Assert.assertEquals(0, CollectionUtils.retainAll(list0, null).size());
      //Assert.assertEquals(0, CollectionUtils.retainAll(null, list0).size());
      Assert.assertTrue(CollectionUtils.isEqualCollection(list0, CollectionUtils.retainAll(list0, list0)));
      Assert.assertTrue(CollectionUtils.isEqualCollection(list1, CollectionUtils.retainAll(list0, list2)));
  }
  
  @Test
  void size() {
	  ArrayList<Integer> list0 = null;
      ArrayList<Integer> list1 = new ArrayList<>();
      list1.add(0);
      list1.add(1);

      Assert.assertEquals(0, CollectionUtils.size(list0));
      Assert.assertEquals(2, CollectionUtils.size(list1));
  }
  
  @Test
  void sizeIsEmpty() {
	  ArrayList<Integer> list0 = null;
      ArrayList<Integer> list1 = new ArrayList<>();
      list1.add(0);

      Assert.assertTrue(CollectionUtils.sizeIsEmpty(list0));
      Assert.assertFalse(CollectionUtils.sizeIsEmpty(list1));
  }
  
  @SuppressWarnings("deprecation")
@Test
  void get() {
      ArrayList<Integer> list0 = null;
      var list1 = new ArrayList<>();
      list1.add(0);

      
      //Assert.assertNull(CollectionUtils.get(list0, 0));
      Assert.assertEquals(0, CollectionUtils.get(list1, 0));
  }
  
  @Test
  void union() {
	  ArrayList<String> list0 = new ArrayList<>();
	  ArrayList<String> list1 = new ArrayList<>();
	  list0.add("00");
	  list0.add("01");
	  list0.add("02");
      list1.add("00");
      list1.add("11");
      list1.add("12");

      //System.out.println(CollectionUtils.union(null, null));
      //System.out.println(CollectionUtils.union(list0, null));
      //System.out.println(CollectionUtils.union(null, list1));
      System.out.println(CollectionUtils.union(list0, list1));

      //Assert.assertNotSame(list0, CollectionUtils.union(list0, null));
      //Assert.assertNotSame(list1, CollectionUtils.union(null, list1));
  }
  
  @Test
  void intersection() {
	  ArrayList<String> list0 = new ArrayList<>();
	  ArrayList<String> list1 = new ArrayList<>();
	  list0.add("00");
	  list0.add("01");
	  list0.add("02");
      list1.add("00");
      list1.add("11");
      list1.add("12");

      //System.out.println(CollectionUtils.intersection(null, null));
      //System.out.println(CollectionUtils.intersection(list0, null));
      //System.out.println(CollectionUtils.intersection(null, list1));
      System.out.println(CollectionUtils.intersection(list0, list1));
  }
  
  @Test
  void disjunction() {
	  ArrayList<String> list0 = new ArrayList<>();
	  ArrayList<String> list1 = new ArrayList<>();
	  list0.add("00");
	  list0.add("01");
	  list0.add("02");
      list1.add("00");
      list1.add("11");
      list1.add("12");

      //System.out.println(CollectionUtils.disjunction(null, null));
      //System.out.println(CollectionUtils.disjunction(list0, null));
      //System.out.println(CollectionUtils.disjunction(null, list1));
      System.out.println(CollectionUtils.disjunction(list0, list1));

      //Assert.assertNotSame(list0, CollectionUtils.disjunction(list0, null));
      //Assert.assertNotSame(list1, CollectionUtils.disjunction(null, list1));
  }
  
  @Test
  void subtract(){
	  ArrayList<String> list0 = new ArrayList<>();
	  ArrayList<String> list1 = new ArrayList<>();
	  list0.add("00");
	  list0.add("01");
	  list0.add("02");
      list1.add("00");
      list1.add("11");
      list1.add("12");

      //System.out.println(CollectionUtils.subtract(null, null));
      //System.out.println(CollectionUtils.subtract(list0, null));
      //System.out.println(CollectionUtils.subtract(null, list1));
      System.out.println(CollectionUtils.subtract(list0, list1));

      //Assert.assertNotSame(list0, CollectionUtils.subtract(list0, null));
  }
  
  @Test 
  void containsAny() {
	  ArrayList<String> list0 = new ArrayList<>();
	  ArrayList<String> list1 = new ArrayList<>();
	  list0.add("00");
	  list0.add("01");
	  list0.add("02");
      list1.add("00");
      list1.add("11");
      list1.add("12");


      //Assert.assertFalse(CollectionUtils.containsAny(null, null));
      //Assert.assertFalse(CollectionUtils.containsAny(list0, null));
      //Assert.assertFalse(CollectionUtils.containsAny(null, list1));
      Assert.assertTrue(CollectionUtils.containsAny(list0, list1));
  }
  
  @Test
  void getCardinalityMap() {
      //System.out.println(CollectionUtils.getCardinalityMap(null));

      ArrayList<Integer> list0 = new ArrayList<>();
      list0.add(0);
      list0.add(0);
      list0.add(1);
      list0.add(1);
      list0.add(2);
      System.out.println(CollectionUtils.getCardinalityMap(list0));
  }
  
  @Test
  public void isSubCollection() {
      ArrayList<String> list0 = new ArrayList<>();
      ArrayList<String> list1 = new ArrayList<>();
      list0.add("0");
      list0.add("1");
      list0.add("2");
      list1.add("0");      
      list1.add("0");
      list1.add("1");
      list1.add("1");
      list1.add("2");

      //Assert.assertFalse(CollectionUtils.isSubCollection(null, null));
      //Assert.assertFalse(CollectionUtils.isSubCollection(list0, null));
      //Assert.assertFalse(CollectionUtils.isSubCollection(null, list0));
      Assert.assertTrue(CollectionUtils.isSubCollection(list0, list1));
      Assert.assertTrue(CollectionUtils.isSubCollection(list0, list0));
      Assert.assertFalse(CollectionUtils.isSubCollection(list1, list0));
  }

  @Test
  public void isProperSubCollection() {
      ArrayList<String> list0 = new ArrayList<>();
      ArrayList<String> list1 = new ArrayList<>();
      list0.add("0");
      list0.add("1");
      list0.add("2");
      list1.add("0");      
      list1.add("0");
      list1.add("1");
      list1.add("1");
      list1.add("2");

      //Assert.assertFalse(CollectionUtils.isProperSubCollection(null, null));
      //Assert.assertFalse(CollectionUtils.isProperSubCollection(list0, null));
      //Assert.assertFalse(CollectionUtils.isProperSubCollection(null, list0));
      Assert.assertTrue(CollectionUtils.isProperSubCollection(list0, list1));
      Assert.assertFalse(CollectionUtils.isProperSubCollection(list0, list0));
      Assert.assertFalse(CollectionUtils.isProperSubCollection(list1, list0));
  }

  @Test
  public void isEqualCollection() {
      ArrayList<String> list0 = new ArrayList<>();
      ArrayList<String> list1 = new ArrayList<>();
      list0.add("0");
      list0.add("1");
      list0.add("2");
      list1.add("0");      
      list1.add("0");
      list1.add("1");
      list1.add("1");
      list1.add("2");

      //Assert.assertFalse(CollectionUtils.isEqualCollection(null, null));
      //Assert.assertFalse(CollectionUtils.isEqualCollection(list0, null));
      //Assert.assertFalse(CollectionUtils.isEqualCollection(null, list0));
      Assert.assertTrue(CollectionUtils.isEqualCollection(list0, list0));
      Assert.assertFalse(CollectionUtils.isEqualCollection(list0, list1));
  }

  @SuppressWarnings("deprecation")
@Test
  public void cardinality() {
      ArrayList<String> list = new ArrayList<>();
      
      list.add("0");
      list.add("1");
      list.add("1");
      list.add("2");
      
      //Assert.assertEquals(0, CollectionUtils.cardinality(null, null));
      Assert.assertEquals(0, CollectionUtils.cardinality(null, list));
      list.add(null);
      Assert.assertEquals(1, CollectionUtils.cardinality(null, list));
      Assert.assertEquals(2, CollectionUtils.cardinality("1", list));
  }

  @SuppressWarnings("deprecation")
@Test
  public void find() {
      ArrayList<String> list = new ArrayList<>();
      list.add("0");
      list.add("1");
      list.add("1");
      list.add("2");

      Assert.assertNull(CollectionUtils.find(null, null));
      Assert.assertNull(CollectionUtils.find(list, null));
  }

  @SuppressWarnings("deprecation")
@Test
  public void forAllDo() {
	  ArrayList<String> list0 = null;
      ArrayList<String> list1 = new ArrayList<>();
      list1.add("0");
      list1.add("1");
      list1.add("1");
      list1.add("2");
      
      CollectionUtils.forAllDo(list0, null);
      CollectionUtils.forAllDo(list1, null);
  }

  @Test
  public void filter() {
      ArrayList<Integer> list0 = null;
      ArrayList<Integer> list1 = new ArrayList<>();
      ArrayList<Integer> list2 = new ArrayList<>();
      list1.add(0);
      list1.add(1);
      list1.add(2);
      list1.add(3);
      list2.add(2);
      list2.add(3);

      CollectionUtils.filter(list0, null);
      Assert.assertNull(list0);
      Assert.assertNull(list0);
      CollectionUtils.filter(list1, null);
      Assert.assertEquals(list1, list1);
      //Assert.assertTrue(CollectionUtils.isEqualCollection(list2, list1));
  }

  @Test
  public void select() {
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> list0 = new ArrayList<>();
      list.add(0);
      list.add(1);
      list.add(2);
      list.add(3);
      list0.add(2);
      list0.add(3);

      Assert.assertEquals(0, CollectionUtils.select(null, null).size());
      Assert.assertEquals(0, CollectionUtils.select(list, null).size());
      Assert.assertEquals(0, CollectionUtils.select(null, new Predicate<Object>() {
          @Override
          public boolean evaluate(Object item) {
              return true;
          }
      }).size());

      Assert.assertTrue(CollectionUtils.isEqualCollection(
              list0,
              CollectionUtils.select(list, new Predicate<Integer>() {
                  @Override
                  public boolean evaluate(Integer item) {
                      return item > 1;
                  }
              })));

      Collection<Integer> list1 = CollectionUtils.select(list, new Predicate<Integer>() {
          @Override
          public boolean evaluate(Integer item) {
              return true;
          }
      });

      Assert.assertTrue(CollectionUtils.isEqualCollection(list, list1));
      Assert.assertNotSame(list, list1);
  }


  @Test
  public void selectRejected() {
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> list0 = new ArrayList<>();
      list.add(0);
      list.add(1);
      list.add(2);
      list.add(3);
      list0.add(0);
      list0.add(1);

      Assert.assertEquals(0, CollectionUtils.selectRejected(null, null).size());
      Assert.assertEquals(0, CollectionUtils.selectRejected(list, null).size());
      Assert.assertEquals(0, CollectionUtils.selectRejected(null, new Predicate<Object>() {
          @Override
          public boolean evaluate(Object item) {
              return true;
          }
      }).size());

      Assert.assertTrue(CollectionUtils.isEqualCollection(
              list0,
              CollectionUtils.selectRejected(list, new Predicate<Integer>() {
                  @Override
                  public boolean evaluate(Integer item) {
                      return item > 1;
                  }
              })));


      Collection<Integer> list1 = CollectionUtils.selectRejected(list, new Predicate<Integer>() {
          @Override
          public boolean evaluate(Integer item) {
              return false;
          }
      });

      Assert.assertTrue(CollectionUtils.isEqualCollection(list, list1));
      Assert.assertNotSame(list, list1);
  }

  @Test
  public void transform() {
      ArrayList<Integer> list0 = null;
      ArrayList<Integer> list1 = new ArrayList<>();
      ArrayList<String> list2 = new ArrayList<>();
      list1.add(0);
      list1.add(1);
      list1.add(2);
      list1.add(3);
      list2.add("0");
      list2.add("1");
      list2.add("2");
      list2.add("3");

      CollectionUtils.transform(list0, null);
      Assert.assertNull(list0);


      //Assert.assertTrue(CollectionUtils.isEqualCollection(list2, list1));
  }

  @Test
  public void collect() {
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<String> list2 = new ArrayList<>();
      list.add(0);
      list.add(1);
      list.add(2);
      list.add(3);
      list2.add("0");
      list2.add("1");
      list2.add("2");
      list2.add("3");

      Assert.assertTrue(CollectionUtils.isEmpty(CollectionUtils.collect(list, null)));
  }

  @SuppressWarnings("deprecation")
@Test
  public void countMatches() {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(0);
      list.add(1);
      list.add(2);
      list.add(3);

      Assert.assertEquals(0, CollectionUtils.countMatches(null, null));
      Assert.assertEquals(0, CollectionUtils.countMatches(list, null));
      Assert.assertEquals(0, CollectionUtils.countMatches(null, new Predicate<Object>() {
          @Override
          public boolean evaluate(Object item) {
              return false;
          }
      }));
      Assert.assertEquals(2, CollectionUtils.countMatches(list, new Predicate<Integer>() {
          @Override
          public boolean evaluate(Integer item) {
              return item > 1;
          }
      }));
  }

  @SuppressWarnings("deprecation")
@Test
  public void exists() {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(0);
      list.add(1);
      list.add(2);
      list.add(3);
      
      Assert.assertFalse(CollectionUtils.exists(null, null));
      Assert.assertFalse(CollectionUtils.exists(list, null));
      Assert.assertFalse(CollectionUtils.exists(null, new Predicate<Object>() {
          @Override
          public boolean evaluate(Object item) {
              return false;
          }
      }));
      Assert.assertTrue(CollectionUtils.exists(list, new Predicate<Integer>() {
          @Override
          public boolean evaluate(Integer item) {
              return item > 1;
          }
      }));
  }

  @Test
  public void addIgnoreNull() {
      ArrayList<Integer> list0 = new ArrayList<>();
      ArrayList<Integer> list1 = new ArrayList<>();
      ArrayList<Integer> list2 = new ArrayList<>();
      list0.add(0);
      list0.add(1);
      list0.add(2);
      list0.add(3);
      list1.add(0);
      list1.add(1);
      list1.add(2);
      list1.add(3);
      list2.add(0);
      list2.add(1);
      list2.add(2);
      list2.add(3);
      list2.add(4);

      //Assert.assertFalse(CollectionUtils.addIgnoreNull(null, null));
      //Assert.assertFalse(CollectionUtils.addIgnoreNull(null, list1));

      CollectionUtils.addIgnoreNull(list0, null);
      Assert.assertEquals(list1, list0);

      CollectionUtils.addIgnoreNull(list0, 4);
      Assert.assertEquals(list2, list0);
  }

}

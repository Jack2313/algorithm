package test.com.ljiangf.Sort; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import com.ljiangf.General.GeneralMethods;
import com.ljiangf.Sort.Sort;

import java.util.Arrays;

/** 
* Sort Tester. 
* 
* @author <Authors name> 
* @since <pre>11�� 20, 2020</pre> 
* @version 1.0 
*/ 
public class SortTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: bubbleSort(int[] array, int left, int right) 
* 
*/ 
@Test
public void testBubbleSort() throws Exception { 
//TODO: Test goes here...
    for(int i=0;i<100;i++){
        int[] a=GeneralMethods.gennerateArray(100,1000);
        int[] b=a.clone();
        Arrays.sort(b);
        Sort.bubbleSort(a, 0, a.length-1);
        //System.out.println(Arrays.toString(a));
        try{
            assert Arrays.equals(a, b);
        }catch (Exception e){
            System.out.println(a);
        }
    }
    System.out.println("Test success for BubbleSort");
} 

/** 
* 
* Method: mergeSort(int[] array, int left, int right) 
* 
*/ 
@Test
public void testMergeSort() throws Exception { 
//TODO: Test goes here...
    for(int i=0;i<100;i++){
        int[] a=GeneralMethods.gennerateArray(100,1000);
        int[] b=a.clone();
        Arrays.sort(b);
        Sort.mergeSort(a, 0, a.length-1);
        //System.out.println(Arrays.toString(a));
        try{
            assert Arrays.equals(a, b);
        }catch (Exception e){
            System.out.println(a);
        }
    }
    System.out.println("Test success for MergeSort");
} 

/** 
* 
* Method: quickSort(int[] array, int left, int right) 
* 
*/ 
@Test
public void testQuickSort() throws Exception { 
//TODO: Test goes here...
    for(int i=0;i<100;i++){
        int[] a=GeneralMethods.gennerateArray(100,1000);
        int[] b=a.clone();
        Arrays.sort(b);
        Sort.quickSort(a, 0, a.length-1);
        //System.out.println(Arrays.toString(a));
        try{
            assert Arrays.equals(a, b);
        }catch (Exception e){
            System.out.println(a);
        }
    }
    System.out.println("Test success for QuickSort");
} 

/** 
* 
* Method: heapSort(int[] array) 
* 
*/ 
@Test
public void testHeapSort() throws Exception { 
//TODO: Test goes here...
    for(int i=0;i<100;i++){
        int[] a=GeneralMethods.gennerateArray(100,1000);
        int[] b=a.clone();
        Arrays.sort(b);
        Sort.heapSort(a);
        //System.out.println(Arrays.toString(a));
        try{
            assert Arrays.equals(a, b);
        }catch (Exception e){
            System.out.println(a);
        }
    }
    System.out.println("Test success for HeapSort");
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: merge(int[] array, int left, int mid, int right) 
* 
*/ 
@Test
public void testMerge() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Sort.getClass().getMethod("merge", int[].class, int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: adjustHeap(int[] array, int i, int length) 
* 
*/ 
@Test
public void testAdjustHeap() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Sort.getClass().getMethod("adjustHeap", int[].class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 

package spring.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.Assert;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MyCollectionTest {

    @Mock
    List<String> mockList2;

    //initialize Mockito annotations
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    MyCollection myCollection;

    @Test
    public void size() {
        when(myCollection.size()).thenReturn(20);
    }

    //
    @Test
    public void whenNotUseMockAnnotation_thenCorrect(){

        //creation of mocked ArrayList
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        mockList.add("two");
        Mockito.verify(mockList).add("one");

        assertEquals(0,mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100,mockList.size());

    }

    @Test
    public void whenUserMockAnnotation_thanMockInjected(){
        mockList2.add("one");
        Mockito.verify(mockList2).add("one");
        assertEquals(0,mockList2.size());
        Mockito.when(mockList2.size()).thenReturn(100);
        assertEquals(100,mockList2.size());
    }

    //Mock.spy
    @Spy
    List<String> spyList = new ArrayList<String>();
    @Test
    public void whenUserSpyAnnotation_thanSpyIsInjectedCorrectly(){

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2,spyList.size());

        //Mockito.doReturn(100).when(spyList.size());
        Mockito.when(spyList.size()).thenReturn(100);
        assertEquals(100,spyList.size());
    }

    //InjectMocks - create mock object which will be injected to different mock with annotation @InjectMock

    @Mock
    Map<String,String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUserInjectMockAnnotation_thenCorrect(){
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
        assertEquals("aMeaning",dic.getMeaning("aWord"));
    }
}